package edu.suep.smart.admin.service.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffPactService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.suep.smart.admin.model.StaffPact;
import edu.suep.smart.admin.dao.StaffPactMapper;


/**
 * ---------------------------
 * 合同信息表 (StaffPactServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffPactServiceImpl implements StaffPactService {

	@Autowired
	private StaffPactMapper staffPactMapper;

	@Override
	public int save(StaffPact record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffPactMapper.add(record);
		}
		return staffPactMapper.update(record);
	}

	@Override
	public int delete(StaffPact record) {
		return staffPactMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffPact> records) {
		for(StaffPact record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffPact findById(Long id) {
		return staffPactMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffPactMapper);
	}
	
}
