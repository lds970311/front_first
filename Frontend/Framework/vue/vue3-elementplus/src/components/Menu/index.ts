//CREATE AT: 2021-12-16
import {App} from "vue";
import Menu from "./src/Menu.vue";
import InfiniteMenu from "./src/InfiniteMenu.vue";

export default {
    install(app: App) {
        app.component("Menu", Menu)
        app.component("InfiniteMenu", InfiniteMenu)
    }
}
