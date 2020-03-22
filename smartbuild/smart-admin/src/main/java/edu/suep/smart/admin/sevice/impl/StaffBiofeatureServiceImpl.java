package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffBiofeatureService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import edu.suep.smart.admin.model.StaffBiofeature;
import edu.suep.smart.admin.dao.StaffBiofeatureMapper;


/**
 * ---------------------------
 * 生物特征表 (StaffBiofeatureServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-19 22:33:50
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffBiofeatureServiceImpl implements StaffBiofeatureService {

	@Autowired
	private StaffBiofeatureMapper staffBiofeatureMapper;

	@Override
	public int save(StaffBiofeature record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffBiofeatureMapper.add(record);
		}
		return staffBiofeatureMapper.update(record);
	}

	@Override
	public int delete(StaffBiofeature record) {
		return staffBiofeatureMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffBiofeature> records) {
		for(StaffBiofeature record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffBiofeature findById(Long id) {
		return staffBiofeatureMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffBiofeatureMapper);
	}
	
}
