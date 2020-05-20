package util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.datasource.DelegatingDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *@JDBCUtils 为了简化注册驱动和数据库连接池的代码，写的工具类
 */
public class JDBCUtils {
    //声明成员变量
    private static DataSource ds;
    private static Properties p ;

    /**
     * 创建一个静态代码块 每次调用默认注册驱动
     */
    static{
        try {
            //获取配置文件路径
            //这是配置阿里巴巴数据库的文件
            InputStream is = JDBCUtils.class.getClassLoader().getResource("driver.properties").openStream();
            //把配置文件写入Properties集合中
            p = new Properties();
            p.load(is);
            //注册驱动
            ds = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 定义一个获取连接数据库连接池对象的方法
     * @return 返回一个数据库连接池对象
     * @throws SQLException sql异常
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     *定义一个返回数据源的静态方法
     * @return 数据源（Data Source）顾名思义
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
