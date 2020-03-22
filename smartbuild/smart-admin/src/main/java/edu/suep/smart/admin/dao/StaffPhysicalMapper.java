package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffPhysical;

/**
 * ---------------------------
 * 体检信息表 (StaffPhysicalMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffPhysicalMapper {

	/**
	 * 添加体检信息表
	 * @param record
	 * @return
	 */
    int add(StaffPhysical record);

    /**
     * 删除体检信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改体检信息表
     * @param record
     * @return
     */
    int update(StaffPhysical record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffPhysical findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffPhysical> findPage();
    
}