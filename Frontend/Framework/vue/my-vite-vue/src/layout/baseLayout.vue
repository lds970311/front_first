<template>
  <div class="container">
    <div class="side">
      <el-col>
        <h3>导航菜单</h3>
        <el-menu
            active-text-color="#ffd04b"
            background-color="#545c64"
            class="el-menu-vertical-demo"
            default-active="2"
            text-color="#fff"
            @open="handleOpen"
            @close="handleClose"
        >
          <el-sub-menu index="1">
            <template #title>
              <el-icon>
                <location/>
              </el-icon>
              <span>Navigator One</span>
            </template>
            <el-menu-item-group title="Group One">
              <el-menu-item index="1-1">
                <router-link to="/element">
                  按钮组件
                </router-link>
              </el-menu-item>
              <el-menu-item index="1-2">表格组件</el-menu-item>
              <el-menu-item>
                <router-link to="/">
                  主页
                </router-link>
              </el-menu-item>
            </el-menu-item-group>
            <el-sub-menu index="1-4">
              <template #title>item four</template>
              <el-menu-item index="1-4-1">item one</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-menu-item index="2">
            <el-icon>
              <icon-menu/>
            </el-icon>
            <span>Navigator Two</span>
          </el-menu-item>
          <el-menu-item index="3">
            <el-icon>
              <document/>
            </el-icon>
            <span>Navigator Three</span>
          </el-menu-item>
          <el-menu-item index="4">
            <el-icon>
              <setting/>
            </el-icon>
            <span>Navigator Four</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </div>
    <div class="main">
      <router-view></router-view>
    </div>
  </div>

</template>

<script lang="ts">
import {defineComponent} from 'vue'
import {Document, Location, Menu as IconMenu, Setting,} from '@element-plus/icons'

export default defineComponent({
  name: "baseLayout",
  components: {
    Location,
    Document,
    Setting,
    IconMenu,
  },
  setup() {
    const handleOpen = (key: string, keyPath: string) => {
      console.log(key, keyPath)
    }
    const handleClose = (key: string, keyPath: string) => {
      console.log(key, keyPath)
    }
    return {
      handleOpen,
      handleClose,
    }
  },
})
</script>

<style scoped lang="less">
.container {
  display: flex;
  justify-content: center;
  align-items: center;

  a {
    text-decoration: none;
    color: #fff;
    display: inline-block;
    width: 100%;
    height: 100%;
    text-align: left;
  }

  .side {
    flex: 0 0 200px;
    position: fixed;
    left: 0;
    top: 0;
  }

  .el-col {
    width: 200px;

    h3 {
      background-color: #babad5;
      margin: 0;
      height: 50px;
      line-height: 50px;
    }
  }

  .main {
    flex: 1 1 auto;
    margin-left: 250px;
  }
}

</style>
