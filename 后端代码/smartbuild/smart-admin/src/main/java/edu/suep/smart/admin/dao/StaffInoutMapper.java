package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffInout;

/**
 * ---------------------------
 * 进退场记录表 (StaffInoutMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffInoutMapper {

	/**
	 * 添加进退场记录表
	 * @param record
	 * @return
	 */
    int add(StaffInout record);

    /**
     * 删除进退场记录表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改进退场记录表
     * @param record
     * @return
     */
    int update(StaffInout record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffInout findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffInout> findPage();
    
}