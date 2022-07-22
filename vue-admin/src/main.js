import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

import '@/styles/global.scss'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'


import "@/permission"


createApp(App).use(ElementPlus).use(router).mount('#app')
