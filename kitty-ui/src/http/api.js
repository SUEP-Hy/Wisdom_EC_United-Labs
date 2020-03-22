/* 
 * 接口统一集成模块
 */
import * as login from './moudules/login'
import * as user from './moudules/user'
import * as dept from './moudules/dept'
import * as role from './moudules/role'
import * as menu from './moudules/menu'
import * as dict from './moudules/dict'
import * as log from './moudules/log'
import * as staffBasic from './moudules/staffbasic'
import * as staffContact from './moudules/staffcontact'
import * as staffDictionary from './moudules/staffdictionary'
import * as staffExperience from './moudules/staffexperience'
import * as staffFamily from './moudules/stafffamily'
import * as staffPact from './moudules/staffpact'
import * as staffPayroll from './moudules/staffpayroll'
import * as staffPhysical from './moudules/staffphysical'
import * as staffProtocol from './moudules/staffprotocol'
import * as staffResident from './moudules/staffresident'
import * as staffTrain from './moudules/stafftrain'

import * as staffAttendancesys from './moudules/staffattendancesys'
import * as staffBiofeature from './moudules/staffbiofeature'
import * as staffForbidapproval from './moudules/staffforbidapproval'
import * as staffForbidstrategy from './moudules/staffforbidstrategy'
import * as staffDeviceregistter from './moudules/staffdeviceregistter'
import * as staffSummary from './moudules/staffsummary'
import * as staffInout from './moudules/staffinout'

// 默认全部导出
export default {
    login,
    user,
    dept,
    role,
    menu,
    dict,
    log,
    staffAttendancesys,
    staffBasic,
    staffContact,
    staffDictionary,
    staffExperience,
    staffFamily,
    staffPact,
    staffPayroll,
    staffPhysical,
    staffProtocol,
    staffResident,
    staffTrain,
    staffBiofeature,
    staffForbidapproval,
    staffForbidstrategy,
    staffDeviceregistter,
    staffSummary,
    staffInout
}
