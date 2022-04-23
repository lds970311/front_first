import React, {Component} from 'react';
import Swiper, {Navigation, Pagination} from 'swiper'
import axios from "axios";

class MySwiper extends Component {
    state = {
        list: [],
    }

    componentDidMount() {
        axios({
            url: "https://m.maizuo.com/gateway?type=2&cityId=110100&k=7398342",
            headers: {
                "X-Client-Info":
                    '{"a":"3000","ch":"1002","v":"5.2.0","e":"16395416565231270166529","bc":"110100"}',
                "X-Host": "mall.cfg.common-banner",
            },
        }).then((res) => {
            console.log(res);
            this.setState({
                list: res.data.data,
            }, () => {
                new Swiper(".swiper", {
                    // 如果需要分页器
                    pagination: {
                        el: ".swiper-pagination",
                    },
                    loop: true,
                });
            });
        });
    }

    render() {
        return (
            <div className="swiper">
                <div className="swiper-wrapper">{
                    this.state.list.map(item => {
                        return (
                            <KSwiperItem key={item.bannerId}>
                                <img
                                    src={item.imgUrl}
                                    alt={item.name}
                                    style={{width: "100%"}}
                                />
                            </KSwiperItem>
                        )
                    })
                }</div>

                <div className="swiper-pagination"></div>
            </div>
        );
    }
}

class KSwiperItem extends Component {
    render() {
        return <div className="swiper-slide">{this.props.children}</div>;
    }
}

export default MySwiper;
