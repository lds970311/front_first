declare interface Book {
    id: string,
    title: string,
    author: string
    price: number,
    sales: number,
    stock: number,
    imgPath: string
}

declare interface FormObj {
    [key: string]: string | number
}
