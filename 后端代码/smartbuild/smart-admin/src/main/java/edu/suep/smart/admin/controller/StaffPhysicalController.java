package edu.suep.smart.admin.controller;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffPhysicalService;
import edu.suep.smart.core.http.HttpResult;
import edu.suep.smart.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.suep.smart.admin.model.StaffPhysical;


/**
 * ---------------------------
 * 体检信息表 (StaffPhysicalController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:10
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("staffPhysical")
public class StaffPhysicalController {

	@Autowired
	private StaffPhysicalService staffPhysicalService;

	/**
	 * 保存体检信息表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody StaffPhysical record) {
		return HttpResult.ok(staffPhysicalService.save(record));
	}

    /**
     * 删除体检信息表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<StaffPhysical> records) {
		return HttpResult.ok(staffPhysicalService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(staffPhysicalService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(staffPhysicalService.findById(id));
	}
}
