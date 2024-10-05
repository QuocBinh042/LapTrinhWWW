package bai2.dao;

import java.util.List;

import bai2.models.User;

public interface UserDAO {
	public List<User> findAll();
	public void addUser(User u);
}
