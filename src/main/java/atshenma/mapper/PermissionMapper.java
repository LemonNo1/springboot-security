package atshenma.mapper;

import atshenma.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface PermissionMapper {
    // 查询所有权限
    @Select(" select * from tab_permission ")
    List<Permission> findAllPermission();
}
