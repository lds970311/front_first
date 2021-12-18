//CREATE AT: 2021-12-12
import {createRouter, createWebHistory, RouteRecordRaw} from "vue-router";
import IconChooser from "../components/IconChooser/src/index.vue";
import AreaChooser from "../components/AreaChooser/src/index.vue";
import TrendSign from "../components/TrendSign/src/index.vue";
import Notifier from "../components/Notifier/src/index.vue";
import Menu from "../components/Menu/src/index.vue";
import Progress from "../components/Progress/src/index.vue";
import TimePicker from "../components/TimePicker/src/index.vue";
import DatePicker from "../components/DatePicker/src/index.vue";
import CitySelector from "../components/CitySelector/src/index.vue";

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
    },
    {
        path: '/menu',
        component: Menu,
        meta: {
            title: "导航菜单",
            icon: 'Eleme'
        }
    },
    {
        path: '/progress',
        component: Progress,
        meta: {
            title: "进度条",
            icon: "Operation"
        }
    },
    {
        path: '/timepicker',
        component: TimePicker,
        meta: {
            title: "时间选择器",
            icon: "Timer"
        }
    },
    {
        path: '/datepicker',
        component: DatePicker,
        meta: {
            title: "日期选择器",
            icon: "DataBoard"
        }
    },
    {
        path: '/cityselector',
        component: CitySelector,
        meta: {
            title: "城市选择器",
            icon: "Coin"
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
