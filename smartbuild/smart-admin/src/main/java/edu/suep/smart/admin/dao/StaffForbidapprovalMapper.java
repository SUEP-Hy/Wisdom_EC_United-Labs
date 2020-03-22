package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffForbidapproval;

/**
 * ---------------------------
 * 禁入审批表 (StaffForbidapprovalMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-19 22:33:50
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffForbidapprovalMapper {

	/**
	 * 添加禁入审批表
	 * @param record
	 * @return
	 */
    int add(StaffForbidapproval record);

    /**
     * 删除禁入审批表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改禁入审批表
     * @param record
     * @return
     */
    int update(StaffForbidapproval record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffForbidapproval findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffForbidapproval> findPage();
    
}