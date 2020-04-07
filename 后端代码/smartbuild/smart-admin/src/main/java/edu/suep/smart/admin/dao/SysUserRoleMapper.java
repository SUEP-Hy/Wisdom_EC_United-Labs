package edu.suep.smart.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.suep.smart.admin.model.SysUserRole;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

	List<SysUserRole> findUserRoles(@Param(value="userId") Long userId);

	int deleteByUserId(@Param(value="userId") Long userId);
}