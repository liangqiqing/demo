package test;

import in.com.web.entityClass.User;
import in.com.web.useClasses.UseUser;
import org.junit.Assert;
import org.junit.Test;

public class UseUserTest {

    @Test
    public void testUseUser(){
        User u = new User();
        u.setUsername("zhangsan");
        u.setPassword("123");

        UseUser useUser = new UseUser();
        User user = useUser.getUser(u);

        //断言如果对象是不是空就过
        //assertNotNull这非空判断函数方法
       Assert.assertNotNull(user);
    }
}
