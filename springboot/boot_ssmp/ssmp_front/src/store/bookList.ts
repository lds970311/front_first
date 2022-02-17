import {defineStore} from "pinia";
import service from "../utils/request";


export const useUserStore = defineStore({
    id: 'bookList', // id必填，且需要唯一
    state: () => {
        return {
            books: [],
            pageInfo: {
                total: 0,
                pageSize: 5,
                pageCount: 0,
                currentPage: 1,
                title: "",
                author: "",
                price: ""
            }
        }
    },
    actions: {
        async getBookData() {
            try {
                let res = await service.get("/books/byPage", {
                    params: {
                        pageSize: this.pageInfo.pageSize,
                        pageNum: this.pageInfo.currentPage,
                        title: this.pageInfo.title,
                        author: this.pageInfo.author,
                        price: this.pageInfo.price
                    }
                })
                this.books = res.data.data.records
                this.pageInfo.total = res.data.data.total
                this.pageInfo.pageCount = res.data.data.pages
            } catch (e) {
                console.log(e)
            }
        },
        async deleteBook(id: number) {
            try {
                let res = await service.delete(`/books/${id}`)
                return res.data.data
            } catch (e) {
                console.log(e);
            }
        },
        async queryOneBook(id: number) {
            try {
                return await service.get(`/books/${id}`);
            } catch (e) {
                console.log(e)
            }
        },
        async saveModifyMsg(msg: any) {
            const config = {
                ...msg,
                sales: 150,
                stock: 150,
                imgPath: "static/uploads/biancheng.jpg"
            }
            console.log(config)
            try {
                let res = await service.put("/books", config)
                return res.data.data
            } catch (e) {
                console.log(e)
            }
        },
        async addBookMsg(msg: any) {
            const config = {
                ...msg,
                sales: (100 * Math.random()) + 50,
                stock: (100 * Math.random()) + 70,
                imgPath: "static/uploads/biancheng.jpg"
            }
            try {
                return await service.post("/books", config)
            } catch (e) {
                console.log(e)
            }
        }
    }
})

