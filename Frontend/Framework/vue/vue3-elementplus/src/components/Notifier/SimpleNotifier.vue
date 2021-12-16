<template>
  <div class="simple-notifier">
    <h5>简单通知组件</h5>
    <el-badge :value="value"
              :max="maxValue"
              :is-dot="isDot"
              :hidden="hidden"
              :type="type">
      <component :is="Icon"></component>
    </el-badge>
  </div>

</template>

<script lang="ts">
import {defineComponent} from "vue"

type SN = string | number

export default defineComponent({
  name: "",
  props: {
    Icon: {
      type: String,
      default: "Bell"
    },
    value: {
      //当前值
      type: [Number, String],
      default: 0
    },
    maxValue: {
      //显示最大值
      type: Number,
      default: 99
    },
    isDot: {
      //小圆点
      type: Boolean,
      default: false
    },
    hidden: {
      type: Boolean,
      default: false
    },
    type: {
      type: String,
      default: "primary"
    }
  },
  setup(props, {slots, attrs, emit}) {

    return {}
  }
})
</script>

<style scoped lang="less">
.simple-notifier {
  h5 {
    margin-bottom: 15px;
  }

  .el-badge {
    cursor: pointer;
  }
}
</style>
