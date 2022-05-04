import React, {Component, useCallback, useEffect, useLayoutEffect, useRef, useState} from 'react';
import {Consumer} from "../../utils/myContext";
import "../../styles/hot.css"
import axios from "axios";
import PropTypes from "prop-types";
import {useHistory} from "react-router-dom";

/*import MySwiper from "../MySwiper/MySwiper"*/
import {Badge, TabBar} from 'antd-mobile'
import {Image, List, InfiniteScroll} from "antd-mobile";


const tabs = [
    {
        key: 1,
        title: '正在热映',
        type: 1,
        badge: Badge.dot,
    },
    {
        key: 2,
        title: '即将上映',
        type: 2,
        badge: '5',
    },
    {
        key: 3,
        title: '经典电影',
        type: 3,
        badge: '99+',
    },
]

class Hot extends Component {

    state = {
        type: 1,

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

    handleTabChange(key) {
        const type = Number(key)
        this.setState({
            type
        })
    }

    render() {
        return (
            <div>
                <TabBar onChange={(key) => this.handleTabChange(key)}>
                    {tabs.map(item => (
                        <TabBar.Item key={item.key} title={item.title}/>
                    ))}
                </TabBar>

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
    const [hasMore, sethasMore] = useState(true);
    const count = useRef(0);

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

    const loadMore = useCallback(() => {
        console.log("到底了 ");
        count.current++;

        sethasMore(false);
        axios({
            url: `https://m.maizuo.com/gateway?cityId=110100&pageNum=${count.current}&pageSize=10&type=1&k=1886067`,
            headers: {
                "X-Client-Info":
                    '{"a":"3000","ch":"1002","v":"5.2.0","e":"16395416565231270166529","bc":"110100"}',
                "X-Host": "mall.film.js-ticket.film.js.list",
            },
        }).then((res) => {
            // console.log(res.data.data.films)
            setList([...list, ...res.data.data.films]);

            sethasMore(res.data.data.films.length > 0);
        });
    }, [list]);

    useEffect(() => {
        if (type === 1) {
            //请求卖座正在热映的数据
            console.log("请求卖座正在热映的数据");
            axios({
                url: "https://m.maizuo.com/gateway?cityId=110100&pageNum=1&pageSize=10&type=1&k=6369301",
                headers: {
                    "X-Client-Info":
                        '{"a":"3000","ch":"1002","v":"5.2.0","e":"16395416565231270166529","bc":"110100"}',
                    "X-Host": "mall.film.js-ticket.film.js.list",
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
                    "X-Host": "mall.film.js-ticket.film.js.list",
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
            <List>
                {list.map((item) => (
                    <List.Item onClick={() => history.push(`/detail/${item.filmId}`)
                    } key={item.filmId}
                               prefix={
                                   <Image
                                       src={item.poster}
                                       // style={{ borderRadius: 20 }}
                                       // fit='cover'
                                       width={80}
                                       // height={40}
                                   />
                               }
                               description={
                                   <div>
                                       {item.grade ? (
                                           <div>观众评分:{item.grade}</div>
                                       ) : (
                                           <div style={{visibility: "hidden"}}>观众评分</div>
                                       )}

                                       <div>主演：{item.director}</div>
                                       <div>
                                           {item.nation}|{item.runtime}分钟
                                       </div>
                                   </div>
                               }>{item.name}</List.Item>
                ))}
                <InfiniteScroll loadMore={loadMore} hasMore={hasMore}/>
            </List>
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
                    "X-Host": "mall.film.js-ticket.film.js.list",
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
                    "X-Host": "mall.film.js-ticket.film.js.list",
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
                    'X-Host': 'mall.film.js-ticket.film.js.list'
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
                    'X-Host': 'mall.film.js-ticket.film.js.list'
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
