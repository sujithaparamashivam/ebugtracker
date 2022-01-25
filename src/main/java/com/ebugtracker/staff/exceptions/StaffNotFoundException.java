package com.ebugtracker.staff.exceptions;

public class StaffNotFoundException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StaffNotFoundException(String msg){
        super(msg);
    }
}
