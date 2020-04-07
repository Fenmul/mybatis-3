package com.fox.dao;

import com.fox.domain.User;

import java.util.List;

public interface UserDao {
  List<User> selectList();

  User selectById(Integer id);
}
