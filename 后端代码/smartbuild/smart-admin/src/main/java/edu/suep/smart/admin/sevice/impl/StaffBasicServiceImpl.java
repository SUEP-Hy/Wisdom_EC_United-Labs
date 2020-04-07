package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffBasicService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import edu.suep.smart.admin.model.StaffBasic;
import edu.suep.smart.admin.dao.StaffBasicMapper;


/**
 * ---------------------------
 * 人员基本信息表 (StaffBasicServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffBasicServiceImpl implements StaffBasicService {

	@Autowired
	private StaffBasicMapper staffBasicMapper;

	@Override
	public int save(StaffBasic record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffBasicMapper.add(record);
		}
		return staffBasicMapper.update(record);
	}

	@Override
	public int delete(StaffBasic record) {
		return staffBasicMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffBasic> records) {
		for(StaffBasic record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffBasic findById(Long id) {
		return staffBasicMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffBasicMapper);
	}
	
}
