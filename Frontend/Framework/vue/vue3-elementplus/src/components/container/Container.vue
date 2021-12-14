<template>
  <el-container>
    <el-aside width="auto">
      <MainMenu></MainMenu>
    </el-aside>
    <el-container>
      <el-header>
        <Header></Header>
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script lang="ts">
import {defineComponent} from "vue"
import MainMenu from "./MainMenu.vue";
import Header from "./Header.vue"
import MainSection from "./MainSection.vue";

export default defineComponent({
  name: "",
  components: {
    MainMenu,
    Header,
    MainSection
  },
  setup() {

    return {}
  }
})
</script>

<style scoped lang="less">
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}

.el-header {
  height: 80px;
}

.el-main {
  border: 1px solid goldenrod;
}

.el-header, .el-main {
  padding: 0 0 0 10px;
}
</style>
