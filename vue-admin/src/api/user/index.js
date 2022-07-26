import request from "@/utils/request";


export function login(params) {
    return request({
        url: '/account/login',
        method: 'post',
        data: params
    })
}