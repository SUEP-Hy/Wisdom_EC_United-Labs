package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffResident;

/**
 * ---------------------------
 * 户口信息表 (StaffResidentMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffResidentMapper {

	/**
	 * 添加户口信息表
	 * @param record
	 * @return
	 */
    int add(StaffResident record);

    /**
     * 删除户口信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改户口信息表
     * @param record
     * @return
     */
    int update(StaffResident record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffResident findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffResident> findPage();
    
}