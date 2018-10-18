package com.odm.oa.common.basic.response;

public class FreshAirException extends Exception {

	private static final long serialVersionUID = 5330899151866165507L;

	public FreshAirException(String message, Throwable cause) {
		super(message, cause);
	}

	public FreshAirException(String message) {
		super(message);
	}
}
