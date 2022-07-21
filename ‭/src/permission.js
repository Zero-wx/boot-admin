// 权限
import router from "@/router";
// import Stores from '@/store';


const whiteList = ["/login"]; // 路由白名单
router.beforeEach(async (to, from, next) => {

    console.log("路由");

    window.loader.show();

    // window.loader.show();


    const hasToken = false;
    if (hasToken) {


    } else {
        // token is false
        if (whiteList.indexOf(to.path) !== -1) {
            console.log("asd");
            await next();
        } else {
            await next(`/login?redirect=${to.path}`);

        }
    }
});


router.afterEach(() => {


    setTimeout(() => {
        window.loader.hide();
    }, 1500);


    console.log("结束");
    // finish progress bar
    // NProgress.done()
});






