package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffFamily;

/**
 * ---------------------------
 * 家庭成员表 (StaffFamilyMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffFamilyMapper {

	/**
	 * 添加家庭成员表
	 * @param record
	 * @return
	 */
    int add(StaffFamily record);

    /**
     * 删除家庭成员表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改家庭成员表
     * @param record
     * @return
     */
    int update(StaffFamily record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffFamily findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffFamily> findPage();
    
}