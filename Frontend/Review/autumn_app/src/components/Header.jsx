import React, {Component, createRef} from 'react';
import {nanoid} from "nanoid";


class Header extends Component {
    handleClick(event) {
        console.log(event.target.text)
        console.log(this.myRef.current.id)
        if (this.state.btnText === '123') {
            this.setState({
                btnText: '456',
            }, () => console.log("hahaha"))
        } else {
            this.setState({
                btnText: '123'
            })
        }
    }

    addOl() {
        this.setState({
            list2: [...this.state.list2, {
                id: nanoid(3),
                text: this.myRef.current.value
            }]
        })

    }

    deleteOl(id) {
        const newList = this.state.list2.filter(item => {
            return item.id !== id
        })
        this.setState((preState, props) => {
            return {
                list2: newList,
            }
        })
    }

    constructor(props) {
        super(props);
        this.state = {
            btnText: "123",
            list: ["1111", "2222", "3333"],
            list2: [
                {
                    id: 1,
                    text: "1111"
                },
                {
                    id: 2,
                    text: "2222"
                },
                {
                    id: 3,
                    text: "3333"
                }],
            content: "<p>React.js是一个构建UI的库</p>"
        }
    }

    myRef = createRef();

    render() {

        return (
            <>
                <h1 style={{
                    color: 'red',
                    fontSize: '24px'
                }}>React App Evan</h1>
                <label htmlFor="username">
                    输入您的用户名: <input type="text" id="username" name="username" ref={this.myRef}/>
                </label>
                <button onClick={(e) => this.handleClick(e)}>{this.state.btnText}</button>
                <button onClick={() => this.addOl()}>add ol</button>
                <ul>
                    {
                        this.state.list.map((item, index) => {
                            return (
                                <li key={index}>{item}</li>
                            )
                        })
                    }
                </ul>
                <ol>
                    {this.state.list2.length === 0 ? <p>暂无数据</p> : null}
                    {

                        this.state.list2.map((item, index) => {
                            return (
                                <li key={item.id} onDoubleClick={() => this.deleteOl(item.id)}>
                                    {item.text}
                                </li>
                            )
                        })
                    }
                </ol>
                <div dangerouslySetInnerHTML={{__html: this.state.content}}>

                </div>
            </>
        );
    }
}


export default Header;
