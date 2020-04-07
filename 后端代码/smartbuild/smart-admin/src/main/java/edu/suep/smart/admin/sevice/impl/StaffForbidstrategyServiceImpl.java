package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffForbidstrategyService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.suep.smart.admin.model.StaffForbidstrategy;
import edu.suep.smart.admin.dao.StaffForbidstrategyMapper;


/**
 * ---------------------------
 * 禁入策略表 (StaffForbidstrategyServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffForbidstrategyServiceImpl implements StaffForbidstrategyService {

	@Autowired
	private StaffForbidstrategyMapper staffForbidstrategyMapper;

	@Override
	public int save(StaffForbidstrategy record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffForbidstrategyMapper.add(record);
		}
		return staffForbidstrategyMapper.update(record);
	}

	@Override
	public int delete(StaffForbidstrategy record) {
		return staffForbidstrategyMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffForbidstrategy> records) {
		for(StaffForbidstrategy record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffForbidstrategy findById(Long id) {
		return staffForbidstrategyMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffForbidstrategyMapper);
	}
	
}
