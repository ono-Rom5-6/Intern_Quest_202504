package spring.intern_quest_202504.domain.overtime.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.intern_quest_202504.domain.overtime.model.Overtime;
import spring.intern_quest_202504.domain.overtime.service.OvertimeService;
import spring.intern_quest_202504.domain.user.model.User;
import spring.intern_quest_202504.repository.OvertimeMapper;

@Service
public class OvertimeServiceImpl implements OvertimeService {
	@Autowired
	private OvertimeMapper overtimeMapper;

	@Override
	public void addOvertime(Overtime overtime) {
		overtimeMapper.insertOvertime(overtime);
	}
	
	@Override
	public ArrayList<Overtime> getThisOvertimeList(User user) {
		return overtimeMapper.selectThisOvertimeList(user);
	}
	
	@Override
	public void addReport(Overtime overtime) {
		overtimeMapper.updateReport(overtime);
	}
	
	@Override
	public ArrayList<Overtime> getYetCombinedList(String sectionId) {
		return overtimeMapper.selectYetCombinedList(sectionId);
	}
	
	@Override
	public void addCombineId(String id, String combineId) {
		overtimeMapper.updateCombine(id, combineId);
	}
	
	@Override
	public ArrayList<Overtime> getCombinedList(User user) {
		return overtimeMapper.selectCombinedList(user);
	}
	
	@Override
	public void approve(Overtime overtime) {
		overtimeMapper.updateApprove(overtime);
	}
	
	@Override
	public Overtime getOvertime(String id) {
		return overtimeMapper.selectOvertime(id);
	}
	
	@Override
	public ArrayList<Overtime> getMonthlyProcessingList(String sectonId) {
		return overtimeMapper.selectMonthlyProcessingList(sectonId);
	}

}
