package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffForbidstrategy;

/**
 * ---------------------------
 * 禁入策略表 (StaffForbidstrategyMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffForbidstrategyMapper {

	/**
	 * 添加禁入策略表
	 * @param record
	 * @return
	 */
    int add(StaffForbidstrategy record);

    /**
     * 删除禁入策略表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改禁入策略表
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