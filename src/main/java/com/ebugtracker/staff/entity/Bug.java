package com.ebugtracker.staff.entity;


import com.ebugtracker.staff.constants.BugPriority;
import com.ebugtracker.staff.constants.BugStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketNo;
    @Enumerated(EnumType.STRING)
    private BugPriority bugPriority;
    @NotBlank
    @Length(max = 1000, min = 1)
    private String snippet;
    private String remedy;
    @Enumerated(EnumType.STRING)
    private BugStatus bugStatus;
    @NotBlank
    @Length(max = 15, min = 1)
    private String relatedDepartment;
	public Long getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(Long ticketNo) {
		this.ticketNo = ticketNo;
	}
	public BugPriority getBugPriority() {
		return bugPriority;
	}
	public void setBugPriority(BugPriority bugPriority) {
		this.bugPriority = bugPriority;
	}
	public String getSnippet() {
		return snippet;
	}
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}
	public String getRemedy() {
		return remedy;
	}
	public void setRemedy(String remedy) {
		this.remedy = remedy;
	}
	public BugStatus getBugStatus() {
		return bugStatus;
	}
	public void setBugStatus(BugStatus bugStatus) {
		this.bugStatus = bugStatus;
	}
	public String getRelatedDepartment() {
		return relatedDepartment;
	}
	public void setRelatedDepartment(String relatedDepartment) {
		this.relatedDepartment = relatedDepartment;
	}
	public Bug(Long ticketNo, BugPriority bugPriority, @NotBlank @Length(max = 1000, min = 1) String snippet,
			String remedy, BugStatus bugStatus, @NotBlank @Length(max = 15, min = 1) String relatedDepartment) {
		super();
		this.ticketNo = ticketNo;
		this.bugPriority = bugPriority;
		this.snippet = snippet;
		this.remedy = remedy;
		this.bugStatus = bugStatus;
		this.relatedDepartment = relatedDepartment;
	}
	public Bug() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
