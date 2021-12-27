<template>
  <div>
    <h3>
      {{ store.getters.getMsg }}
    </h3>
    <button @click="changeTitle">点我切换标题123</button>
  </div>
  <JsxComponent></JsxComponent>
</template>

<script lang="ts">
import {AppContext, getCurrentInstance, Prop, ref} from "vue";
import {useStore} from "vuex";
import JsxComponent from "../components/JsxComponent.vue"
import service from "../utils/request";

export default {
  name: "Home",
  components: {
    JsxComponent
  },
  setup(props: Prop<any>, ctx: AppContext) {
    const store = useStore();
    const name = ref("Home")
    const instance = getCurrentInstance()
    service.get('/name').then(res => console.log(res))

    function changeTitle() {
      store.commit("change")
    }

    return {
      name,
      changeTitle,
      store
    }
  },
}
</script>

<style scoped lang="less">
h3 {
  color: blanchedalmond;
}
</style>
