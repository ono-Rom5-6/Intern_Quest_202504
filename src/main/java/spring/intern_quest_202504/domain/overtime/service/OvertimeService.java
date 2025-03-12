package spring.intern_quest_202504.domain.overtime.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import spring.intern_quest_202504.domain.overtime.model.Overtime;

@Service
public interface OvertimeService {
	public void addOvertime(Overtime overtime);
	
	public ArrayList<Overtime> getThisOvertimeList(String userId);
	
	public void addReport(Overtime overtime);
	
	public ArrayList<Overtime> getYetCombinedList(String departmentId);
	
	public void addCombineId(String id, String combineId);
	
	public ArrayList<Overtime> getCombinedList(String departmentId);
	
	public void approve(Overtime overtime);
	
	public Overtime getOvertime(String id);

}
