package com.insurance.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String fieldName;
	long value;
	String message;
	public ResourceNotFoundException(String resourceName, String fieldName, long value) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, value));
		this.message = String.format("%s not found with %s : %s", resourceName, fieldName, value);
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.value = value;
	}
	
	
	
}
