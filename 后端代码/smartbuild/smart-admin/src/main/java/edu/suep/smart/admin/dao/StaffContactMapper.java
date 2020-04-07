package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffContact;

/**
 * ---------------------------
 * 联系信息表 (StaffContactMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffContactMapper {

	/**
	 * 添加联系信息表
	 * @param record
	 * @return
	 */
    int add(StaffContact record);

    /**
     * 删除联系信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改联系信息表
     * @param record
     * @return
     */
    int update(StaffContact record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */
    List<StaffContact> findById(int id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffContact> findPage();
    
}