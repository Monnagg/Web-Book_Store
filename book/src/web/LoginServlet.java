package web;

import JavaBean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import service.UserServiceImpl;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.get parameter from request
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2. call userService.login() handle event
        User loginUser = userService.login(new User(null, username, password, null));

        if (loginUser ==null){
            //failure, go back to login.html
            req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
        }else {
            //success,
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);

        }

    }
}
