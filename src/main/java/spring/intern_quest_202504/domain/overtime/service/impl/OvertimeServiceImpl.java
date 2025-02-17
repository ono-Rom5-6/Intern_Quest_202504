package spring.intern_quest_202504.domain.overtime.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.intern_quest_202504.domain.overtime.model.Overtime;
import spring.intern_quest_202504.domain.overtime.service.OvertimeService;
import spring.intern_quest_202504.repository.OvertimeMapper;

@Service
public class OvertimeServiceImpl implements OvertimeService {
	@Autowired
	private OvertimeMapper overtimeMapper;

	@Override
	public void addOvertime(Overtime overtime) {
		overtimeMapper.insertOvertime(overtime);
	}

}
