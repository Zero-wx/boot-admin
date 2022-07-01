// 权限
import router from '@/router'
import store from '@/store'

const whiteList = ['/login'] // 路由白名单

router.beforeEach(async (to, from, next) => {

    const hasToken = false;

    if (hasToken) {

    } else {
        // token is false
        if (whiteList.indexOf(to.path) !== -1) {
            await next()
        } else {
            await next(`/login?redirect=${to.path}`)
        }
    }
})


router.afterEach(() => {
    // finish progress bar
    // NProgress.done()
})
