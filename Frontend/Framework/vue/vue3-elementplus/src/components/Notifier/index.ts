//CREATE AT: 2021-12-15
import {App} from "vue";
import SimpleNotifier from "./src/SimpleNotifier.vue"
import ComplexNotifier from "./src/ComplexNotifier.vue";

export default {
    install(app: App) {
        app.component('SimpleNotifier', SimpleNotifier)
        app.component("ComplexNotifier", ComplexNotifier)
    }
}
