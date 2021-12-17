//CREATE AT: 2021-12-14
import {App} from "vue";
import TrendSign from "./src/TrendSign.vue";

export default {
    install(app: App) {
        app.component("TrendSign", TrendSign)
    }
}
