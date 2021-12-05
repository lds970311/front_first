//CREATE AT: 2021-12-05
import {createRouter, createWebHashHistory} from "vue-router";


const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: '/',
            component: () => import("../pages/Home.vue"),
            meta: {
                title: "Home"
            }
        }
    ]
})

export default router
