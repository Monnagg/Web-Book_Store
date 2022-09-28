package web;
import JavaBean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import service.UserServiceImpl;

import java.io.IOException;


public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.get parameters from request
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2. verify code
        if("abcde".equalsIgnoreCase(code)) {
            if(userService.existUsername(username)){
                //unavailable
                System.out.println("用户名【"+username+"】已存在");
                req.getRequestDispatcher("pages/user/regist.html").forward(req,resp);
            }else {
                //available
                userService.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("pages/user/regist_success.html").forward(req,resp);

            }

        }else {
            // wrong , go back regist.html
            System.out.println("验证码"+code+ "错误");//接收不到code是因为html文件里code没有添加name属性
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
        }
    }
}
