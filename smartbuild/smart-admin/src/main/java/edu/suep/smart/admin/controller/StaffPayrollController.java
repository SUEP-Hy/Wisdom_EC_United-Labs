package edu.suep.smart.admin.controller;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffPayrollService;
import edu.suep.smart.core.http.HttpResult;
import edu.suep.smart.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import edu.suep.smart.admin.model.StaffPayroll;

/**
 * ---------------------------
 * 薪酬福利表 (StaffPayrollController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("staffPayroll")
public class StaffPayrollController {

	@Autowired
	private StaffPayrollService staffPayrollService;

	/**
	 * 保存薪酬福利表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody StaffPayroll record) {
		return HttpResult.ok(staffPayrollService.save(record));
	}

    /**
     * 删除薪酬福利表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<StaffPayroll> records) {
		return HttpResult.ok(staffPayrollService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(staffPayrollService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(staffPayrollService.findById(id));
	}
}
