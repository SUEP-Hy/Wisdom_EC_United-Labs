package edu.suep.smart.admin.sevice;

import java.util.List;

import edu.suep.smart.admin.model.SysDept;
import edu.suep.smart.core.service.CurdService;

/**
 * 机构管理
 * @author Louis
 * @date Oct 29, 2018
 */
public interface SysDeptService extends CurdService<SysDept> {

	/**
	 * 查询机构树
	 * @param userId 
	 * @return
	 */
	List<SysDept> findTree();
}
