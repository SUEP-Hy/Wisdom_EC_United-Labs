package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffAttendancesys;

/**
 * ---------------------------
 * 考勤策略 (StaffAttendancesysMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffAttendancesysMapper {

	/**
	 * 添加考勤策略
	 * @param record
	 * @return
	 */
    int add(StaffAttendancesys record);

    /**
     * 删除考勤策略
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改考勤策略
     * @param record
     * @return
     */
    int update(StaffAttendancesys record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffAttendancesys findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffAttendancesys> findPage();
    
}