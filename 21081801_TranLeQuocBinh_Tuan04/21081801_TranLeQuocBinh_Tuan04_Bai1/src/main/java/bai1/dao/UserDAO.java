package bai1.dao;

import java.util.List;

import bai1.models.User;

public interface UserDAO {
    public User save(User user);
	
    public List<User> getAll();
}
