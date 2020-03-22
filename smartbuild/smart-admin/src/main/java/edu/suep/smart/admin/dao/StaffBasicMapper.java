package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffBasic;

/**
 * ---------------------------
 * 人员基本信息表 (StaffBasicMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffBasicMapper {

	/**
	 * 添加人员基本信息表
	 * @param record
	 * @return
	 */
    int add(StaffBasic record);

    /**
     * 删除人员基本信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改人员基本信息表
     * @param record
     * @return
     */
    int update(StaffBasic record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffBasic findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffBasic> findPage();
    
}