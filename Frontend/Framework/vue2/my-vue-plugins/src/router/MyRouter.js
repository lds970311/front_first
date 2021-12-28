//CREATE AT: 2021-12-28
let Vue;

class MyRouter {
    constructor(options) {
        this.$options = options
        this.hash = "/"
        window.addEventListener("hashchange", this.handleHashChange)
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

    handleHashChange() {
        const {router} = this.$options
        this.hash = window.location.hash.substring(1);
        const route = router.find(item => item.path === this.hash);
        document.body = route.component
    }
}


export default MyRouter
