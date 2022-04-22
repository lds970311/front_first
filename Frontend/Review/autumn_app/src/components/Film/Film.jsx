import React, {PureComponent} from 'react';
import PropTypes from 'prop-types';

class Film extends PureComponent {
    static propTypes = {
        name: PropTypes.string.isRequired,
    }

    constructor(props) {
        super(props);
        this.state = {
            value: ""
        }
    }

    render() {
        const {name} = this.props
        return (
            <div>
                <label htmlFor="film">
                    请输入电影名称: <input type="text"
                                    id="film"
                                    value={this.state.value}
                                    onChange={(e) => this.handleChange(e)}/>
                </label>
                {name}
            </div>
        );
    }

    handleChange(e) {
        this.setState({
            value: e.target.value
        })
    }
}


export default Film;
