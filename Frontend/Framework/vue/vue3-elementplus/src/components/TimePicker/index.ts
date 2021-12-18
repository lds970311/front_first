//CREATE AT: 2021-12-17
import {App} from "vue";
import TimePicker from "./src/TimePicker.vue";

export default {
    install(app: App) {
        app.component("TimePicker", TimePicker)
    }
}
