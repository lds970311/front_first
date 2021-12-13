//CREATE AT: 2021-12-12
import {createRouter, createWebHistory} from "vue-router";
import Container from "../components/container/Container.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            component: () => import("../views/Home.vue"),
            meta: {
                title: '首页'
            },
        },
        {
            path: '/container',
            component: Container,
            meta: {
                title: '布局'
            }
        }
    ]
})

export default router
