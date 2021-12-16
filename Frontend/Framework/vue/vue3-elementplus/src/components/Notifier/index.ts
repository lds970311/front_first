//CREATE AT: 2021-12-15
import {App} from "vue";
import SimpleNotifier from "./SimpleNotifier.vue"
import ComplexNotifier from "./ComplexNotifier.vue";

export default {
    install(app: App) {
        app.component('SimpleNotifier', SimpleNotifier)
        app.component("ComplexNotifier", ComplexNotifier)
    }
}
