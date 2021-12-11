<template>
  <p>
    123
  </p>
</template>

<script lang="ts">
import {defineComponent, PropType} from "vue"

type handleClick = (name: string) => string

export default defineComponent({
  name: "",
  props: {
    name: {
      type: String as PropType<string>,
      required: false,
    },
    handleClick: {
      type: Function as PropType<handleClick>
    }
  },
  setup() {

    return {}
  }
})
</script>

<style scoped>

</style>
