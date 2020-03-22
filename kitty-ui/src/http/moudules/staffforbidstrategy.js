import axios from '../axios'

/* 
 * 人员管理模块
 */

// 保存
export const save = (data) => {
    return axios({
        url: '/staffForbidstrategy/save',
        method: 'post',
        data
    })
}
// 删除
export const batchDelete = (data) => {
    return axios({
        url: '/staffForbidstrategy/delete',
        method: 'post',
        data
    })
}
// 关键字查询
export const findById = (data) => {
    return axios({
        url: '/staffForbidstrategy/findById',
        method: 'post',
        data
    })
}
// 分页查询
export const findPage = (data) => {
    return axios({
        url: '/staffForbidstrategy/findPage',
        method: 'post',
        data
    })
}
// 查找人员ID查找
export const findPermissions = (params) => {
    return axios({
        url: '/staffForbidstrategy/findPermissions',
        method: 'get',
        params
    })
}
