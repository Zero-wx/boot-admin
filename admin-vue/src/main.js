import {createApp} from 'vue'
import App from './App.vue'


import pinia from "@/store";
import router from '@/router'


import '@/styles/global.scss' // 全局Css

import '@/permission'

createApp(App).use(router)
    .use(pinia)
    .mount('#app')
