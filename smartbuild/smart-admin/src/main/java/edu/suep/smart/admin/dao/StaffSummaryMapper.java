package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffSummary;

/**
 * ---------------------------
 * 人员信息关联表 (StaffSummaryMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-19 22:33:50
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffSummaryMapper {

	/**
	 * 添加人员信息关联表
	 * @param record
	 * @return
	 */
    int add(StaffSummary record);

    /**
     * 删除人员信息关联表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改人员信息关联表
     * @param record
     * @return
     */
    int update(StaffSummary record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffSummary findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffSummary> findPage();
    
}