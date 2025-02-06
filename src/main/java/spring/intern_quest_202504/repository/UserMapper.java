package spring.intern_quest_202504.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import spring.intern_quest_202504.domain.user.model.User;

@Mapper
public interface UserMapper {
	public User findLoginUser(String user);
	
	public String findPasswordByName(@Param("user") String user);

}
