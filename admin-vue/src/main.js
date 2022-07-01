import {createApp} from 'vue'
import App from './App.vue'


import pinia from "@/store/idnex";
import Router from './router/index'


import '@/styles/global.scss' // 全局Css
import router from './router'

createApp(App).use(router)
    .use(Router)
    .use(pinia)
    .mount('#app')
