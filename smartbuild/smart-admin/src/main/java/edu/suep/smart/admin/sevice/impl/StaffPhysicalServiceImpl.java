package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffPhysicalService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import edu.suep.smart.admin.model.StaffPhysical;
import edu.suep.smart.admin.dao.StaffPhysicalMapper;


/**
 * ---------------------------
 * 体检信息表 (StaffPhysicalServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffPhysicalServiceImpl implements StaffPhysicalService {

	@Autowired
	private StaffPhysicalMapper staffPhysicalMapper;

	@Override
	public int save(StaffPhysical record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffPhysicalMapper.add(record);
		}
		return staffPhysicalMapper.update(record);
	}

	@Override
	public int delete(StaffPhysical record) {
		return staffPhysicalMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffPhysical> records) {
		for(StaffPhysical record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffPhysical findById(Long id) {
		return staffPhysicalMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffPhysicalMapper);
	}
	
}
