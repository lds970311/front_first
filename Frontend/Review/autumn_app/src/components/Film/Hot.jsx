import React, {Component, useEffect, useLayoutEffect, useState} from 'react';
import {Consumer} from "../../utils/myContext";
import "../../styles/hot.css"
import axios from "axios";
import PropTypes from "prop-types";
import {useHistory} from "react-router-dom";

/*import MySwiper from "../MySwiper/MySwiper"*/


class Hot extends Component {

    state = {
        type: 1
    }

    componentDidMount() {

    }

    shouldComponentUpdate(nextProps, nextState, nextContext) {
        console.log(nextState)
        console.log(nextProps)
        console.log(nextContext)
        return true
    }

    componentWillUnmount() {

    }

    componentDidCatch(error, errorInfo) {

    }

    render() {
        return (
            <div>

                <ul className="hot-topic">
                    <li style={{cursor: 'pointer'}}
                        onClick={() => {
                            this.setState({
                                type: 1,
                            });
                        }}
                    >
                        正在热映
                    </li>
                    <li style={{cursor: 'pointer'}}
                        onClick={() => {
                            this.setState({
                                type: 2,
                            });
                        }}
                    >
                        即将上映
                    </li>
                    <li style={{cursor: 'pointer'}}
                        onClick={() => {
                            this.setState({
                                type: 3,
                            });
                        }}
                    >
                        经典电影
                    </li>
                </ul>

                <Consumer>
                    {
                        data => {
                            return (
                                <div className="consumer">
                                    hot: {data}
                                    {this.props.children}
                                </div>
                            )
                        }
                    }
                </Consumer>
                <FilmList type={this.state.type}/>
            </div>


        );
    }
}


const FilmList = ({type}) => {
    const [list, setList] = useState([])
    const history = useHistory()

    useLayoutEffect(() => {
        window.onresize = () => {
            console.log("resize");
        };

        const timer = setInterval(() => {
        }, 1000);

        return () => {
            console.log("组件销毁");

            window.onresize = null;
            clearInterval(timer);
        };
    }, []);

    useEffect(() => {
        if (type === 1) {
            //请求卖座正在热映的数据
            console.log("请求卖座正在热映的数据");
            axios({
                url: "https://m.maizuo.com/gateway?cityId=110100&pageNum=1&pageSize=10&type=1&k=6369301",
                headers: {
                    "X-Client-Info":
                        '{"a":"3000","ch":"1002","v":"5.2.0","e":"16395416565231270166529","bc":"110100"}',
                    "X-Host": "mall.film-ticket.film.list",
                },
            }).then((res) => {
                setList(res.data.data.films)
            });
        } else if (type === 2) {
            //请求卖座即将上映的数据

            console.log("请求卖座即将上映的数据");

            axios({
                url: "https://m.maizuo.com/gateway?cityId=110100&pageNum=1&pageSize=10&type=2&k=8077848",
                headers: {
                    "X-Client-Info":
                        '{"a":"3000","ch":"1002","v":"5.2.0","e":"16395416565231270166529","bc":"110100"}',
                    "X-Host": "mall.film-ticket.film.list",
                },
            }).then((res) => {
                setList(res.data.data.films)
            });
        } else {
            console.log("经典电影数据: ")
            axios.get("/ajax/moreClassicList?sortId=1&showType=3&limit=10&offset=10&optimus_uuid=B7186F20C34E11EC9556B19FB19558B18CD577F033F9463AB27E5C36DE9F8B77&optimus_risk_level=71&optimus_code=10")
                .then(res => {
                    console.log(res)
                    setList(res.data.classicMovies.list)
                })
        }
    }, [type])

    return (
        <div>
            <div>
                <ol className={"movies"}>
                    {list.map((item) => (
                        <li key={item.filmId}
                            onClick={() => history.push(`/detail/${item.filmId}`)}>{item.name}</li>
                    ))}
                </ol>
            </div>
        </div>
    );
};


FilmList.propTypes = {
    type: PropTypes.number.isRequired
}


/*
class FilmList extends Component {

    static propTypes = {
        type: PropTypes.number.isRequired
    }

    static getDerivedStateFromProps(nextProps) {
        console.log("getDrivedStateFromProps", nextProps)

        return {
            type: nextProps.type
        }
    }

    state = {
        list: []
    }

    componentDidMount() {
        if (this.props.type === 1) {
            //请求卖座正在热映的数据
            console.log("请求卖座正在热映的数据");
            axios({
                url: "https://m.maizuo.com/gateway?cityId=110100&pageNum=1&pageSize=10&type=1&k=6369301",
                headers: {
                    "X-Client-Info":
                        '{"a":"3000","ch":"1002","v":"5.2.0","e":"16395416565231270166529","bc":"110100"}',
                    "X-Host": "mall.film-ticket.film.list",
                },
            }).then((res) => {
                console.log(res.data.data.films);
                this.setState({
                    list: res.data.data.films,
                });
            });
        } else {
            //请求卖座即将上映的数据

            console.log("请求卖座即将上映的数据");

            axios({
                url: "https://m.maizuo.com/gateway?cityId=110100&pageNum=1&pageSize=10&type=2&k=8077848",
                headers: {
                    "X-Client-Info":
                        '{"a":"3000","ch":"1002","v":"5.2.0","e":"16395416565231270166529","bc":"110100"}',
                    "X-Host": "mall.film-ticket.film.list",
                },
            }).then((res) => {
                console.log(res.data.data.films);
                this.setState({
                    list: res.data.data.films,
                });
            });
        }
    }

    componentDidUpdate(prevProps, prevState) {
        console.log(this.state.type)
        if (this.state.type === prevState.type) {
            return
        }

        if (this.state.type === 1) {
            //请求卖座正在热映的数据
            console.log("请求卖座正在热映的数据")
            axios({
                url: "https://m.maizuo.com/gateway?cityId=110100&pageNum=1&pageSize=10&type=1&k=6369301",
                headers: {
                    'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.2.0","e":"16395416565231270166529","bc":"110100"}',
                    'X-Host': 'mall.film-ticket.film.list'
                }
            }).then(res => {
                console.log(res.data.data.films)
                this.setState({
                    list: res.data.data.films
                })
            })
        } else {
            //请求卖座即将上映的数据

            console.log("请求卖座即将上映的数据")
            axios({
                url: "https://m.maizuo.com/gateway?cityId=110100&pageNum=1&pageSize=10&type=2&k=8077848",
                headers: {
                    'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.2.0","e":"16395416565231270166529","bc":"110100"}',
                    'X-Host': 'mall.film-ticket.film.list'
                }
            }).then(res => {
                console.log(res.data.data.films)
                this.setState({
                    list: res.data.data.films
                })
            })
        }
    }

    render() {
        return (
            <div>
                <ol className={"movies"}>
                    {this.state.list.map((item) => (
                        <li key={item.filmId}>{item.name}</li>
                    ))}
                </ol>
            </div>
        );
    }
}
*/


export default Hot;
