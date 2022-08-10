import request from "@/utils/request";

/**
 * 用户登录
 * @param params
 * @returns {*}
 */
export function login(params) {
    return request({
        url: '/account/login',
        method: 'post',
        data: params
    })
}

/**
 * 用户详情
 * @returns {*}
 */
export function userInfo() {
    return request({
        url: '/account/userInfo',
        method: 'post'
    })
}