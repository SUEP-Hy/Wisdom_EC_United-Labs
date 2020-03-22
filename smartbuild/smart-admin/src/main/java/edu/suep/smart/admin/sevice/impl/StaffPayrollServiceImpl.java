package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffPayrollService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.suep.smart.admin.model.StaffPayroll;
import edu.suep.smart.admin.dao.StaffPayrollMapper;


/**
 * ---------------------------
 * 薪酬福利表 (StaffPayrollServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffPayrollServiceImpl implements StaffPayrollService {

	@Autowired
	private StaffPayrollMapper staffPayrollMapper;

	@Override
	public int save(StaffPayroll record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffPayrollMapper.add(record);
		}
		return staffPayrollMapper.update(record);
	}

	@Override
	public int delete(StaffPayroll record) {
		return staffPayrollMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffPayroll> records) {
		for(StaffPayroll record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffPayroll findById(Long id) {
		return staffPayrollMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffPayrollMapper);
	}
	
}
