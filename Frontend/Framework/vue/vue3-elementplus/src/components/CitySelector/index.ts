//CREATE AT: 2021-12-17
import {App} from "vue";
import CitySelector from "./src/CitySelector.vue";

export default {
    install(app: App) {
        app.component("CitySelector", CitySelector)
    }
}
