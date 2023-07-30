package com.student.Student_Management.dao;

import java.util.List;

import com.student.Student_Management.entity.User;

public interface UserDao {
    List<User> getAllUsers();

    User getUserByEmail(String email);

    User addUser(User user);

    void updateUser(User user);

    void deleteUserByEmail(String email);
}
