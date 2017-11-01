package com.sofast.application.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


/**
 * Created by lliu on 7/18/16.
 */
@Slf4j
@Component
public class MailUtil {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.sender}")
    private String mailSender;

    public void send(String to, String subject, String content) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
//            helper.setReplyTo("someone@localhost");
            helper.setFrom(mailSender);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(mail);
        } catch (MessagingException  | MailException e) {
            log.error("send email", e);
        }
    }
}