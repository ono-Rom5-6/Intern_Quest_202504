package spring.intern_quest_202504.domain.overtime.service;

import org.springframework.stereotype.Service;

import spring.intern_quest_202504.domain.overtime.model.Overtime;

@Service
public interface OvertimeService {
	public void addOvertime(Overtime overtime);

}
