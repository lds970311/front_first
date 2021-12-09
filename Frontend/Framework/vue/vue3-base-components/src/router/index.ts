//CREATE AT: 2021-12-09
import {createRouter, createWebHashHistory} from "vue-router";
import Home from "../views/Home.vue";

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: '/',
            component: Home,
            meta: {
                title: '首页'
            }
        }
    ]
})

export default router
