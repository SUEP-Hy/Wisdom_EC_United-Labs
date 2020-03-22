package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffForbidstrategy;

/**
 * ---------------------------
 * 考勤制策略表 (StaffForbidstrategyMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-19 22:33:50
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffForbidstrategyMapper {

	/**
	 * 添加考勤制策略表
	 * @param record
	 * @return
	 */
    int add(StaffForbidstrategy record);

    /**
     * 删除考勤制策略表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改考勤制策略表
     * @param record
     * @return
     */
    int update(StaffForbidstrategy record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffForbidstrategy findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffForbidstrategy> findPage();
    
}