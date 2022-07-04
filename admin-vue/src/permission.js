// 权限
import router from '@/router'
import Stores from '@/store';


const whiteList = ['/login'] // 路由白名单
router.beforeEach(async (to, from, next) => {

    const hasToken = false;
    const store = Stores()

    console.log(store, '用户的store','ceshi ')

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






