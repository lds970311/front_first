//CREATE AT: 2021-12-14
import {App} from "vue";
import IconChooser from "./src/IconChooser.vue";

export default {
    install(app: App) {
        app.component('IconChooser', IconChooser)
    }
}
