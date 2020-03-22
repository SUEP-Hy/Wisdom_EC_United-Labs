package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffDictionary;

/**
 * ---------------------------
 * 字典表 (StaffDictionaryMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffDictionaryMapper {

	/**
	 * 添加字典表
	 * @param record
	 * @return
	 */
    int add(StaffDictionary record);

    /**
     * 删除字典表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改字典表
     * @param record
     * @return
     */
    int update(StaffDictionary record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffDictionary findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffDictionary> findPage();
    
}