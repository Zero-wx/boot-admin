import axios from 'axios'

const service = axios.create({
    baseURL: process.env.VUE_APP_BASE_API || "http://loaclhost:8080",
    timeout: 3000
})

// 请求前
service.interceptors.request.use(config => {

})

// 响应后
service.interceptors.response.use(config => {

})


export default service
