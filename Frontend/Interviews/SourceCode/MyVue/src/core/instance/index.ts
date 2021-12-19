//CREATE AT: 2021-12-18
import {initMixin} from "./init";
import {VueOptions} from "../../@types/vueOptions.type";

function Vue(this: any, options: VueOptions) {
    console.log("vue is here!!")
    if (this instanceof Vue) {
        // warn('Vue实例必须使用 `new` 关键字')
    }
    this._init(options)
}

initMixin(Vue) //实现_init

export default Vue
