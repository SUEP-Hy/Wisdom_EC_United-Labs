package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffAttendancesysService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import edu.suep.smart.admin.model.StaffAttendancesys;
import edu.suep.smart.admin.dao.StaffAttendancesysMapper;


/**
 * ---------------------------
 * 考勤策略 (StaffAttendancesysServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffAttendancesysServiceImpl implements StaffAttendancesysService {

	@Autowired
	private StaffAttendancesysMapper staffAttendancesysMapper;

	@Override
	public int save(StaffAttendancesys record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffAttendancesysMapper.add(record);
		}
		return staffAttendancesysMapper.update(record);
	}

	@Override
	public int delete(StaffAttendancesys record) {
		return staffAttendancesysMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffAttendancesys> records) {
		for(StaffAttendancesys record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffAttendancesys findById(Long id) {
		return staffAttendancesysMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffAttendancesysMapper);
	}
	
}
