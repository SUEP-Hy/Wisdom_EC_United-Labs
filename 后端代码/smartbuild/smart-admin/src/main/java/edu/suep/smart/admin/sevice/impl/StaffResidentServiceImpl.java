package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffResidentService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import edu.suep.smart.admin.model.StaffResident;
import edu.suep.smart.admin.dao.StaffResidentMapper;


/**
 * ---------------------------
 * 户口信息表 (StaffResidentServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:10
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffResidentServiceImpl implements StaffResidentService {

	@Autowired
	private StaffResidentMapper staffResidentMapper;

	@Override
	public int save(StaffResident record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffResidentMapper.add(record);
		}
		return staffResidentMapper.update(record);
	}

	@Override
	public int delete(StaffResident record) {
		return staffResidentMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffResident> records) {
		for(StaffResident record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffResident findById(Long id) {
		return staffResidentMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffResidentMapper);
	}
	
}
