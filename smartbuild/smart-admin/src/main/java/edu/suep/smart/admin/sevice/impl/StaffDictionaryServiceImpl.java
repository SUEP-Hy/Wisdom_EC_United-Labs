package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffDictionaryService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.suep.smart.admin.model.StaffDictionary;
import edu.suep.smart.admin.dao.StaffDictionaryMapper;


/**
 * ---------------------------
 * 字典表 (StaffDictionaryServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffDictionaryServiceImpl implements StaffDictionaryService {

	@Autowired
	private StaffDictionaryMapper staffDictionaryMapper;

	@Override
	public int save(StaffDictionary record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffDictionaryMapper.add(record);
		}
		return staffDictionaryMapper.update(record);
	}

	@Override
	public int delete(StaffDictionary record) {
		return staffDictionaryMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffDictionary> records) {
		for(StaffDictionary record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffDictionary findById(Long id) {
		return staffDictionaryMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffDictionaryMapper);
	}
	
}
