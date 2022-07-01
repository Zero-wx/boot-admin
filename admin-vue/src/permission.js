// 权限
import router from '@/router'
import store from '@/store'

const whiteList = ['/login'] // 路由白名单

router.beforeEach(async (to, from) => {

    const hasToken = false;

    if (hasToken) {

    } else {
        // token is false
        if (whiteList.indexOf(to.path) !== -1) {

        } else {
            return {
                name:'login',
                //path:`/login?redirect=${to.path}`
            }
        }
    }
})
