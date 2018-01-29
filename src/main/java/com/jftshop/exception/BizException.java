package com.jftshop.exception;


public class BizException extends RuntimeException {

    public static BizException  SYSTEM_ERR =  new BizException(10000000, "系统错误");
    public static BizException  PARAMS_ERR =  new BizException(10000002, "参数错误");


    /**
     * 异常信息
     */
    protected String msg;

    /**
     * 具体异常码
     */
    protected int code;

    public BizException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }


    public BizException() {
        super();
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message) {
        super(message);
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    /**
     * 实例化异常
     * 
     * @param msgFormat
     * @param args
     * @return
     */
    public static BizException newInstance(int code , String msgFormat, Object... args) {
        return new BizException( code , msgFormat, args );
    }

}
