package edu.suep.smart.admin.controller;

import java.util.List;

import edu.suep.smart.admin.sevice.StaffTrainService;
import edu.suep.smart.core.http.HttpResult;
import edu.suep.smart.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import edu.suep.smart.admin.model.StaffTrain;


/**
 * ---------------------------
 * 培训记录表 (StaffTrainController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:10
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("staffTrain")
public class StaffTrainController {

	@Autowired
	private StaffTrainService staffTrainService;

	/**
	 * 保存培训记录表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody StaffTrain record) {
		return HttpResult.ok(staffTrainService.save(record));
	}

    /**
     * 删除培训记录表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<StaffTrain> records) {
		return HttpResult.ok(staffTrainService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(staffTrainService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(staffTrainService.findById(id));
	}
}
