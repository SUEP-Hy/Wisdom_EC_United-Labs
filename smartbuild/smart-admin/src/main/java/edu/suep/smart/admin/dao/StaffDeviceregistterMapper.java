package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffDeviceregistter;

/**
 * ---------------------------
 * 设备注册表 (StaffDeviceregistterMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-19 22:33:50
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffDeviceregistterMapper {

	/**
	 * 添加设备注册表
	 * @param record
	 * @return
	 */
    int add(StaffDeviceregistter record);

    /**
     * 删除设备注册表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改设备注册表
     * @param record
     * @return
     */
    int update(StaffDeviceregistter record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffDeviceregistter findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffDeviceregistter> findPage();
    
}