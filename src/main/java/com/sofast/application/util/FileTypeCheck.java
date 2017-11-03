package com.sofast.application.util;

import com.sofast.application.exception.MsgException;
import net.sf.jmimemagic.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/*
 *
 * @author fjiang
 * @description 
 * @date 10/13/16
 */
public final class FileTypeCheck {

    public static boolean checkFileType(byte[] content, String type) throws MsgException {
        try {
            MagicMatch match = Magic.getMagicMatch(content);
            return match.mimeTypeMatches(type);
        } catch (MagicParseException | MagicMatchNotFoundException | MagicException e) {
            throw new MsgException("400", "Invalid file type", e);
        }
    }

    public static boolean checkUploadFileType(MultipartFile file, String type) throws MsgException {
        try {
            return checkFileType(file.getBytes(), type);
        } catch (IOException e) {
            throw new MsgException("400", "Invalid uploaded file type", e);
        }
    }

    public static boolean checkUploadFilePdfType(MultipartFile file) throws MsgException {
        return checkUploadFileType(file, "application/pdf");
    }
}
