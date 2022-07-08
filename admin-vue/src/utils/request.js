import axios from 'axios'

const service = axios.create({
    // baseURL: process.env.VUE_APP_BASE_API || "http://loaclhost:8080",
    baseURL: "http://localhost:8088/api-v1/",
    timeout: 3000
})

// 请求前
service.interceptors.request.use(config => {
    console.log('请求前')
    console.log(config)

    const token = true

    if (token) {
        config.headers['X-Token'] = 'token12123132'
    }

    return config;

}, error => {
    console.log(error, '错误') // for debug
    return Promise.reject(error)
})

// 响应后
service.interceptors.response.use(config => {
    console.log('请求后')


    console.log(config)

}, error => {
    console.log(error)
})


export default service
