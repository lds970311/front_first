<template>
  <div class="books">
    <el-card class="box-card">
      <template #header>
        <div class="card-header">
          <h3>this is books</h3>
          <el-button class="button" type="primary" @click="addBook">添加</el-button>
        </div>
      </template>
      <div v-for="book in bookStore.books" :key="book.id" class="text-item">
        <span>{{ book.name }}</span>
        <span>{{ ":" }}</span>
        <span>{{ book.author }}</span>
      </div>
    </el-card>
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue"
import {useUserStore} from "../store/bookList";
import {nanoid} from 'nanoid'

export default defineComponent({
  name: "Books",
  setup(props, {slots, attrs, emit}) {
    const bookStore = useUserStore()

    /**
     * 添加图书
     */
    function addBook() {
      const id = nanoid();
      const newBook: Book = {
        id,
        name: "解忧杂货店",
        author: "东野圭吾"
      }
      bookStore.addBook(newBook)
    }

    return {
      bookStore,
      addBook,
    }
  }
})
</script>

<style scoped lang="less">
.box-card {
  width: 500px;
  margin: 0 auto;

  .card-header {
    display: flex;
    justify-content: space-between;
  }

  .text-item {
    text-align: left;
  }
}
</style>
