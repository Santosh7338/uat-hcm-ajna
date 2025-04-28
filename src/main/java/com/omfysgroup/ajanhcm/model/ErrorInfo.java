package com.omfysgroup.ajanhcm.model;

import java.io.Serializable;

public class ErrorInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorCode;
	private String errorMsg;
	private String errorDesc;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ErrorInfo [errorCode=" + errorCode + ", errorMsg=" + errorMsg + ", errorDesc=" + errorDesc + "]";
	}

	public ErrorInfo(int errorCode, String errorMsg, String errorDesc) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.errorDesc = errorDesc;
	}

	public ErrorInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
