//残業テーブル用
package spring.intern_quest_202504.domain.overtime.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import spring.intern_quest_202504.domain.overtime.model.Overtime;
import spring.intern_quest_202504.domain.user.model.User;

@Service
public interface OvertimeService {
	public void addOvertime(Overtime overtime);
	
	public ArrayList<Overtime> getThisOvertimeList(User user);
	
	public void addReport(Overtime overtime);
	
	public ArrayList<Overtime> getYetCombinedList(String sectionId);
	
	public void addCombineId(String id, String combineId);
	
	public ArrayList<Overtime> getCombinedList(User user);
	
	public void approve(Overtime overtime);
	
	public Overtime getOvertime(String id);
	
	public ArrayList<Overtime> getMonthlyProcessingList(String sectonId);

}
