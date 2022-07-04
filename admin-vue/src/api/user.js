import service from "@/utils/request";

export function login(params) {
    return service({
        url: '/account/login',
        method: 'post',
        data: params
    })
}
