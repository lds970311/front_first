//CREATE AT: 2021-12-14
import {App} from "vue";
import AreaChooser from "./AreaChooser/index";
import IconChooser from "./IconChooser";
import TrendSign from "./TrendSign/index";
import SimpleNotifier from "./Notifier/index";
import Menu from "./Menu/index";
import TimePicker from "./TimePicker/index";
import DatePicker from "./DatePicker/index";
import CitySelector from "./CitySelector/index";

const components = [
    AreaChooser,
    IconChooser,
    TrendSign,
    SimpleNotifier,
    Menu,
    TimePicker,
    DatePicker,
    CitySelector
]

export default {
    install(app: App) {
        components.map(item => {
            app.use(item)
        })
    }
}
