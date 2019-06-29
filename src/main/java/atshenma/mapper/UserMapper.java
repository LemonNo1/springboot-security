package atshenma.mapper;

import atshenma.entity.Permission;
import atshenma.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from tab_user where user_name = #{username}")
    User findUserByUsername(@Param("username") String username);


    @Select("select * from tab_user")
    List<User> findAllUser();

    // 查询用户的权限
    @Select(" select permission.* from tab_user user" + " inner join tab_role_user user_role"
            + " on user.id = user_role.user_id inner join "
            + "tab_role_permission role_permission on user_role.role_id = role_permission.role_id "
            + " inner join tab_permission permission on role_permission.perm_id = permission.id where user.user_name = #{username};")
    List<Permission> findPermissionByUsername(@Param("username") String username);
}
