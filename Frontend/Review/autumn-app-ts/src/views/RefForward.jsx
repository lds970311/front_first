import React, {Component, forwardRef} from 'react';

const Child = forwardRef((props, ref) => {
    return (
        <div>
            <input type="text" ref={ref}/>
        </div>
    )
})

class RefForward extends Component {
    constructor(props) {
        super(props);
        this.myRef = React.createRef()
    }


    componentDidMount() {
        this.myRef.current.focus()
    }

    render() {
        return (
            <div>
                <Child ref={this.myRef}/>
            </div>
        );
    }
}

export default RefForward;



