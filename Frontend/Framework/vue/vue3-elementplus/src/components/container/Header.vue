<template>
  <div class="header">
    <el-icon>
      <expand
          @click="changeMenuState"
          v-if="isCollapse"
      ></expand>
      <fold
          @click="changeMenuState"
          v-if="!isCollapse"
      >
      </fold>
    </el-icon>
  </div>
</template>

<script lang="ts">
import {computed, defineComponent} from "vue";
import {createNamespacedHelpers, useStore} from "vuex";

export default defineComponent({
  name: "Header",
  setup() {
    const store = useStore()
    const {mapState} = createNamespacedHelpers("containerOptions")
    const states = {}
    const funcs = mapState(['isCollapse'])
    Object.keys(funcs).forEach(key => {
      const fn = funcs[key].bind({$store: store})
      states[key] = computed(fn)
    })

    function changeMenuState() {
      store.commit("containerOptions/changeCollapse")
    }

    return {
      changeMenuState,
      ...states
    }
  }
})
</script>

<style scoped lang="less">
.header {
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
</style>
