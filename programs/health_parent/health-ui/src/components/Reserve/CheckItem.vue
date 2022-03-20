<template>
  <div style="width: 100%;">
    <div class="content-header" style="width: 100%; box-sizing: border-box">
      <h1>预约管理<small>检查项管理</small></h1>
      <el-breadcrumb separator-class="el-icon-arrow-right" class="breadcrumb">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>预约管理</el-breadcrumb-item>
        <el-breadcrumb-item>检查项管理</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="app-container">
      <div class="box">
        <div class="filter-container">
          <el-input placeholder="项目编码/项目名称" v-model="pagination.queryString" style="width: 200px;"
                    class="filter-item"></el-input>
          <el-button @click="searchByPage()" class="dalfBut">查询</el-button>
          <el-button type="primary" class="butT" @click="handleCreate()">新建</el-button>
        </div>
        <el-table size="small" current-row-key="id" :data="dataList" id="tbl">
          <el-table-column type="index" align="center" label="序号"></el-table-column>
          <el-table-column prop="code" label="项目编码" align="center"></el-table-column>
          <el-table-column prop="name" label="项目名称" align="center"></el-table-column>
          <el-table-column label="适用性别" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.sex == '0' ? '不限' : scope.row.sex == '1' ? '男' : '女' }}</span>
            </template>
          </el-table-column>
          <el-table-column prop="age" label="适用年龄" align="center"></el-table-column>
          <el-table-column prop="remark" label="项目说明" align="center"></el-table-column>
          <el-table-column label="操作" align="center">
            <template slot-scope="scope">
              <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
              <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="pagination-container">
          <el-pagination
            class="pagiantion"
            @current-change="handleCurrentChange"
            :current-page="pagination.currentPage"
            :page-size="pagination.pageSize"
            layout="total, prev, pager, next, jumper"
            :total="pagination.total">
          </el-pagination>
        </div>
        <!-- 新增标签弹层 -->
        <div class="add-form">
          <el-dialog title="新增检查项" :visible.sync="dialogFormVisible">
            <el-form ref="dataAddForm" :model="formData" :rules="rules" label-position="right" label-width="100px">
              <el-row>
                <el-col :span="12">
                  <el-form-item label="项目编码" prop="code">
                    <el-input v-model="formData.code"/>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="项目名称" prop="name">
                    <el-input v-model="formData.name"/>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item label="性别">
                    <el-select v-model="formData.sex">
                      <el-option label="不限" value="0"></el-option>
                      <el-option label="男" value="1"></el-option>
                      <el-option label="女" value="2"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="适用年龄">
                    <el-input v-model="formData.age"/>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item label="类型">
                    <el-select v-model="formData.type">
                      <el-option label="检查" value="1"></el-option>
                      <el-option label="检验" value="2"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="价格">
                    <el-input v-model="formData.price"/>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="项目说明">
                    <el-input v-model="formData.remark" type="textarea"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="注意事项">
                    <el-input v-model="formData.attention" type="textarea"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false">取消</el-button>
              <el-button type="primary" @click="handleAdd()">确定</el-button>
            </div>
          </el-dialog>
        </div>

        <!-- 编辑标签弹层 -->
        <div class="add-form">
          <el-dialog title="编辑检查项" :visible.sync="dialogFormVisible4Edit">
            <el-form ref="dataEditForm" :model="formData" :rules="rules" label-position="right" label-width="100px">
              <el-row>
                <el-col :span="12">
                  <el-form-item label="项目编码" prop="code">
                    <el-input v-model="formData.code"/>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="项目名称" prop="name">
                    <el-input v-model="formData.name"/>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item label="性别">
                    <el-select v-model="formData.sex">
                      <el-option label="不限" value="0"></el-option>
                      <el-option label="男" value="1"></el-option>
                      <el-option label="女" value="2"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="适用年龄">
                    <el-input v-model="formData.age"/>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item label="类型">
                    <el-select v-model="formData.type">
                      <el-option label="检查" value="1"></el-option>
                      <el-option label="检验" value="2"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="价格">
                    <el-input v-model="formData.price"/>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="项目说明">
                    <el-input v-model="formData.remark" type="textarea"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="注意事项">
                    <el-input v-model="formData.attention" type="textarea"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible4Edit = false">取消</el-button>
              <el-button type="primary" @click="handleEdit()">确定</el-button>
            </div>
          </el-dialog>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CheckItem",
  data() {
    return {
      pagination: {//分页相关模型数据
        currentPage: 1,//当前页码
        pageSize: 10,//每页显示的记录数
        total: 0,//总记录数
        queryString: null//查询条件
      },
      dataList: [],//当前页要展示的分页列表数据
      formData: {
        code: "",
        name: "",
        sex: "",
        age: 0,
        type: 1,
        price: "",
        remark: "",
        attention: ""

      },//表单数据
      dialogFormVisible: false,//增加表单是否可见
      dialogFormVisible4Edit: false,//编辑表单是否可见
      rules: {//校验规则
        code: [{required: true, message: '项目编码为必填项', trigger: 'blur'}],
        name: [{required: true, message: '项目名称为必填项', trigger: 'blur'}]
      }
    }
  },
  //钩子函数，VUE对象初始化完成后自动执行
  created() {
    this.findPage()
  },
  methods: {
    //编辑
    handleEdit() {
    },
    //添加
    handleAdd() {
      //表单校验
      this.$refs.dataAddForm.validate(valid => {
        if (valid) {
          axios.post("/checkItem/add.do", this.formData)
            .then(res => {
              if (res.data.flag) {
                this.$message({
                  message: res.data.message,
                  type: 'success'
                });
                this.dialogFormVisible = false;
                this.findPage()
              } else {
                //添加失败
                this.$message.error(res.data.message);
                this.dialogFormVisible = false;
              }
            })
        } else {
          this.$message.error("数据校验失败,请检验数据是否正确!");
        }
      })
    },
    //分页查询
    findPage() {
      const params = {
        currentPage: this.pagination.queryString === "" ? 1 : this.pagination.currentPage,
        pageSize: this.pagination.pageSize,
        queryString: this.pagination.queryString
      }
      axios.post("/checkItem/findPage.do",
        params
      ).then(res => {
        if (res.data.flag) {
          this.pagination.total = res.data.data.total
          this.dataList = res.data.data.rows
        } else {
          this.$message.error("检查项数据获取失败!")
        }
      }).catch(err => console.log(err))
    },
    // 重置表单
    resetForm() {
      this.formData = {}
    },
    //搜索
    searchByPage() {
      this.pagination.currentPage = 1
      this.findPage()
    },
    // 弹出添加窗口
    handleCreate() {
      this.dialogFormVisible = true
      this.resetForm() //重置数据
    },
    // 弹出编辑窗口
    handleUpdate(row) {
    },
    //切换页码
    handleCurrentChange(currentPage) {
      this.pagination.currentPage = currentPage
      this.findPage()
    },
    // 删除
    handleDelete(row) {
      this.$confirm('此操作将永久删除, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        axios.delete(`/checkItem/delete.do/${row.id}}`).then(res => {
          if (res.data.flag) {
            this.$message({
              type: 'success',
              message: '删除成功!'
            });
            this.findPage()
          } else {
            this.$message({
              type: 'error',
              message: '删除失败!'
            });
          }
        })

      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    }
  }
}
</script>

<style>
.el-table__header {
  width: 500px;
}

#tbl {
  width: 100%
}
</style>
