import React, {Component} from "react";
import axios from "axios";
import BetterScroll from "better-scroll";

export default class Cinema extends Component {

    constructor(props, context) {
        super(props, context);
        this.state = {
            cinemaList: [],
            inputValue: ""
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
                <input onChange={e => this.handleInput(e)} value={this.state.inputValue}/>
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
        this.setState({
            inputValue: event.target.value
        })
        const newList = this.state.cinemaList.filter(item => item.name.toUpperCase().includes(this.state.inputValue) ||
            item.address.toUpperCase().includes(this.state.inputValue)
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

