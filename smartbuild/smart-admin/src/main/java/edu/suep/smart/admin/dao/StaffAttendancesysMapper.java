package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffAttendancesys;

/**
 * ---------------------------
 * 考勤制度管理表 (StaffAttendancesysMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-19 22:33:50
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffAttendancesysMapper {

	/**
	 * 添加考勤制度管理表
	 * @param record
	 * @return
	 */
    int add(StaffAttendancesys record);

    /**
     * 删除考勤制度管理表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改考勤制度管理表
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