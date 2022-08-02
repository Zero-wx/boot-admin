import {createApp} from 'vue'
import App from './App.vue'
import router from './router'


import '@/styles/global.scss'
import "@/permission"




createApp(App).use(router).mount('#app')
