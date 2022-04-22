import React, {Component} from 'react';
import {Consumer} from "../../utils/myContext";

class Hot extends Component {


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

    getSnapshotBeforeUpdate(prevProps, prevState) {

    }

    componentDidUpdate(prevProps, prevState, snapshot) {

    }

    render() {
        return (
            <Consumer>
                {
                    data => {
                        return (
                            <div>
                                hot: {data}
                                {this.props.children}
                            </div>
                        )
                    }
                }
            </Consumer>

        );
    }
}

export default Hot;
