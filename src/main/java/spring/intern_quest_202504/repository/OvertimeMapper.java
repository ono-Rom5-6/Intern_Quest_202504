package spring.intern_quest_202504.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import spring.intern_quest_202504.domain.overtime.model.Overtime;

@Mapper
public interface OvertimeMapper {
	public void insertOvertime(Overtime overtime);
	
	public ArrayList<Overtime> selectThisOvertimeList(String userId);
	
	public void updateReport(Overtime overtime);
	
	public ArrayList<Overtime> selectYetCombinedList(String departmentId);
	
	public void updateCombine(String id, String combineId);

}
