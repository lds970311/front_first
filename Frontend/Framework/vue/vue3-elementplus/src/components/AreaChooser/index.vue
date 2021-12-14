<template>
  <AreaChooser></AreaChooser>
</template>

<script lang="ts">
import {defineComponent} from "vue"
import AreaChooser from "./AreaChooser.vue";

export default defineComponent({
  name: "",
  components: {
    AreaChooser
  },
  setup(props, {slots, attrs, emit}) {

    return {}
  }
})
</script>

<style scoped lang="less">

</style>
