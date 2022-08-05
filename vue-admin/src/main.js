import {createApp} from 'vue'
import App from './App.vue'
import router from './router'

import {createPinia} from 'pinia';

import "@/permission"

// 样式文件
import '@/styles/global.scss'

const app = createApp(App);

// 注册全局组件
app.use(createPinia())
    .use(router)
    .mount('#app')
