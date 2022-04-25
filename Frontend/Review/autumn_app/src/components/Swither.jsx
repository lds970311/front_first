import React, {Component} from 'react';
import "../styles/switcher.css"
import Cinema from "./Film/Cinema";
import Center from "./Film/Center";
import Film from "./Film/Film";
import TabBar from "./Film/TabBar";
import Hot from "./Film/Hot"
import {Provider} from "../utils/myContext";
import store from "../store";

class Swither extends Component {

    constructor(props, context) {
        super(props, context);
        console.log(this.props)
        this.state = {
            list: [
                {
                    id: 1,
                    text: "电影"
                },
                {
                    id: 2,
                    text: "影院"
                },
                {
                    id: 3,
                    text: "我的"
                },
                {
                    id: 4,
                    text: "热门"
                }
            ],
            current: 1
        }
        store.subscribe(() => {
            console.log("swithcer 中订阅")
        })
    }

    selectComponent() {
        const {current} = this.state;
        switch (current) {
            case 1:
                return <Center title={"个人中心"}/>
            case 2:
                return <Cinema/>
            case 3:
                return <Film name={"看电影"}/>
            case 4:
                return <Hot><p>this is p props</p></Hot>
            default:
                return null
        }
    }

    render() {
        return (
            <Provider value="123123">
                <div className="swither">
                    {this.selectComponent()}
                    <TabBar changeActive={index => this.changeActive(index)} defaultValue={this.state.current}
                            list={this.state.list}/>
                </div>
            </Provider>
        );
    }

    changeActive(id) {
        this.setState({current: id})
    }
}

export default Swither;
