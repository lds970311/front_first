<template>
  <div class="content-header">
    <h1>图书管理</h1>
  </div>
  <div class="books">
    <div class="filter-container">
      <el-input placeholder="图书名称" style="width: 200px;" class="filter-item"
                v-model="bookStore.pageInfo.title"></el-input>
      <el-input placeholder="图书作者" style="width: 200px;" class="filter-item"
                v-model="bookStore.pageInfo.author"></el-input>
      <el-input placeholder="图书价格" style="width: 200px;" v-model="bookStore.pageInfo.price"
                class="filter-item"></el-input>
      <el-button @click="bookStore.getBookData()">查询</el-button>
      <el-button type="primary" class="button" @click="addBook">新建</el-button>
      <el-dialog v-model="addDialogVisible" title="修改图书">
        <el-form :model="modifyForm">
          <el-form-item label="图书名称" :label-width="formLabelWidth">
            <el-input v-model="addForm.title" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="图书作者" :label-width="formLabelWidth">
            <el-input v-model="addForm.author" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="图书价格" :label-width="formLabelWidth">
            <el-input v-model="addForm.price" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="addDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="saveAddMsg()"
        >提交</el-button
        >
      </span>
        </template>
      </el-dialog>
    </div>
    <div class="table">
      <el-table :data="bookStore.books" style="width: 100%" max-height="250">
        <el-table-column type="index" align="center" label="序号" width="120">
          <template #default="scope">
            <span>{{ (bookStore.pageInfo.currentPage - 1) * bookStore.pageInfo.pageSize + scope.$index + 1 }}</span>
          </template>
        </el-table-column>
        <el-table-column prop="title" label="书名"/>
        <el-table-column prop="author" label="作者"/>
        <el-table-column prop="price" label="价格"/>
        <el-table-column fixed="right" label="Operations">
          <template #default="scope">
            <el-row class="mb-2">
              <el-button
                  type="danger"
                  size="small"
                  @click.prevent="deleteBook(scope.row.id)"
              >
                删除
              </el-button>
              <el-button type="success"
                         size="small"
                         @click.prevent="modify(scope.row.id)">修改
              </el-button>
            </el-row>
          </template>
        </el-table-column>
      </el-table>
      <el-dialog v-model="modifyDialogVisible" title="修改图书">
        <el-form :model="modifyForm">
          <el-form-item label="图书名称" :label-width="formLabelWidth">
            <el-input v-model="modifyForm.title" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="图书作者" :label-width="formLabelWidth">
            <el-input v-model="modifyForm.author" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="图书价格" :label-width="formLabelWidth">
            <el-input v-model="modifyForm.price" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="modifyDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="saveModifyMsg()"
        >提交</el-button
        >
      </span>
        </template>
      </el-dialog>
      <el-pagination background layout="prev, pager, next" :total="bookStore.pageInfo.total"
                     :pager-count="5"
                     v-model:current-page="bookStore.pageInfo.currentPage"
                     :page-size="bookStore.pageInfo.pageSize"
                     @current-change="handleCurrentChange">
      </el-pagination>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent, onMounted, reactive, ref} from "vue"
import {useUserStore} from "../store/bookList";
import {ElMessage, ElMessageBox} from 'element-plus'
import resetForm from "../utils/FormReset";

export default defineComponent({
  name: "Books",
  setup(props, {slots, attrs, emit}) {
    const bookStore = useUserStore()


    const modifyDialogVisible = ref(false)
    const addDialogVisible = ref(false)
    const formLabelWidth = '100px'

    const tableData = ref([])
    const modifyForm = reactive({
      id: 0,
      title: "",
      author: "",
      price: 0
    })

    const addForm = reactive({
      title: "",
      author: "",
      price: 0
    })
    onMounted(() => {
      bookStore.getBookData()
    })

    /**
     * 添加图书
     */
    function addBook() {
      addDialogVisible.value = true
    }

    async function saveAddMsg() {
      let data = await bookStore.addBookMsg(addForm)
      if (data) {
        ElMessage({
          message: '添加图书成功',
          type: 'success',
        })
      } else {
        ElMessage.error('添加图书失败');
      }
      addDialogVisible.value = false
      await bookStore.getBookData()
      resetForm(addForm)
    }

    /**
     * 修改图书
     * @param id
     */
    async function modify(id: number) {
      modifyDialogVisible.value = true
      modifyForm.id = id
      let res = await bookStore.queryOneBook(id)
      modifyForm.title = res.data.data.title
      modifyForm.author = res.data.data.author
      modifyForm.price = res.data.data.price
    }

    async function saveModifyMsg() {
      let data = await bookStore.saveModifyMsg(modifyForm)
      if (data) {
        ElMessage({
          message: '修改成功',
          type: 'success',
        })
      } else {
        ElMessage.error('修改失败');
      }
      modifyDialogVisible.value = false;
      await bookStore.getBookData()
    }

    function deleteBook(id: number) {
      console.log(id)
      ElMessageBox.confirm(
          '是否删除?',
          'Warning',
          {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
          }
      )
          .then(() => {
            try {
              let data = bookStore.deleteBook(id)
              if (data) {
                ElMessage({
                  type: 'success',
                  message: 'Delete completed',
                })
                bookStore.getBookData()
              } else {
                ElMessage({
                  type: 'error',
                  message: '删除失败',
                })
              }

            } catch (e) {
              ElMessage({
                type: 'error',
                message: 'Delete error' + e,
              })
            }
          })

    }

    function handleCurrentChange(val: number) {
      bookStore.getBookData()
    }

    return {
      bookStore,
      addBook,
      tableData,
      deleteBook,
      handleCurrentChange,
      modify,
      modifyDialogVisible,
      formLabelWidth,
      modifyForm,
      saveModifyMsg,
      addDialogVisible,
      addForm,
      saveAddMsg,
    }
  }
})
</script>

<style lang="less">
.content-header {
  margin: 0;
  font-size: 16px;
  font-weight: normal;
}

.books {
  .filter-container {
    padding: 10px 0 15px 0;

    .el-button, .filter-container .el-input__inner {
      padding: 0 15px;
      height: 34px;
      line-height: 34px;
    }

  }
}

.el-pagination {
  margin-top: 20px;
  text-align: center;
  margin-left: calc(30%);
}
</style>
