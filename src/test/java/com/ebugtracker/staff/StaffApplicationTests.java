package com.ebugtracker.staff;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ebugtracker.staff.dao.IStaffRepository;
import com.ebugtracker.staff.entity.Bug;
import com.ebugtracker.staff.entity.Staff;
import com.ebugtracker.staff.service.StaffServiceImpl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;

 @ExtendWith(MockitoExtension.class)
class ApplicationTests {
	 
	 @Mock
	    IStaffRepository repository;

	 @Spy 
	 @InjectMocks
	 StaffServiceImpl service;
	 
	 Bug bug = new Bug();
	
	@Test
	void testBugSolution() {
		bug.setRemedy("Solved Successfully");
	assertNotNull(bug.getRemedy());
	}

	
}
