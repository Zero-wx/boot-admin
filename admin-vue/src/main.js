import {createApp} from 'vue'
import App from './App.vue'


import pinia from "@/store/idnex";
import router from './router/index'


import '@/styles/global.scss' // 全局Css


createApp(App).use(router)
    .use(pinia)
    .mount('#app')
