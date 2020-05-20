package in.com.web.context;

import util.Copy;
import util.DownLoadUtils;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;


@WebServlet("/downLoadServlet")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//设置指定浏览器使用哪个字符集解析
     //设置浏览器指定使用哪个字符集解析
      //response.setCharacterEncoding("text/html;charset=utf-8");
     //获取属性键对应的值
        String filename = request.getParameter("filename");
       //获取全局对象
        ServletContext context = this.getServletContext();
        //获取值对应mime类型
        String mimeType = context.getMimeType(filename);
        //获取值的真实路径
        String path = context.getRealPath("/img/"+filename);
        //绑定流加载进内存
        FileInputStream fis = new FileInputStream(path);
        //获取response对象的输出流。来完成数据对拷贝
        ServletOutputStream os = response.getOutputStream();
        //解决中文乱码问题
            //1.获取请求头user-agent头
        String agent = request.getHeader("User-Agent");
        //2.使用DownLoadUtils工具类
         filename = DownLoadUtils.getFileName(agent, filename);
        //设置响应头
            // 1. 设置响应头类型 content-type
        response.setHeader("content-type",mimeType);
            // 2. 设置响应头打开方式 content-disposition
        response.setHeader("content-disposition","attachment;filename="+filename);
        /*//数据对拷贝
        byte[] bytes = new byte[1024*8];
        int len ;
        while ((len = fis.read(bytes)) != -1){
            os.write(bytes,0,len);
        }*/
        //对拷贝使用工具类
        Copy.copyA(fis,os);
        //释放获取的流
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
