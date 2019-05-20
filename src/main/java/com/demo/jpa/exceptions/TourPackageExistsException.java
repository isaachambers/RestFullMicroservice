package com.demo.jpa.exceptions;

public class TourPackageExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	private String code;
	private String name;

	public TourPackageExistsException(String message, String code, String name) {
		super();
		this.message = message;
		this.code = code;
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "TourPackageExistsException [message=" + message + ", code=" + code + ", name=" + name + "]";
	}

}
