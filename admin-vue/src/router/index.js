import {createRouter, createWebHashHistory} from 'vue-router'

// Layout布局架构

import Layout from '@/layout'

const routes = [
    {
        path: '/',
        redirect: '/dashboard',
        component: Layout,
        children: [
            {
                path: 'dashboard',
                component: () => import('@/views/dashboard/index'),
            }
        ]
        // children: [{
        //     path: 'dashboard',
        //     name: 'dashboard',
        //     // component: () => import('@/views/dashboard/index'),
        //     component: () => import('@/views/login/index')
        // }]
    },
    // {
    //     path: '/login',
    //     name: 'login',
    //     meta: {title: 'login'},
    //     component: () => import('@/views/login/index'),
    //     hidden: true
    // },
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router
