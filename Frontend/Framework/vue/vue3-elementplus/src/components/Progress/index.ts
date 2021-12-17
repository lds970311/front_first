//CREATE AT: 2021-12-16
import {App} from "vue";
import Progress from "./src/Progress.vue";

export default {
    install(app: App) {
        app.component("Progress", Progress)
    }
}
