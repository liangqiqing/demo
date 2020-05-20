package in.com.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDome")
public class cookieDome extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //从客户端获取请求中的cookie对象
            Cookie[] cookies = request.getCookies();
            //使用cookie对象数据
            //非空判断
            if (cookies != null) {
                 System.out.println(cookies.length);
                for (Cookie c : cookies) {
                    String name = c.getName();
                    String value = c.getValue();
                    System.out.println(name + "--" + value);
                }
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
