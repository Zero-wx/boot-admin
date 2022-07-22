/**
 * 权限相关
 */

import router from "@/router"

const whiteList = ["/login"]


router.beforeEach(async (to, from, next) => {
    window.loader.show();

    const hashToken = false

    if (hashToken) {



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