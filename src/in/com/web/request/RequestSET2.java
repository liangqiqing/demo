package in.com.web.request;

import in.com.web.entityClass.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestSET2")
public class RequestSET2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //校验通过，提示用户登录成功
        //声明要浏览器使用指定字符集解析
        response.setContentType("text/html;charset=utf-8");
        //获取转发域的数据
        User user = (User) request.getAttribute("user");
        //获取输出流，输出用户名，并提示登录成功
        response.getWriter().write("登录成功！"+user.getUsername()+"，欢迎您！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
