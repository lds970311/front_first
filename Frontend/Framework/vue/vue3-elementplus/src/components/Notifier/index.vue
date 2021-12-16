<template>
  <SimpleNotifier :value="87"
                  :max-value="40"
                  :is-dot="false"
                  type="warning">

  </SimpleNotifier>
  <!--  复杂通知菜单-->
  <ComplexNotifier :value="45"
                   :max-value="99"
                   type="danger">
    <template #default>
      <NotifyList :actions="actionList"
                  :data-list="dataList">

      </NotifyList>
    </template>
  </ComplexNotifier>
</template>

<script lang="ts">
import {defineComponent, getCurrentInstance, onMounted, ref} from "vue"
import SimpleNotifier from "./SimpleNotifier.vue"
import ComplexNotifier from "./ComplexNotifier.vue";
import NotifyList from "./NotifyList.vue";

export default defineComponent({
  name: "",
  components: {
    SimpleNotifier,
    ComplexNotifier,
    NotifyList
  },
  setup(props, {slots, attrs, emit}) {
    const dataList = ref([])
    const actionList = ref([])
    //@ts-ignore
    const {proxy} = getCurrentInstance()
    onMounted(() => {
      proxy.$axios.get('/notifylist').then(res => {
        let {actions, list} = res.data.data
        dataList.value = list
        actionList.value = actions
      })
    })
    return {
      actionList,
      dataList
    }
  }
})
</script>

<style scoped>

</style>
