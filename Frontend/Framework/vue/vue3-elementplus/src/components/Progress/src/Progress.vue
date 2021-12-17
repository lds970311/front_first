<template>
  <div class="progress">
    <el-progress :percentage="p"
                 :indeterminate="isAnimation"
                 :duration="time"
                 v-bind="$attrs">
      <slot></slot>
    </el-progress>
  </div>
</template>

<script lang="ts">
import {defineComponent, onMounted, ref} from "vue"

export default defineComponent({
  name: "",
  props: {
    percentage: {
      type: Number,
      default: 0
    },
    isAnimation: {
      type: Boolean,
      default: false
    },
    time: {
      type: Number,
      default: 2000
    }
  },
  setup(props, {slots, attrs, emit}) {
    const p = ref(0)
    onMounted(() => {
      const time = Math.ceil(props.time / props.percentage)
      let timer = setInterval(() => {
        p.value += 1
        if (p.value >= props.percentage) {
          p.value = props.percentage
          clearTimeout(timer)
        }
      }, time)
    })
    return {
      p
    }
  }
})
</script>

<style scoped lang="less">
.progress {
  margin: 20px;
}
</style>
