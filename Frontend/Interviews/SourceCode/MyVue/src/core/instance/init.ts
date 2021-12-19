//CREATE AT: 2021-12-18
import {VueOptions} from "../../@types/vueOptions.type";

export function initMixin(Vue) {
    Vue.prototype._init = function (options: VueOptions) {
        // console.log("vue init", options)
        const vm = this
        if (options && options._isComponent) {

        } else {
            vm.$options = options
        }

        if (vm.$options.el) {
            vm.$mount(vm.$options.el)
        }
    }
}
