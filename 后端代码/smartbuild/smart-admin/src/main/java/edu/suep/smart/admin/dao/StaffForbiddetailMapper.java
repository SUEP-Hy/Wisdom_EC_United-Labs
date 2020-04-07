package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffForbiddetail;

/**
 * ---------------------------
 * 禁入明细表 (StaffForbiddetailMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffForbiddetailMapper {

	/**
	 * 添加禁入明细表
	 * @param record
	 * @return
	 */
    int add(StaffForbiddetail record);

    /**
     * 删除禁入明细表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改禁入明细表
     * @param record
     * @return
     */
    int update(StaffForbiddetail record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffForbiddetail findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffForbiddetail> findPage();
    
}