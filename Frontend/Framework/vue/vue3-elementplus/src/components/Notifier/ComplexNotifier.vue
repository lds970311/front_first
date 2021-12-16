<template>
  <div class="complex-notifier">
    <h5>复杂通知组件</h5>
    <el-popover v-model:visible="visible" placement="bottom" :width="300">
      <slot></slot>
      <template #reference>
        <el-badge :value="value"
                  :max="maxValue"
                  :is-dot="isDot"
                  :hidden="hidden"
                  :type="type">
          <component :is="Icon"></component>
        </el-badge>
      </template>
    </el-popover>
  </div>
</template>

<script lang="ts">
import {defineComponent, ref} from "vue"


export default defineComponent({
  name: "complex-notifier",
  components: {},
  props: {
    Icon: {
      type: String,
      default: "Bell"
    },
    value: {
      //当前值
      type: [String, Number],
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
    const visible = ref(false)


    return {
      visible,

    }
  }
})
</script>

<style scoped lang="less">
.complex-notifier {
  h5 {
    margin-bottom: 15px;
  }

  .el-badge {
    cursor: pointer;
  }

  .el-popover {
    padding: 0 !important;

  }
}
</style>
