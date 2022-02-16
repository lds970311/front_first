import {defineStore} from "pinia";

export const useUserStore = defineStore({
    id: 'bookList', // id必填，且需要唯一
    state: () => {
        return {
            books: [
                {
                    id: '1',
                    name: "三体",
                    author: "刘慈欣"
                }
            ]
        }
    },
    actions: {
        addBook(book: Book) {
            this.books.push(book);
        }
    }
})

