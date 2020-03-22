package edu.suep.smart.admin.dao;

import java.util.List;

import edu.suep.smart.admin.model.StaffTrain;

/**
 * ---------------------------
 * 培训记录表 (StaffTrainMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffTrainMapper {

	/**
	 * 添加培训记录表
	 * @param record
	 * @return
	 */
    int add(StaffTrain record);

    /**
     * 删除培训记录表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改培训记录表
     * @param record
     * @return
     */
    int update(StaffTrain record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    StaffTrain findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<StaffTrain> findPage();
    
}