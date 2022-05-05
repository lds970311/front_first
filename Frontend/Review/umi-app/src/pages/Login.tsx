import React, {Component, useEffect} from 'react';
import {Button, Space} from 'antd-mobile'


class Login extends Component<any, any> {
  componentDidMount() {
    fetch('/users')
      .then(res => res.json())
      .then(res => console.log(res))
  }

  state = {
    userName: "",
    password: ""
  }

  private setUsername(value: string) {
    this.setState({userName: value})
  }

  render() {
    return (
      <div>
        <Space wrap>
          <Button
            onClick={() => {
              alert('hello.')
            }}
          >
            Default
          </Button>
          <Button color='warning'>Warning</Button>
        </Space>
        <input type="text" onChange={(evt) => this.setUsername(evt.target.value)}/>
        <input type="password" onChange={(evt) => this.setPassword(evt.target.value)}/>
        {/* {username} -{password} */}
        <button onClick={() => {
          fetch("/users/login", {
            method: "POST",
            headers: {
              "Content-Type": "application/json"
            },
            body: JSON.stringify({
              username: this.state.userName,
              password: this.state.password
            })
          }).then(res => res.json())
            .then(res => {
              console.log(res)
              if (res.ok) {
                localStorage.setItem("token", this.state.userName)
                this.props.history.push(`/center`)
              } else {
                alert("用户名密码不匹配")
              }
            })
        }}>登录
        </button>
      </div>
    );
  }

  private setPassword(value: string) {
    this.setState({
      password: value
    })
  }
}

export default Login;
