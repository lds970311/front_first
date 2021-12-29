//CREATE AT: 2021-12-28
let Vue;

class MyRouter {
    constructor(options) {
        this.$options = options
        this.hash = "/"
        Vue.util.defineReactive(this, 'hash', '/')
        window.addEventListener("hashchange", () => {
            this.hash = window.location.hash.substring(1);
        })
        window.addEventListener("load", () => {
            this.hash = window.location.hash.substring(1);
        })
    }

    static install(MyVue) {
        Vue = MyVue
        //挂载$router

        Vue.mixin({
            beforeCreate() {
                if (this.$options.router) {
                    //确保根实例财智星
                    Vue.prototype.$router = this.$options.router
                }
            }
        })
        MyRouter.initLink(Vue)
        MyRouter.initView(Vue)
    }

    static initLink(MyVue) {
        //实现两个全局组件 <my-link to="/xxx"/> <my-view>
        MyVue.component('my-link', {
            props: {
                to: {
                    type: String,
                    required: true
                }
            },
            render(h) {

                return h("a", {attrs: {href: '#' + this.to}}, this.$slots.default)
            }
        })
    }

    static initView(MyVue) {
        MyVue.component('my-view', {
            render(h) {
                const {routes} = this.$router.$options
                console.log(this.$router.hash)
                let comp;
                routes.forEach(route => {
                    if (route.path === this.$router.hash) {
                        comp = route.component
                    }
                })
                return h(comp)
            }
        })
    }

}


export default MyRouter
