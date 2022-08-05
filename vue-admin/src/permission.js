/**
 * 权限相关
 */

import router from "@/router"
import { getToken } from "@/utils/auth";


const whiteList = ["/login"]


router.beforeEach(async (to, from, next) => {
    window.loader.show();

    const hashToken = getToken()
    if (hashToken) {
        console.log(to.path)
        if (to.path === '/login') {
            // if is logged in, redirect to the home page
            next({ path: '/' })
            window.loader.hide();
        }else {
            next()
        }

    } else {
        if (whiteList.indexOf(to.path) !== -1) {
            await next();
        } else {
            await next(`/login?redirect=${to.path}`)
        }
    }


})

router.afterEach(() => {
    setTimeout(() => {
        window.loader.hide();
    }, 1500);
})