package com.company.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserMapper{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public UserDto getUser(UserDto dto) {
		return userDao.getUser(dto);
	}

}
