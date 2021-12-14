<template>
  <div class="navigator">
    <ul>
      <li v-for="(item,index) in navList" :key="index"
          @click="changePath(item.path)">{{ item.name }}
      </li>
    </ul>
  </div>
</template>

<script lang="ts">
import {defineComponent, PropType} from "vue"
import {useRouter} from "vue-router";

interface Routes {
  name: string
  path: string;
}

export default defineComponent({
  name: "",
  props: {
    navList: {
      type: Array as PropType<Routes[]>
    }
  },
  setup() {
    const router = useRouter()
    const changePath = (path: string) => {
      router.push({
        path
      })
    }
    return {
      changePath,
    }
  }
})
</script>

<style scoped lang="less">
.navigator {
  max-width: 100%;
  background-color: bisque;
  height: 50px;;
  text-align: center;

  ul {
    margin: 0 auto;
    max-width: 1196px;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0;

    li {
      font-weight: bold;
      font-size: 14px;
      list-style: none;
      width: 100%;
      cursor: pointer;
    }
  }
}
</style>
