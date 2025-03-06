package spring.intern_quest_202504.domain.combine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.intern_quest_202504.domain.combine.model.Combine;
import spring.intern_quest_202504.domain.combine.service.CombineService;
import spring.intern_quest_202504.repository.CombineMapper;

@Service
public class CombineServiceImpl implements CombineService {
	@Autowired
	private CombineMapper combineMapper;
	
	
	@Override
	public void createCombine(Combine combine) {
		combineMapper.insertCombine(combine);
	}

}
