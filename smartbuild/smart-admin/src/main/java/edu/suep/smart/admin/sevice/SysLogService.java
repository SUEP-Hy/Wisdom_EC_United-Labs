package edu.suep.smart.admin.sevice;

import edu.suep.smart.admin.model.SysLog;
import edu.suep.smart.core.service.CurdService;
import org.springframework.stereotype.Component;

/**
 * 日志管理
 * @author Louis
 * @date Oct 29, 2018
 */
@Component
public interface SysLogService extends CurdService<SysLog> {

}
