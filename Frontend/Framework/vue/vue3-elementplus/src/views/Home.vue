<template>
  <div class="icon">
    <IconChooser
        title="选择图标"
        v-model:visible="visible"
        button-type="warning"></IconChooser>
  </div>
</template>

<script lang="ts">
import {defineComponent, ref} from "vue"
import IconChooser from "../components/IconChooser/IconChooser.vue";

export default defineComponent({
  name: "",
  components: {
    Navigator,
    IconChooser
  },
  setup() {
    let visible = ref<boolean>(false)

    return {
      visible
    }
  }
})
</script>

<style scoped>

</style>
