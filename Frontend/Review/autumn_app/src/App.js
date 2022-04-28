// import Header from "./components/Header";
import IndexRouter from "./router";
import {Provider} from "mobx-react";
import myMobx from "./mobx";

function App() {
    return (
        <div className="App">
            <Provider MobxStore={myMobx}>
                <IndexRouter/>
            </Provider>
        </div>
    );
}


export default App;
