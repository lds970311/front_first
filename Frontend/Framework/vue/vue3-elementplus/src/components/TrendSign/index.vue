<template>
  <TrendSign trend="up"
             up-icon-color="blue"
             :reverse-color="true"
             up-text-color="gray">
    销售额
  </TrendSign>
  <TrendSign trend="up"
             up-icon-color="red"
  >
    营业额
  </TrendSign>
  <TrendSign trend="down"
             down-icon-color="green"
             down-icon="CaretBottom">
    利润
  </TrendSign>
</template>

<script lang="ts">
import {defineComponent} from "vue"
import TrendSign from "./TrendSign.vue";

export default defineComponent({
  name: "",
  components: {
    TrendSign
  },
  setup(props, {slots, attrs, emit}) {

    return {}
  }
})
</script>

<style scoped>

</style>
