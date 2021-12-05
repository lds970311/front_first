<template>
  <div>
    <h3>
      {{ store.getters.getMsg }}
    </h3>
    <button @click="changeTitle">点我切换标题</button>
  </div>
</template>

<script lang="ts">
import {ref} from "vue";
import {useStore} from "vuex";

export default {
  name: "Home",
  setup() {
    const store = useStore();
    const name = ref("Home")

    function changeTitle() {
      store.commit("change")
    }

    return {
      name,
      changeTitle,
      store
    }
  }
}
</script>

<style scoped lang="less">
h3 {
  color: blanchedalmond;
}
</style>
