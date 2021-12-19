//CREATE AT: 2021-12-18
import Vue from './runtime/index'
import {query} from './util/index'

Vue.prototype.$mount = function (el, hydrating) {
    el = el && query(el)
    console.log("mounted", el)
    const options = this.$options
}

export default Vue
