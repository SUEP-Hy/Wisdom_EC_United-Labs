package edu.suep.smart.admin.controller;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffAttendancesysService;
import edu.suep.smart.core.http.HttpResult;
import edu.suep.smart.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import edu.suep.smart.admin.model.StaffAttendancesys;


/**
 * ---------------------------
 * 考勤策略 (StaffAttendancesysController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("staffAttendancesys")
public class StaffAttendancesysController {

	@Autowired
	private StaffAttendancesysService staffAttendancesysService;

	/**
	 * 保存考勤策略
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody StaffAttendancesys record) {
		return HttpResult.ok(staffAttendancesysService.save(record));
	}

    /**
     * 删除考勤策略
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<StaffAttendancesys> records) {
		return HttpResult.ok(staffAttendancesysService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(staffAttendancesysService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@PostMapping(value="/findById")
	public HttpResult findById(@RequestBody Long id) {
		return HttpResult.ok(staffAttendancesysService.findById(id));
	}
}
