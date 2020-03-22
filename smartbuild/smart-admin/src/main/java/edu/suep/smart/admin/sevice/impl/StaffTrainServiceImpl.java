package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffTrainService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.suep.smart.admin.model.StaffTrain;
import edu.suep.smart.admin.dao.StaffTrainMapper;


/**
 * ---------------------------
 * 培训记录表 (StaffTrainServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffTrainServiceImpl implements StaffTrainService {

	@Autowired
	private StaffTrainMapper staffTrainMapper;

	@Override
	public int save(StaffTrain record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffTrainMapper.add(record);
		}
		return staffTrainMapper.update(record);
	}

	@Override
	public int delete(StaffTrain record) {
		return staffTrainMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffTrain> records) {
		for(StaffTrain record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffTrain findById(Long id) {
		return staffTrainMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffTrainMapper);
	}
	
}
