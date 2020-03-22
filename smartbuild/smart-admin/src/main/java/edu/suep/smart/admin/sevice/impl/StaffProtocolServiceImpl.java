package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffProtocolService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.suep.smart.admin.model.StaffProtocol;
import edu.suep.smart.admin.dao.StaffProtocolMapper;


/**
 * ---------------------------
 * 协议编码表 (StaffProtocolServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffProtocolServiceImpl implements StaffProtocolService {

	@Autowired
	private StaffProtocolMapper staffProtocolMapper;

	@Override
	public int save(StaffProtocol record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffProtocolMapper.add(record);
		}
		return staffProtocolMapper.update(record);
	}

	@Override
	public int delete(StaffProtocol record) {
		return staffProtocolMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffProtocol> records) {
		for(StaffProtocol record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffProtocol findById(Long id) {
		return staffProtocolMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffProtocolMapper);
	}
	
}
