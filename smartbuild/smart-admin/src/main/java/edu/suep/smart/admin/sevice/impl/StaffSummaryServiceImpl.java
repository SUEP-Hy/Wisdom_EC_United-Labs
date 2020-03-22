package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffSummaryService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.suep.smart.admin.model.StaffSummary;
import edu.suep.smart.admin.dao.StaffSummaryMapper;


/**
 * ---------------------------
 * 人员信息关联表 (StaffSummaryServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-19 22:33:50
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffSummaryServiceImpl implements StaffSummaryService {

	@Autowired
	private StaffSummaryMapper staffSummaryMapper;

	@Override
	public int save(StaffSummary record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffSummaryMapper.add(record);
		}
		return staffSummaryMapper.update(record);
	}

	@Override
	public int delete(StaffSummary record) {
		return staffSummaryMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffSummary> records) {
		for(StaffSummary record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffSummary findById(Long id) {
		return staffSummaryMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffSummaryMapper);
	}
	
}
