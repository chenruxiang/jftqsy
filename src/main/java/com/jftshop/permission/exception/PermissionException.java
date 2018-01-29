package com.jftshop.permission.exception;


import com.jftshop.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PermissionException extends BizException {

	private static final Logger logger = LoggerFactory.getLogger(PermissionException.class);


	public PermissionException() {
	}

	public PermissionException(int code, String msgFormat, Object... args) {
		super(code, msgFormat, args);
	}

	public PermissionException(int code, String msg) {
		super(code, msg);
	}

	public static PermissionException newInstance(int code, String msgFormat, Object... args) {
		return new PermissionException( code, msgFormat, args);
	}

	public PermissionException print() {
		logger.info("==>BizException, code:" + this.code + ", msg:" + this.msg);
		return this;
	}
}
