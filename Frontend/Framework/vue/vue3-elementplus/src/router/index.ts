//CREATE AT: 2021-12-12
import {createRouter, createWebHistory, RouteRecordRaw} from "vue-router";
import IconChooser from "../components/IconChooser/IconChooser.vue";
import AreaChooser from "../components/AreaChooser/index.vue";

const routes: RouteRecordRaw[] = [
    {
        path: '/',
        component: () => import("../views/Home.vue"),
        meta: {
            title: '首页',
            icon: "HomeFilled",
        },
    },
    {
        path: '/icon',
        component: IconChooser,
        meta: {
            title: "图标选择器",
            icon: "Place"
        }
    }, {
        path: '/areachooser',
        component: AreaChooser,
        meta: {
            title: "省市区选择器",
            icon: "Location"
        }
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

router.afterEach((transition) => {
    // @ts-ignore
    document.title = transition.meta.title
})

export {routes}
export default router
