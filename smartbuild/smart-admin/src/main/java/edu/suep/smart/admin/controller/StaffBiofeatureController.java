package edu.suep.smart.admin.controller;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffBiofeatureService;
import edu.suep.smart.core.http.HttpResult;
import edu.suep.smart.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import edu.suep.smart.admin.model.StaffBiofeature;

/**
 * ---------------------------
 * 生物特征表 (StaffBiofeatureController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-19 22:33:50
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("staffBiofeature")
public class StaffBiofeatureController {

	@Autowired
	private StaffBiofeatureService staffBiofeatureService;

	/**
	 * 保存生物特征表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody StaffBiofeature record) {
		return HttpResult.ok(staffBiofeatureService.save(record));
	}

    /**
     * 删除生物特征表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<StaffBiofeature> records) {
		return HttpResult.ok(staffBiofeatureService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(staffBiofeatureService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(staffBiofeatureService.findById(id));
	}
}
