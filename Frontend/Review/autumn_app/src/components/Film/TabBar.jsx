import React, {PureComponent} from 'react';
import PropTypes from 'prop-types';

class TabBar extends PureComponent {


    render() {
        return (
            <ul>
                {
                    this.props.list.map(item => {
                        return (
                            <li key={item.id}
                                className={this.props.defaultValue === item.id ? "active" : ""}
                                onClick={() => this.props.changeActive(item.id)}>
                                {item.text}
                            </li>
                        )
                    })
                }
            </ul>

        );
    }
}

TabBar.propTypes = {
    defaultValue: PropTypes.number.isRequired,
    changeActive: PropTypes.func.isRequired,
    list: PropTypes.array.isRequired
};

export default TabBar;
