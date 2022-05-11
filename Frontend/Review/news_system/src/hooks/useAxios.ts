import {useCallback, useEffect, useState} from "react";
import axios from "axios";

const useAxios = (url: string, type: string, headers?: any, body?: object) => {
    const [loading, setLoading] = useState<boolean>(true)
    const [data, setData] = useState<any>({})
    const request = useCallback(() => {
        console.log("exec")
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

    useEffect(() => {
        request()
    }, [request])
    return {
        loading, data
    }
}

export default useAxios
