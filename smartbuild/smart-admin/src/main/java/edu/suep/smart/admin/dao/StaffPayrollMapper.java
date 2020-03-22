package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffPayroll;

/**
 * ---------------------------
 * 薪酬福利表 (StaffPayrollMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffPayrollMapper {

	/**
	 * 添加薪酬福利表
	 * @param record
	 * @return
	 */
    int add(StaffPayroll record);

    /**
     * 删除薪酬福利表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改薪酬福利表
     * @param record
     * @return
     */
    int update(StaffPayroll record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffPayroll findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffPayroll> findPage();
    
}