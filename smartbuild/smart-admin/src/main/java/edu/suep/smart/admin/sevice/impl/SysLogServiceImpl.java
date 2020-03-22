package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.model.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.suep.smart.admin.dao.SysLogMapper;
import edu.suep.smart.admin.sevice.SysLogService;
import edu.suep.smart.core.page.ColumnFilter;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;

@Service
public class SysLogServiceImpl  implements SysLogService {

	@Autowired
	private SysLogMapper sysLogMapper;

	@Override
	public int save(SysLog record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysLogMapper.insertSelective(record);
		}
		return sysLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysLog record) {
		return sysLogMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysLog> records) {
		for(SysLog record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysLog findById(Long id) {
		return sysLogMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		ColumnFilter columnFilter = pageRequest.getColumnFilter("userName");
		if(columnFilter != null) {
			return MybatisPageHelper.findPage(pageRequest, sysLogMapper, "findPageByUserName", columnFilter.getValue());
		}
		return MybatisPageHelper.findPage(pageRequest, sysLogMapper);
	}
	
}
