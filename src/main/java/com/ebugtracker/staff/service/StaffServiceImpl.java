package com.ebugtracker.staff.service;

import com.ebugtracker.staff.constants.BugStatus;
import com.ebugtracker.staff.dao.IBugRepository;
import com.ebugtracker.staff.dao.IStaffRepository;
import com.ebugtracker.staff.entity.Bug;
import com.ebugtracker.staff.entity.Staff;
import com.ebugtracker.staff.exceptions.BugNotFoundException;
import com.ebugtracker.staff.exceptions.InvalidBugAssignation;
import com.ebugtracker.staff.exceptions.StaffNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements IStaffService{
    @Autowired
    private IStaffRepository staffRepository;

    @Autowired
    private IBugRepository bugRepository;

    @Override
    public Staff findStaffById(Long id) {
        Optional<Staff> optional= staffRepository.findById(id);
        if(optional.isEmpty()){
            throw new StaffNotFoundException("Staff is not found for the id : "+id);
        }
        return optional.get();
    }
    
  @Override
  public List<Staff> findAllStaffs() {
      return staffRepository.findAll();
   }


    @Override
    public Bug provideBugRemedy(Long ticketId, String remedy) {
        Bug bug=findBugById(ticketId);
        bug.setRemedy(remedy);
        return bugRepository.save(bug);
    }
    
    public Bug findBugById(Long ticketId){
        Optional<Bug> optional=bugRepository.findById(ticketId);
        if(optional.isEmpty()){
            throw new BugNotFoundException("Bug Not Found for Ticket Id : "+ticketId);
        }
        return optional.get();
    }
    
    @Override
    public Staff assignBugToStaff(Long staffId, Long ticketId) {
        Bug bug=findBugById(ticketId);
        if(bug.getBugStatus().equals(BugStatus.ASSIGNED)){
            throw new InvalidBugAssignation("Bug is already assigned");
        }
        else if(bug.getBugStatus().equals(BugStatus.CLOSED)){
            throw new InvalidBugAssignation("Bug status is closed");
        }
        else {
            Staff staff=findStaffById(staffId);
            staff.getAssignedTicketIds().add(ticketId);
            bug.setBugStatus(BugStatus.ASSIGNED);
            bugRepository.save(bug);
            staffRepository.save(staff);
            return staff;
        }

    }

	@Override
	public List<Bug> getAllBugs() {
		return bugRepository.findAll();
	}
}

 
    
  