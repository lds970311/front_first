<template>
  <AreaChooser @change="handleSelectorChange"></AreaChooser>
</template>

<script lang="ts">
import {defineComponent} from "vue"


export default defineComponent({
  name: "",
  setup(props, {slots, attrs, emit}) {
    function handleSelectorChange(data: any) {
      console.log(data)
    }

    return {
      handleSelectorChange
    }
  }
})
</script>

<style scoped lang="less">

</style>
