package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffExperience;

/**
 * ---------------------------
 * 变动经历表 (StaffExperienceMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffExperienceMapper {

	/**
	 * 添加变动经历表
	 * @param record
	 * @return
	 */
    int add(StaffExperience record);

    /**
     * 删除变动经历表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改变动经历表
     * @param record
     * @return
     */
    int update(StaffExperience record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffExperience findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffExperience> findPage();
    
}