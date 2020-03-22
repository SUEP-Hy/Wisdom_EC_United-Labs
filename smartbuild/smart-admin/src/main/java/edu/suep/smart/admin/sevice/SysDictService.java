package edu.suep.smart.admin.sevice;

import java.util.List;

import edu.suep.smart.admin.model.SysDict;
import edu.suep.smart.core.service.CurdService;

/**
 * 字典管理
 * @author Louis
 * @date Oct 29, 2018
 */
public interface SysDictService extends CurdService<SysDict> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysDict> findByLable(String lable);
}
