<template>
  <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      :collapse="isCollapse"
  >
    <el-menu-item v-for="(item, index) in routes"
                  :key="item.path"
                  :index="index.toString()"
                  :route="item.path"
                  @click="changePath(item.path)">
      <el-icon>
        <component :is="item.meta.icon"></component>
      </el-icon>
      <span>{{ item.meta.title }}</span>
    </el-menu-item>
  </el-menu>
</template>

<script lang="ts">
import {computed, defineComponent} from "vue"
import {createNamespacedHelpers, useStore} from "vuex";
import {routes} from "../../router"
import {useRoute, useRouter} from "vue-router";

export default defineComponent({
  name: "",
  setup() {
    const store = useStore()
    const router = useRouter()
    const {mapState} = createNamespacedHelpers("containerOptions")
    const states = {}
    const route = useRoute()
    const funcs = mapState(['isCollapse'])
    Object.keys(funcs).forEach(key => {
      //@ts-ignore
      const fn = funcs[key].bind({$store: store})
      //@ts-ignore
      states[key] = computed(fn)
    })

    function changePath(path: string) {
      router.push({
        path
      })
    }

    return {
      store,
      ...states,
      routes,
      changePath,
    }
  }
})
</script>

<style scoped lang="less">
a {
  text-decoration: none;
  color: black;
}
</style>
