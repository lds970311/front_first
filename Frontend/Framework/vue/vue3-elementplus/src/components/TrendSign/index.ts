//CREATE AT: 2021-12-14
import {App} from "vue";
import TrendSign from "./TrendSign.vue";

export default {
    install(app: App) {
        app.component("TrendSign", TrendSign)
    }
}
