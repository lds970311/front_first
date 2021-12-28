import MyRouter from "@/router/MyRouter";
import RouterTest from "@/components/RouterTest";
import Vue from "vue";

Vue.use(MyRouter)
const router = new MyRouter({
    mode: "hash",
    routes: [
        {
            path: "/router",
            component: RouterTest,
            meta: {
                title: "my router"
            }
        }
    ],
})

export default router
