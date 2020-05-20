package in.com.web.useClasses;

import in.com.web.entityClass.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

/**
 *
 */
public class UseUser {
    //声明成员变量
    JdbcTemplate jdbc = new JdbcTemplate(JDBCUtils.getDataSource());

    public User getUser(User loginUser){
        try{
            //定义sql语句
            String sql= "select * from user where username = ? and password = ?";
            //调用JdbcTemplate对象中的queryForObject方法，获取全部user对象信息
            User user = jdbc.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("查询不到或你的sql语法出错了！ 请检查");
            return null;
        }
    }
}
