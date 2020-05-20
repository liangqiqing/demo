package in.com.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestSET1")
public class RequestSET1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //验证失败输出提示信息
        //声明设置要浏览器使用哪个字符集解析
        response.setContentType("text/html;charset=utf-8");
        //获取输出流，输出文字提示
        response.getWriter().write("你的密码或账号错误了！请重试");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
