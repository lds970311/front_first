import React, {Component} from 'react';
import "../styles/switcher.css"
import axios from "axios";
import BetterScroll from "better-scroll"

const Center = () => {
    return (
        <div>
            center组件
        </div>
    );
};


class Cinema extends Component {

    constructor(props, context) {
        super(props, context);
        this.state = {
            cinemaList: []
        }
        axios({
            url: "https://m.maizuo.com/gateway?cityId=110100&ticketFlag=1&k=7406159",
            method: "get",
            headers: {
                'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.0.4","e":"16395416565231270166529","bc":"110100"}',
                'X-Host': 'mall.film-ticket.cinema.list'

            }
        }).then(res => {

            this.setState({
                cinemaList: res.data.data.cinemas,
            }, () => {
                console.log(this.state.cinemaList)
                this.initScroll()
            })
        })
    }

    render() {
        return (
            <div className="cinema">
                <input onInput={this.handleInput}/>
                {
                    this.state.cinemaList.map(item =>
                        <dl key={item.cinemaId}>
                            <dt>{item.name}</dt>
                            <dd>{item.address}</dd>
                        </dl>
                    )
                }
            </div>
        );
    }

    handleInput = event => {
        console.log("input", event.target.value)

        const newList = this.state.cinemaList.filter(item => item.name.toUpperCase().includes(event.target.value.toUpperCase()) ||
            item.address.toUpperCase().includes(event.target.value.toUpperCase())
        )
        this.setState({
            cinemaList: newList
        })
    }

    initScroll() {
        let bs = new BetterScroll('.cinema', {
            movable: true,
            zoom: true
        })
    }
}


const Film = () => {
    return (
        <div>
            film组件
        </div>
    );
};


class Swither extends Component {

    constructor(props, context) {
        super(props, context);
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
                }
            ],
            current: 1
        }
    }

    selectComponent() {
        const {current} = this.state;
        switch (current) {
            case 1:
                return <Center/>
            case 2:
                return <Cinema/>
            case 3:
                return <Film/>
            default:
                return null
        }
    }

    render() {
        return (
            <div className="swither">
                {this.selectComponent()}
                <ul>
                    {
                        this.state.list.map(item => {
                            return (
                                <li key={item.id}
                                    className={this.state.current === item.id ? "active" : ""}
                                    onClick={() => this.changeActive(item.id)}>
                                    {item.text}
                                </li>
                            )
                        })
                    }
                </ul>
            </div>
        );
    }

    changeActive(id) {
        this.setState({current: id})
    }
}

export default Swither;
