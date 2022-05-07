import React, {useEffect} from 'react';
import {useNavigate} from 'react-router-dom'

interface Props {
    to: string
}

const Redirect: React.FunctionComponent<Props> = (props) => {
    const {to} = props
    const navigate = useNavigate()
    useEffect(() => {
        navigate(to, {replace: true})
    })
    return null
};

export default Redirect;
