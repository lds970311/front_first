import React, {useEffect} from 'react';
import {useDispatch, useSelector} from "react-redux";
import {setProduct} from "../store/actions/productAction";
import axios from "axios";

const Product = () => {
    const dispatch = useDispatch()
    //@ts-ignore
    const {products} = useSelector((state) => state.ProductReducer)
    console.log(products)
    const fetchProduct = async () => {
        try {
            const result = await axios.get("https://mock.mengxuegu.com/mock/61b792d5ca09cb42105adf8b/citydata/products")
            console.log(result.data)
            dispatch(setProduct(result.data.data))
        } catch (e) {
            console.log(e);
        }
    }

    function renderProduct() {
        if (products.length !== 0) {
            console.log(products)
            return (
                products.map(item => {
                    return (
                        <li key={item.id}>
                            <h1>{item.title}</h1>
                            <p>{item.category}</p>
                        </li>
                    )
                })
            )
        } else {
            return null
        }
    }

    useEffect(() => {
        fetchProduct()
    }, [])

    return (
        <div>
            <ul>
                {
                    renderProduct()
                }
            </ul>
        </div>
    );
};

export default Product;
