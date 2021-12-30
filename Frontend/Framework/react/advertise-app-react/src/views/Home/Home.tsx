import React from 'react';
import Header from "../../components/Header"
import Product from "../../components/Product";
import ProductDetail from "../../components/ProductDetail";
import ProductList from "../../components/ProductList";
import {BrowserRouter, Route, Routes} from "react-router-dom";

const Home: React.FunctionComponent = () => {
    return (
        <div>
            <BrowserRouter>
                <Header/>
                <Routes>
                    <Route path="/product" element={<Product/>}/>
                    <Route path="/product/:id" element={<ProductDetail/>}/>
                    <Route path="/productlist" element={<ProductList/>}/>
                </Routes>
            </BrowserRouter>

        </div>
    );
};

export default Home;
