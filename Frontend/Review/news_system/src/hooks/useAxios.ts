import {useEffect, useState} from "react";
import axios from "axios";

const useAxios = (url: string, type: string, headers?: any, body?: object) => {
    const [loading, setLoading] = useState<boolean>(true)
    const [data, setData] = useState<any>({})
    useEffect(() => {
        axios({
            url,
            method: type,
            headers,
            timeout: 1000
        }).then(res => {
            setLoading(false)
            setData(res.data)
        }).catch(err => {
            setLoading(false)
            setData(err)
        })

    }, [headers, type, url])
    return {
        loading, data
    }
}

export default useAxios
