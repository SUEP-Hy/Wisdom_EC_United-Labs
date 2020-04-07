package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffForbiddetailService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import edu.suep.smart.admin.model.StaffForbiddetail;
import edu.suep.smart.admin.dao.StaffForbiddetailMapper;


/**
 * ---------------------------
 * 禁入明细表 (StaffForbiddetailServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffForbiddetailServiceImpl implements StaffForbiddetailService {

	@Autowired
	private StaffForbiddetailMapper staffForbiddetailMapper;

	@Override
	public int save(StaffForbiddetail record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffForbiddetailMapper.add(record);
		}
		return staffForbiddetailMapper.update(record);
	}

	@Override
	public int delete(StaffForbiddetail record) {
		return staffForbiddetailMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffForbiddetail> records) {
		for(StaffForbiddetail record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffForbiddetail findById(Long id) {
		return staffForbiddetailMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffForbiddetailMapper);
	}
	
}
