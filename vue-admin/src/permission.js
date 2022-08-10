/**
 * 权限相关
 */

import router from "@/router"
import { getToken } from "@/utils/auth";

import piniaStore from '@/store'


const whiteList = ["/login"]


router.beforeEach(async (to, from, next) => {
    window.loader.show();
    const {userPiniaStore} = piniaStore()
    const hashToken = getToken()
    if (hashToken) {
        console.log(to.path)
        if (to.path === '/login') {
            // if is logged in, redirect to the home page
            next({path: '/'})
            window.loader.hide();
        } else {
            // 查询用户权限
            const hasGetUserInfo = userPiniaStore.roles.length > 0;
            if (hasGetUserInfo) {
                if (to.matched.length === 0) {
                    from.name ? next({name: from.name}) : next('/401')
                }
            } else {
                try {
                    // get user info
                    const userInfo = await userPiniaStore.getUserInfo()

                    console.log(userInfo)

                } catch (error) {

                }
                next()
                // next()
            }

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