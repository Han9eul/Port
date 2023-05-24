package com.company.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public UserDto getUser(UserDto dto) {
		return mybatis.selectOne("getUser", dto);
	}
}
