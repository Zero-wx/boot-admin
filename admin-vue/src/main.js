import { createApp } from "vue";


import "@/styles/global.scss"





import App from "./App.vue";
const app = createApp(App);

import router from "@/router";
import pinia from "@/store/index"
import '@/permission'





app.use(router)

app.mount("#app");
