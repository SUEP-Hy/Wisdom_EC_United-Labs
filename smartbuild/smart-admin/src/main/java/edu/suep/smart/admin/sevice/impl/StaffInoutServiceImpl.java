package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffInoutService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.suep.smart.admin.model.StaffInout;
import edu.suep.smart.admin.dao.StaffInoutMapper;


/**
 * ---------------------------
 * 进退场记录表 (StaffInoutServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-19 22:33:50
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffInoutServiceImpl implements StaffInoutService {

	@Autowired
	private StaffInoutMapper staffInoutMapper;

	@Override
	public int save(StaffInout record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffInoutMapper.add(record);
		}
		return staffInoutMapper.update(record);
	}

	@Override
	public int delete(StaffInout record) {
		return staffInoutMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffInout> records) {
		for(StaffInout record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffInout findById(Long id) {
		return staffInoutMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffInoutMapper);
	}

	
}
