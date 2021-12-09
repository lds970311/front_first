<template>
  <div class="navigator">
    <ul>
      <li v-for="(item,index) in navList" :key="index">{{ item }}</li>
    </ul>
  </div>
</template>

<script>
import {reactive} from "vue";

export default {
  name: "Navigator",
  setup() {
    const navList = reactive(['表单', '表格', '面包屑', '日历', '按钮', '提示框'])
    return {
      navList
    }
  }
}
</script>

<style scoped lang="less">
.navigator {
  max-width: 1196px;
  margin: 0 auto;
  background-color: bisque;
  height: 50px;


  ul {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin: 0;
    padding: 0;

    li {
      font-weight: bold;
      list-style: none;
      width: 100%;
      cursor: pointer;
    }
  }
}
</style>
