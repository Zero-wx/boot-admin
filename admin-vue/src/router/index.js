import {createRouter, createWebHashHistory} from 'vue-router'


const routes = [
    {
        path: '/',
        redirect: '/dashboard',
        children: [{
            path: 'dashboard',
            name: 'dashboard',
            component: () => import('@/views/dashboard/index'),
        }]
    },
    {
        path: '/login',
        name: 'login',
        meta: {title: 'login'},
        component: () => import('@/views/login/index'),
        hidden: true
    },
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router
