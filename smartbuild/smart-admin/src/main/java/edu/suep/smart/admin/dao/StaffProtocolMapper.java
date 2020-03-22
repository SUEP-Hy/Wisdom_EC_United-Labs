package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffProtocol;

/**
 * ---------------------------
 * 协议编码表 (StaffProtocolMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffProtocolMapper {

	/**
	 * 添加协议编码表
	 * @param record
	 * @return
	 */
    int add(StaffProtocol record);

    /**
     * 删除协议编码表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改协议编码表
     * @param record
     * @return
     */
    int update(StaffProtocol record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffProtocol findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffProtocol> findPage();
    
}