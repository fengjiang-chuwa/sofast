package com.sofast.application.exception;

/**
 * 功能说明：校验异常，数据校验不通过时抛出
 * 典型用法：
 * 特殊用法：
 * 创建者：lihong
 * 创建时间：十二月 11, 2015
 * 版本：1.0
 */
public class MsgException extends BaseException {

    /**
     * @param errorCode the error code
     * @author lihong
     * @date 十二月 11, 2015
     * Instantiates a new Msg exception.
     */
    public MsgException(String errorCode) {
        super(errorCode, errorCode);
    }

    /**
     * @param errorCode the error code
     * @param message   the message
     * @author lihong
     * @date 十二月 11, 2015
     * Instantiates a new Msg exception.
     */
    public MsgException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * @param errorCode the error code
     * @param message   the message
     * @param cause     the cause
     * @author lihong
     * @date 十二月 11, 2015
     * Instantiates a new Msg exception.
     */
    public MsgException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
