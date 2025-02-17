package spring.intern_quest_202504.repository;

import org.apache.ibatis.annotations.Mapper;

import spring.intern_quest_202504.domain.overtime.model.Overtime;

@Mapper
public interface OvertimeMapper {
	public void insertOvertime(Overtime overtime);

}
