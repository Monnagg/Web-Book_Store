package service;

import JavaBean.User;

public interface UserService {
    public void registUser(User user);

    public User login(User user);

    public boolean existUsername(String username);

}
