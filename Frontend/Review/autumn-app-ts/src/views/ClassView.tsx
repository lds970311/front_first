import React, {Component} from 'react';

interface IState {
    title: string,
    num: number
}

class ClassView extends Component<any, IState> {
   

    state = {
        title: 't',
        num: 1
    }

    render() {
        return (
            <div>
                <button onClick={() => {
                    this.setState({
                        title: '123'
                    })
                }}>click me
                </button>
                <p>{this.state.title}</p>
            </div>
        );
    }
}

export default ClassView;


