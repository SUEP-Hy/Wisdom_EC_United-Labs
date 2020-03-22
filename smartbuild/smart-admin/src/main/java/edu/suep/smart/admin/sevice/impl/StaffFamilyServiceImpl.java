package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffFamilyService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.suep.smart.admin.model.StaffFamily;
import edu.suep.smart.admin.dao.StaffFamilyMapper;


/**
 * ---------------------------
 * 家庭成员表 (StaffFamilyServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffFamilyServiceImpl implements StaffFamilyService {

	@Autowired
	private StaffFamilyMapper staffFamilyMapper;

	@Override
	public int save(StaffFamily record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffFamilyMapper.add(record);
		}
		return staffFamilyMapper.update(record);
	}

	@Override
	public int delete(StaffFamily record) {
		return staffFamilyMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffFamily> records) {
		for(StaffFamily record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffFamily findById(Long id) {
		return staffFamilyMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffFamilyMapper);
	}
	
}
