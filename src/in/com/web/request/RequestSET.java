package in.com.web.request;

import in.com.web.entityClass.User;
import in.com.web.useClasses.UseUser;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/RequestSET")
public class RequestSET extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //声明读取方式
        request.setCharacterEncoding("utf-8");
    //获取用户传递的参数
        Map<String, String[]> map = request.getParameterMap();
    //创建一个User对象
        User u = new User();
    //使用BeanUtils工具类完成自动封装
        try {
            BeanUtils.populate(u,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //创建UseUser对象
        UseUser useUser = new UseUser();
        User user = useUser.getUser(u);

        if (user == null){
            // 转发页面比提示用户输入错误
            request.getRequestDispatcher("/RequestSET1").forward(request,response);
        }else {
            //在转发域储存数据
            request.setAttribute("user",user);
            request.getRequestDispatcher("/RequestSET2").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
