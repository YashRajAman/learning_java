package com.user.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.user.test.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
