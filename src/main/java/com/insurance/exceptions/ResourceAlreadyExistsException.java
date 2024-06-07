package com.insurance.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {

	String resourceName;
	String fieldName;
	String value;
	String message;
	public ResourceAlreadyExistsException(String resourceName, String fieldName, String value) {
		super(String.format("%s with %s : %s already exixts",resourceName, fieldName, value));
		this.message = String.format("%s with %s : %s already exixts",resourceName, fieldName, value);
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.value = value;
	}

}
