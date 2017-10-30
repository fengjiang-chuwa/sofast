package com.sofast.application.exception;

/**
 * 功能说明：
 * 典型用法：
 * 特殊用法：
 * 创建者：lihong
 * 创建时间：十二月 11, 2015
 * 版本：1.0
 */
public class BaseException extends Exception {
    private String errorCode;

    /**
     * @param errorCode the error code
     * @author lihong
     * @date 十二月 11, 2015
     * Instantiates a new Base exception.
     */
    public BaseException(String errorCode) {
        super();
        this.errorCode = errorCode;
    }

    /**
     * @param errorCode the error code
     * @param message   the message
     * @author lihong
     * @date 十二月 11, 2015
     * Instantiates a new Base exception.
     */
    public BaseException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * @param errorCode the error code
     * @param message   the message
     * @param cause     the cause
     * @author lihong
     * @date 十二月 11, 2015
     * Instantiates a new Base exception.
     */
    public BaseException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    /**
     * @return the error code
     * @author lihong
     * @date 十二月 11, 2015
     * Gets error code.
     */
    public String getErrorCode() {
        return errorCode;
    }

}
