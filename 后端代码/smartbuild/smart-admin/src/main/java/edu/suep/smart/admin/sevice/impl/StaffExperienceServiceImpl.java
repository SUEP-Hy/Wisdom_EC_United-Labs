package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffExperienceService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.suep.smart.admin.model.StaffExperience;
import edu.suep.smart.admin.dao.StaffExperienceMapper;


/**
 * ---------------------------
 * 变动经历表 (StaffExperienceServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffExperienceServiceImpl implements StaffExperienceService {

	@Autowired
	private StaffExperienceMapper staffExperienceMapper;

	@Override
	public int save(StaffExperience record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffExperienceMapper.add(record);
		}
		return staffExperienceMapper.update(record);
	}

	@Override
	public int delete(StaffExperience record) {
		return staffExperienceMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffExperience> records) {
		for(StaffExperience record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffExperience findById(Long id) {
		return staffExperienceMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffExperienceMapper);
	}
	
}
