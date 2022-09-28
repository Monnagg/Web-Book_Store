package test;

import JavaBean.User;
import org.junit.Test;
import service.UserService;
import service.UserServiceImpl;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"hello","6666","hello@gmail"));
        userService.registUser(new User(null,"hello1","66661","hello1@gmail"));

    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "hello1","66661","hello1@gmail")));
    }

    @Test
    public void existUsername() {
        if(userService.existUsername("hello12")){
            System.out.println("用户名已存在");
        }else {
            System.out.println("用户名可用");
        }
    }
}