package dao;

import JavaBean.User;

public interface UserDao {

    public User queryUserByUsername(String username);

    public int saveUser(User user);

    public User queryUserByUsernameAndPassword(String username,String password);
}
