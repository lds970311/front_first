<template>
  <div class="sign">
    <div class="text" :style="{color:trend === 'up'? upTextColor:downTextColor}">
      <slot v-if="slot.default"></slot>
      <p v-else ref="myRef">{{ text }}</p>
    </div>
    <div class="icon">
      <component :is="upIcon"
                 v-if="trend === 'up'" :style="{color: !reverseColor? upIconColor:'red'}"></component>
      <component :is="downIcon"
                 v-else :style="{color:!reverseColor? downIconColor:'green'}"></component>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent, getCurrentInstance, useSlots} from "vue"

export default defineComponent({
  name: "trend-sign",
  props: {
    trend: {
      type: String,
      default: "up"
    },
    text: {
      type: String,
      default: ""
    },
    upIconColor: {
      type: String,
      default: 'red'
    },
    downIconColor: {
      type: String,
      default: 'green'
    },
    reverseColor: {
      type: Boolean,
      default: false
    },
    upTextColor: {
      type: String,
      default: 'red'
    },
    downTextColor: {
      type: String,
      default: 'green'
    },
    //上升/下降趋势显示IDE图标
    upIcon: {
      type: String,
      default: "ArrowUp"
    },
    downIcon: {
      type: String,
      default: "ArrowDown"
    }
  },
  setup(props, {slots, attrs, emit}) {
    const slot = useSlots()
    // console.log()
    const {refs} = getCurrentInstance()!
    return {
      slot
    }
  }
})
</script>

<style scoped lang="less">
.sign {
  margin: 10px 10px;
  display: flex;
  align-items: center;

  .text {
    font-size: 12px;
    margin-right: 4px;
  }

  .icon {
    width: 18px;
    height: 18px;
  }
}
</style>
