//CREATE AT: 2021-12-14
import {App} from "vue";
import AreaChooser from "./AreaChooser/index";
import IconChooser from "./IconChooser";
import TrendSign from "./TrendSign/index";
import SimpleNotifier from "./Notifier/index";
import Menu from "./Menu/index";

const components = [
    AreaChooser,
    IconChooser,
    TrendSign,
    SimpleNotifier,
    Menu
]

export default {
    install(app: App) {
        components.map(item => {
            app.use(item)
        })
    }
}
