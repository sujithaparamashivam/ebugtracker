package com.ebugtracker.staff.entity;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;



@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long staffId;
    @NotBlank
    @Length(max = 15, min = 1)
    private String staffName;
    @NotBlank
    @Length(max = 10, min = 1)
    private String department;
    @ElementCollection
    Set<Long> assignedTicketIds;
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Set<Long> getAssignedTicketIds() {
		return assignedTicketIds;
	}
	public void setAssignedTicketIds(Set<Long> assignedTicketIds) {
		this.assignedTicketIds = assignedTicketIds;
	}
	public Staff(long staffId, @NotBlank @Length(max = 15, min = 1) String staffName,
			@NotBlank @Length(max = 10, min = 1) String department, Set<Long> assignedTicketIds) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.department = department;
		this.assignedTicketIds = assignedTicketIds;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
