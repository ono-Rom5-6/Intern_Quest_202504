package spring.intern_quest_202504.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import spring.intern_quest_202504.domain.overtime.model.Overtime;
import spring.intern_quest_202504.domain.user.model.User;

@Mapper
public interface OvertimeMapper {
	public void insertOvertime(Overtime overtime);
	
	public ArrayList<Overtime> selectThisOvertimeList(User user);
	
	public void updateReport(Overtime overtime);
	
	public ArrayList<Overtime> selectYetCombinedList(String sectionId);
	
	public void updateCombine(@Param("id") String id, @Param("combineId") String combineId);
	
	public ArrayList<Overtime> selectCombinedList(User user);
	
	public void updateApprove(Overtime overtime);
	
	public Overtime selectOvertime(String id);
	
	public ArrayList<Overtime> selectMonthlyProcessingList(String sectionId);

}
