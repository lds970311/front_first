<template>
  <div class="icon">
    <IconChooser
        title="选择图标"
        v-model:visible="visible"
        button-type="warning">

    </IconChooser>
  </div>
</template>

<script lang="ts">
import {defineComponent, ref} from "vue"
import IconChooser from "./IconChooser.vue";

export default defineComponent({
  name: "",
  components: {
    IconChooser
  },
  setup(props, {slots, attrs, emit}) {
    let visible = ref<boolean>(false)

    return {
      visible
    }
  }
})
</script>

<style scoped>

</style>
