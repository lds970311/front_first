//CREATE AT: 2021-12-14
import {App} from 'vue'
import AreaChooser from "./src/AreaChooser.vue";

export default {
    install(app: App) {
        app.component('AreaChooser', AreaChooser)
    }
}
