package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffContactService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import edu.suep.smart.admin.model.StaffContact;
import edu.suep.smart.admin.dao.StaffContactMapper;


/**
 * ---------------------------
 * 联系信息表 (StaffContactServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffContactServiceImpl implements StaffContactService {

	@Autowired
	private StaffContactMapper staffContactMapper;

	@Override
	public int save(StaffContact record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffContactMapper.add(record);
		}
		return staffContactMapper.update(record);
	}

	@Override
	public int delete(StaffContact record) {
		return staffContactMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffContact> records) {
		for(StaffContact record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffContact findById(Long id) {
		return null;
	}

	@Override
	public List<StaffContact> findById(int id) {
		return staffContactMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffContactMapper);
	}
	
}
