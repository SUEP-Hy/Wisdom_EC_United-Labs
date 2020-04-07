package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.SysRoleMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);

	List<SysRoleMenu> findRoleMenus(@Param(value="roleId") Long roleId);
	
	List<SysRoleMenu> findAll();

	int deleteByRoleId(@Param(value="roleId") Long roleId);
}