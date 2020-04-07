package edu.suep.smart.admin.sevice;

import edu.suep.smart.admin.model.StaffContact;
import edu.suep.smart.core.service.CurdService;

import java.util.List;


/**
 * ---------------------------
 * 联系信息表 (StaffContactService)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface StaffContactService extends CurdService<StaffContact> {

    List<StaffContact> findById(int id);

}
