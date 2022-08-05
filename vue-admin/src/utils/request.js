import axios from "axios";
import { getToken } from "@/utils/auth";

const service = axios.create({
    baseURL: process.env.VUE_APP_BASE_API,
    withCredentials: false,
    timeout: 1000
})
// 请求前
service.interceptors.request.use(
    config => {
        const token = getToken();
        if (token) {
            config.headers['Authorization'] = token
        }
        return config
    },
    error => {
        console.log(error)
        return Promise.reject(error)
    }
)

// 响应
service.interceptors.response.use(
    response => {
        console.log(response, '返回')
        const res = response.data
        if (response.headers.token) {
            // 如果后台返回token，说明token已经更新，直接更新web客户端token
        }
        if (res.code !== 2000) {
            console.log('asd')
            ElMessage({
                message: res.message || 'error',
                grouping: true,
                type: 'error',
                duration: 5 * 1000
            })
            // 50008: Illegal token; 50012: Other clients logged in; 50014: Token expired;
            if (res.code === 50008 || res.code === 50012 || res.code === 50014) {

            }
            return Promise.reject(res)
        } else {
            return res
        }
    }, error => {
        // 接口级错误
        console.log(error)
        ElMessage({
            message: error.message,
            type: 'error',
            duration: 5 * 1000
        })
        return Promise.reject(error)
    }
)


export default service;