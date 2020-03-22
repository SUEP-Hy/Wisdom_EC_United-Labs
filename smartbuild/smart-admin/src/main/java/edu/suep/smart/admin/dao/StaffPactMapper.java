package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffPact;

/**
 * ---------------------------
 * 合同信息表 (StaffPactMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffPactMapper {

	/**
	 * 添加合同信息表
	 * @param record
	 * @return
	 */
    int add(StaffPact record);

    /**
     * 删除合同信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改合同信息表
     * @param record
     * @return
     */
    int update(StaffPact record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffPact findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffPact> findPage();
    
}