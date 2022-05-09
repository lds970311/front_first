import React from 'react';
import {Result, Button} from 'antd';
import {useNavigate} from "react-router-dom";

const NotFound = () => {
    const navigate = useNavigate()

    function goBack(): void {
        navigate('/', {
            replace: true
        })
    }

    return (
        <Result
            status="404"
            title="404"
            subTitle="您所访问的页面不存在"
            extra={<Button type="primary"
                           onClick={goBack}>Back Home</Button>}
        />
    );
};

export default NotFound;
