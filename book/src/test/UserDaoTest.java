package test;

import JavaBean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        if(userDao.queryUserByUsername("admin")==null){
            System.out.println("用户名可用");

        }else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.saveUser(new User(null,"admin1","123456","123@gmail")));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        if(userDao.queryUserByUsernameAndPassword("admin","admin")==null){
            System.out.println("用户名或密码错误，登陆失败");

        }else {
            System.out.println("查询成功");
        }
    }
}