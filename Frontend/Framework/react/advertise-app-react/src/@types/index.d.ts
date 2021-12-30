export interface Action {
    type: string;
    payload?: any;
}

export interface Product {
    id: number,
    title: string,
    category: string,
}
