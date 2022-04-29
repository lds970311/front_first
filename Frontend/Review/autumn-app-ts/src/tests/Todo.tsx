import React, {Component} from 'react';

interface State {
    text: string;
    list: Array<string>
}

class Todo extends Component<any, State> {
    constructor(props) {
        super(props);
        this.state = {
            text: "",
            list: ["111", "222", "333"],
        };
    }


    render() {
        return (
            <div>
                <h1>todoList</h1>
                <input
                    onChange={(evt) => {
                        this.setState({
                            text: evt.target.value,
                        });
                    }}
                />
                <button
                    className="add"
                    onClick={() => {
                        this.setState({
                            list: [...this.state.list, this.state.text],
                        });
                    }}
                >
                    add
                </button>
                <ul>
                    {this.state.list.map((item, index) => (
                        <li key={item}>
                            {item}
                            <button
                                className="del"
                                onClick={() => {
                                    const newList = [...this.state.list];
                                    newList.splice(index, 1);
                                    this.setState({
                                        list: newList,
                                    });
                                }}
                            >
                                del
                            </button>
                        </li>
                    ))}
                </ul>
            </div>
        );
    }
}

export default Todo;
