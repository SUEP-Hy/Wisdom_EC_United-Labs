import axios from '../axios'

/* 
 * 人员管理模块
 */

// 保存
export const save = (data) => {
    return axios({
        url: '/staffSummary/save',
        method: 'post',
        data
    })
}
// 删除
export const batchDelete = (data) => {
    return axios({
        url: '/staffSummary/delete',
        method: 'post',
        data
    })
}
// 关键字查询
export const findById = (data) => {
    return axios({
        url: '/staffInout/findById',
        url: '/staffProtocol/findById',
        url: '/staffBasic/findById',
        url: '/staffContact/findById',
        url: '/staffResident/findById',
        url: '/staffTrain/findById',
        url: '/staffExperience/findById',
        url: '/staffFamily/findById',
        url: '/staffPact/findById',
        url: '/staffPayroll/findById',
        url: '/staffPhysical/findById',
        url: '/staffBiofeature/findById',
        method: 'post',
        data
    })
}
// 分页查询
export const findPage = (data) => {
    return axios({
        url: '/staffSummary/findPage',
        method: 'post',
        data
    })
}
// 查找人员ID查找
export const findPermissions = (params) => {
    return axios({
        url: '/staffSummary/findPermissions',
        method: 'get',
        params
    })
}
