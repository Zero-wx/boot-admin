import axios from 'axios'

const service = axios.create({
    baseURL: process.env.VUE_APP_BASE_API || "http://loaclhost:8080",
    timeout: 3000
})

// 请求前
service.interceptors.request.use(config => {
    console.log('请求前')
    console.log(config)





})

// 响应后
service.interceptors.response.use(config => {
    console.log('请求后')
})


export default service
