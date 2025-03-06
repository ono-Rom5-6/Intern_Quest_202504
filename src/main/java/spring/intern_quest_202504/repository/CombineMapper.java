package spring.intern_quest_202504.repository;

import org.apache.ibatis.annotations.Mapper;

import spring.intern_quest_202504.domain.combine.model.Combine;

@Mapper
public interface CombineMapper {
	public void insertCombine(Combine combine);

}
