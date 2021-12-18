//CREATE AT: 2021-12-17
import {App} from "vue";
import DatePicker from "./src/DatePicker.vue";

export default {
    install(app: App) {
        app.component("DatePicker", DatePicker)
    }
}
