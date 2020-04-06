package edu.suep.smart.admin.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.suep.smart.admin.model.TbEmployeeBasic;
import edu.suep.smart.admin.sevice.TbEmployeeBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.suep.smart.core.http.HttpResult;
import edu.suep.smart.core.page.PageRequest;

import edu.suep.smart.admin.model.TbEmployee;
import edu.suep.smart.admin.sevice.TbEmployeeService;

/**
 * ---------------------------
 * 人员信息关联表 (TbEmployeeController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-10 18:43:27
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("tbEmployee")
public class TbEmployeeController {

	@Autowired
	private TbEmployeeService tbEmployeeService;
	@Autowired
	private TbEmployeeBasicService tbEmployeeBasicService;

	/**
	 * 保存人员信息关联表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody JSONObject record) {
		JSONObject jsonObject2 = record.getJSONObject("basic");  //获取子表数据集
		TbEmployeeBasic tbemployeebasic = JSON.toJavaObject(jsonObject2, TbEmployeeBasic.class );  //json类型数据集转换为model层
		tbEmployeeBasicService.save(tbemployeebasic);  //插入数据库操作
		int basicid = tbEmployeeBasicService.findByCode(tbemployeebasic.getFworkercode()).getId().intValue();  //获取子表数据id值

		JSONObject jsonObject1 = record.getJSONObject("main");  //获取主表数据集
		TbEmployee tbemployee = JSON.toJavaObject(jsonObject1,TbEmployee.class );  //json类型数据集转换为model层
		tbemployee.setFbasicid(basicid);  //将查出的子表数据id值对应到主表model对应变量中

		return HttpResult.ok(tbEmployeeService.save(tbemployee));  //插入数据库操作，结果返回前端
	}

    /**
     * 删除人员信息关联表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<TbEmployee> records) {
		return HttpResult.ok(tbEmployeeService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(tbEmployeeService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(tbEmployeeService.findById(id));
	}
}
