import {createRouter, createWebHashHistory} from "vue-router";
import Books from "../views/Books.vue";


export const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: '/books',
            name: 'books',
            component: Books
        }
    ]
})

export default router
