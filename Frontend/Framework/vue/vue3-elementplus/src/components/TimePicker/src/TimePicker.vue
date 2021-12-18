<template>
  <div class="time">
    <el-time-select
        v-model="startTime"
        :placeholder="startPlaceholder"
        :start="startTimeStart"
        :step="startStep"
        :end="startTimeEnd"
        v-bind="$attrs.startOptions"
    >
    </el-time-select>
    <el-time-select
        v-model="endTime"
        :min-time="startTime"
        :placeholder="endPlaceholder"
        :start="endTimeStart"
        :step="endStep"
        :end="endTimeEnd"
        :disabled="isDisable"
        v-bind="$attrs.endOptions"
    >
    </el-time-select>

  </div>
</template>

<script lang="ts">
import {defineComponent, ref, useAttrs, watch} from "vue"

export default defineComponent({
  name: "",
  emits: ["onSelect"],
  props: {
    startPlaceholder: {
      type: String,
      default: '请选择开始时间'
    },
    // 结束时间的占位符
    endPlaceholder: {
      type: String,
      default: '请选择结束时间'
    },
    // 开始时间的开始选择
    startTimeStart: {
      type: String,
      default: "08:00"
    },
    // 开始时间的步进
    startStep: {
      type: String,
      default: "00:30"
    },
    // 开始时间的结束选择
    startTimeEnd: {
      type: String,
      default: "24:00"
    },
    // 结束时间的开始选择
    endTimeStart: {
      type: String,
      default: "08:00"
    },
    // 结束时间的步进
    endStep: {
      type: String,
      default: "00:30"
    },
    // 结束时间的结束选择
    endTimeEnd: {
      type: String,
      default: "24:00"
    },
  },
  setup(props, {slots, attrs, emit}) {
    const startTime = ref("")
    const endTime = ref("")
    const isDisable = ref(true)
    const $attrs = useAttrs()
    watch(() => startTime.value, val => {
      if (val === "") {
        isDisable.value = true
        endTime.value = ""
      } else {
        isDisable.value = false
      }
    })
    watch(() => endTime.value, value => {
      if (value !== "") {
        emit("onSelect", {
          start: startTime.value,
          end: endTime.value
        })
      }
    })
    return {
      startTime,
      endTime,
      isDisable,
      $attrs
    }
  }
})
</script>

<style scoped>
.time {
  margin: 20px;
  text-align: center;
}
</style>
