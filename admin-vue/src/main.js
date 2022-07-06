import {createApp} from 'vue'
import App from './App.vue'

import {createPinia} from 'pinia';

const app = createApp(App);

//

import '@/styles/global.scss' // 全局Css
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import router from '@/router' // 路由
import '@/permission' // 权限


import * as ElIconModules from '@element-plus/icons-vue';
for (let iconName in ElIconModules) {
    app.component(iconName, ElIconModules[iconName])
}

app.use(router).use(createPinia()).use(ElementPlus).mount('#app')


//
// createApp(App).use(createPinia()).use(router).mount('#app')
// createApp(App).use(createPinia()).use(router).mount('#app')
