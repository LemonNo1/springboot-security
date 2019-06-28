package atshenma;


import atshenma.entity.Permission;
import atshenma.entity.User;
import atshenma.mapper.PermissionMapper;
import atshenma.mapper.UserMapper;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecuritySpringBootTest {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
       List<Permission> allPermission = permissionMapper.findAllPermission();
        System.out.println("权限对象："+allPermission);
    }

    @Test
    public void test2(){
        List<User> users = userMapper.findAllUser();
        System.out.println("user对象："+users);
    }

    @Test
    public void test3(){
        User user = userMapper.findUserByUsername("eric");
        System.out.println("user对象："+user);
    }
}
