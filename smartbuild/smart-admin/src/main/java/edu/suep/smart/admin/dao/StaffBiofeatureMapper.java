package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffBiofeature;

/**
 * ---------------------------
 * 生物特征表 (StaffBiofeatureMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-19 22:33:50
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffBiofeatureMapper {

	/**
	 * 添加生物特征表
	 * @param record
	 * @return
	 */
    int add(StaffBiofeature record);

    /**
     * 删除生物特征表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改生物特征表
     * @param record
     * @return
     */
    int update(StaffBiofeature record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffBiofeature findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffBiofeature> findPage();
    
}