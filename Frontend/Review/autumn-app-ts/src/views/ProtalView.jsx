import React, {Component, useState} from 'react';
import ReactDOM from 'react-dom';
import RefForward from "./RefForward";

const getDiv = () => {
    const div = document.createElement('div');
    document.body.appendChild(div);
    return div;
};

const withPortal = (WrappedComponent) => {
    class AddPortal extends Component {


        constructor(props) {
            super(props);
            this.el = getDiv();
        }

        componentWillUnmount() {
            document.body.removeChild(this.el);
        }

        // @ts-ignore
        render(props) {
            return ReactDOM.createPortal(<WrappedComponent {...props} />, this.el);
        }
    }

    return AddPortal;
}

class Modal extends Component {
    render() {
        return (
            <div>
                <div>amodal content</div>
                <button type="button">Click</button>
                <RefForward/>
            </div>
        );
    }
}

const PortalModal = withPortal(Modal);

const ProtalView = () => {
    const [clicks, setClicks] = useState(0)

    // @ts-ignore

    return (
        <div onClick={() => setClicks(clicks + 1)}>
            <h3>ppppppppp</h3>
            <h3>num: {clicks}</h3>
            <PortalModal/>
        </div>
    );
};

export default ProtalView;
