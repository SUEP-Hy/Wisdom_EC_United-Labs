package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffDeviceregistterService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import edu.suep.smart.admin.model.StaffDeviceregistter;
import edu.suep.smart.admin.dao.StaffDeviceregistterMapper;


/**
 * ---------------------------
 * 设备注册表 (StaffDeviceregistterServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffDeviceregistterServiceImpl implements StaffDeviceregistterService {

	@Autowired
	private StaffDeviceregistterMapper staffDeviceregistterMapper;

	@Override
	public int save(StaffDeviceregistter record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffDeviceregistterMapper.add(record);
		}
		return staffDeviceregistterMapper.update(record);
	}

	@Override
	public int delete(StaffDeviceregistter record) {
		return staffDeviceregistterMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffDeviceregistter> records) {
		for(StaffDeviceregistter record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffDeviceregistter findById(Long id) {
		return staffDeviceregistterMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffDeviceregistterMapper);
	}
	
}
