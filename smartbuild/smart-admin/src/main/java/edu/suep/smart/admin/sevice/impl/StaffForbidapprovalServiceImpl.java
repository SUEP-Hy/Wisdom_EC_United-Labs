package edu.suep.smart.admin.sevice.impl;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffForbidapprovalService;
import edu.suep.smart.core.page.MybatisPageHelper;
import edu.suep.smart.core.page.PageRequest;
import edu.suep.smart.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.suep.smart.admin.model.StaffForbidapproval;
import edu.suep.smart.admin.dao.StaffForbidapprovalMapper;


/**
 * ---------------------------
 * 禁入审批表 (StaffForbidapprovalServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-19 22:33:50
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class StaffForbidapprovalServiceImpl implements StaffForbidapprovalService {

	@Autowired
	private StaffForbidapprovalMapper staffForbidapprovalMapper;

	@Override
	public int save(StaffForbidapproval record) {
		if(record.getId() == null || record.getId() == 0) {
			return staffForbidapprovalMapper.add(record);
		}
		return staffForbidapprovalMapper.update(record);
	}

	@Override
	public int delete(StaffForbidapproval record) {
		return staffForbidapprovalMapper.delete(record.getId());
	}

	@Override
	public int delete(List<StaffForbidapproval> records) {
		for(StaffForbidapproval record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public StaffForbidapproval findById(Long id) {
		return staffForbidapprovalMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, staffForbidapprovalMapper);
	}
	
}
