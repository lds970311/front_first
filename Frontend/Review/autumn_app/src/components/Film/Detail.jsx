import React, {useEffect} from 'react';
import store from "../../store";
import getDetailAction from "../../store/actions/getDetailAction";
import {useRouteMatch} from "react-router-dom";
import {connect} from 'react-redux'

const Detail = (props) => {
    const match = useRouteMatch()
    console.log(props)
    useEffect(() => {
        //取数据,异步
        props.getDetailAction(match.params.id)
    }, [match.params.id, props])

    return (
        <div>
            detail
            <p>{}</p>
        </div>
    );
};

const mapStateToProps = state => {
    return {
        name: "name",
        title: "t",
        ...state
    }
}

const mapDispatchToProps = {
    getDetailAction
}

export default connect(mapStateToProps, mapDispatchToProps)(Detail);
