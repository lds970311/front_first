//CREATE AT: 2021-12-12
import {createRouter, createWebHistory, RouteRecordRaw} from "vue-router";
import IconChooser from "../components/IconChooser/index.vue";
import AreaChooser from "../components/AreaChooser/index.vue";
import TrendSign from "../components/TrendSign/index.vue";
import Notifier from "../components/Notifier/index.vue";

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
    },
    {
        path: '/trend',
        component: TrendSign,
        meta: {
            title: '趋势标记',
            icon: 'Discount'
        }
    },
    {
        path: '/notifier',
        component: Notifier,
        meta: {
            title: '通知菜单组件',
            icon: 'BellFilled'
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
