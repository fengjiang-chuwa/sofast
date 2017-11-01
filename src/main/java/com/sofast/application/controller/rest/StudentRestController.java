package com.sofast.application.controller.rest;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.sofast.application.entity.JsonResponse;
import com.sofast.application.entity.enums.StudentSendStatus;
import com.sofast.application.entity.request.StudentBasicEntity;
import com.sofast.application.exception.MsgException;
import com.sofast.application.model.StudentBasic;
import com.sofast.application.service.StudentBasicService;
import com.sofast.application.util.MailUtil;
import com.sofast.application.util.UUIDHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.List;

@Slf4j
@RestController
public class StudentRestController {

    private final StudentBasicService studentBasicService;

    private final MailUtil mailUtil;

    @Value("${mail.enroll.student.template}")
    private String mailTemplate;

    @Value("${mail.enroll.student.subject}")
    private String mailSubject;

    @Autowired
    public StudentRestController(StudentBasicService studentBasicService, MailUtil mailUtil) {
        this.studentBasicService = studentBasicService;
        this.mailUtil = mailUtil;
    }

    @GetMapping(value = "/studentdetail/search/result/")
    public List<StudentBasic> getCourse() throws MsgException {
        try {
            return studentBasicService.getList();
        } catch (Exception e) {
            log.error("getCourse", e);
            return Lists.newArrayList();
        }
    }

    @GetMapping(value = "/studentbasic/data/{studentBasicId}")
    public JsonResponse<StudentBasicEntity> getYearTerm(@PathVariable("studentBasicId") String studentBasicId)
            throws MsgException {
        try {
            StudentBasic studentBasic = studentBasicService.findById(studentBasicId);
            if (studentBasic == null) {
                return new JsonResponse<>(new StudentBasicEntity());
            } else {
                return new JsonResponse<>(new StudentBasicEntity(studentBasic));
            }
        } catch (Exception e) {
            log.error("saveCourse", e);
            return new JsonResponse<>(new StudentBasicEntity());
        }
    }

    @RequestMapping(value = "/studentbasic/save", method = RequestMethod.POST, produces = "application/json")
    public JsonResponse<String> saveCourse(@RequestBody StudentBasicEntity studentBasicEntity)
            throws MsgException {
        try {
            StudentBasic checkStudentBasic = studentBasicService.findByEmail(studentBasicEntity.getApplicantEmailAddress());
            if (checkStudentBasic != null) {
                if (!checkStudentBasic.getId().equalsIgnoreCase(studentBasicEntity.getId())) {
                    return new JsonResponse<>("The email has been already used.");
                }
            }
            if(Strings.isNullOrEmpty(studentBasicEntity.getId())){
                studentBasicEntity.setId(UUIDHelper.getUUID());
                studentBasicEntity.setStatus(StudentSendStatus.NEW.getKey());
                studentBasicEntity.setLinkId(UUIDHelper.getUUID());
            }
            StudentBasic studentBasic = new StudentBasic(studentBasicEntity);
            // TODO: 10/31/17 set phone number to phone id
            studentBasic.setPhoneId(studentBasicEntity.getPhoneNumber());
            studentBasicService.save(studentBasic);
            return new JsonResponse<>("success");
        } catch (Exception e) {
            log.error("saveCourse", e);
            return new JsonResponse<>("error");
        }
    }

    @GetMapping(value = "/student/send/mail/{studentBasicId}")
    public JsonResponse<String> sendEmail(@PathVariable("studentBasicId") String studentBasicId,
                                          HttpServletRequest request) throws MsgException {
        try {
            StudentBasic studentBasic = studentBasicService.findById(studentBasicId);
            if(studentBasic == null || Strings.isNullOrEmpty(studentBasic.getLinkId())){
                return new JsonResponse<>("error");
            }
            String link = request.getRequestURL().toString();
            link = link.substring(0, link.indexOf("/student/send/mail/"));
            link += "/student/" + studentBasic.getLinkId();
            String content = MessageFormat.format(mailTemplate, studentBasic.getFirstName(), link, link);
            mailUtil.send(studentBasic.getApplicantEmailAddress(), mailSubject, content);
            return new JsonResponse<>("success");
        } catch (Exception e) {
            log.error("sendEmail", e);
            return new JsonResponse<>("error");
        }
    }

}
