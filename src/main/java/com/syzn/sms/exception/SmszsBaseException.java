package com.syzn.sms.exception;

/**
 * 自定义错误类型
 */
public class SmszsBaseException extends Exception {
    /**
     * 错误代码
     */
    private int errcode;

    public SmszsBaseException(String message) {
        super(message);
        this.errcode = 1;
    }

    public SmszsBaseException(String message, Throwable t) {
        super(message, t);
        this.errcode = 1;
    }

    public SmszsBaseException(int errcode, String message) {
        super(message);
        this.errcode = errcode;
    }

    public SmszsBaseException(int errcode, String message, Throwable t) {
        super(message, t);
        this.errcode = errcode;
    }

    public int getErrcode() {
        return errcode;
    }
}
