<template>
  <div class="navigator">
    <ul>
      <li v-for="(item,index) in navList" :key="index"
          @click="changePath(item)">{{ item }}
      </li>
    </ul>
  </div>
</template>

<script lang="ts">
import {reactive} from "vue";
import {useRouter} from "vue-router";

export default {
  name: "Navigator",
  setup() {
    const navList = reactive(['表单', '表格', '面包屑', '日历', '按钮', '提示框'])
    const router = useRouter()
    const changePath = (name: string) => {
      if (name === "按钮") {
        router.push({
          path: '/button'
        })
      } else {
        router.push({
          path: '/'
        })
      }
    }
    return {
      navList,
      changePath
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
