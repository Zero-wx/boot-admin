import {createApp} from 'vue'
import App from './App.vue'

import {createPinia} from 'pinia';
const app = createApp(App);

//

import '@/styles/global.scss' // 全局Css
import router from '@/router' // 路由
import '@/permission' // 权限


app.use(createPinia()).use(router).mount('#app')


//
// createApp(App).use(createPinia()).use(router).mount('#app')
// createApp(App).use(createPinia()).use(router).mount('#app')
