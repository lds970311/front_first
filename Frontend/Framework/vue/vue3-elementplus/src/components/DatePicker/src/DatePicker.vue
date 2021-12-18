<template>
  <div class="date">
    <el-date-picker v-model="startDate" type="date"
                    :placeholder="startPlaceholder"
                    :disabled-date="disableStartDate">

    </el-date-picker>
    <el-date-picker v-model="endDate" type="date" :placeholder="endPlaceholder"
                    :disabled-date="endDisabledDate"
                    :disabled="endDisable"></el-date-picker>
  </div>
</template>

<script lang="ts">
import {defineComponent, ref, watch} from "vue"

export default defineComponent({
  name: "",
  emits: ["onDateChange"],
  props: {
    // 开始日期的占位符
    startPlaceholder: {
      type: String,
      default: '请选择开始日期'
    },
    // 结束日期的占位符
    endPlaceholder: {
      type: String,
      default: '请选择结束日期'
    },
    // 是否禁用选择今天之前的日期
    disableToday: {
      type: Boolean,
      default: true
    }
  },
  setup(props, {slots, attrs, emit}) {
    const startDate = ref<Date | null>(null)
    const endDate = ref<Date | null>(null)
    const endDisable = ref(true)

    function disableStartDate(time: Date) {
      if (props.disableToday) {
        return time.getTime() < Date.now() - 1000 * 60 * 60 * 24
      }
    }

    function endDisabledDate(time: Date) {
      if (startDate.value) {
        return time.getTime() < startDate.value?.getTime() + 1000 * 60 * 60 * 24
      }
    }

    watch(() => startDate.value, value => {
      if (!value) {
        endDisable.value = true
        endDate.value = null
      } else {
        endDisable.value = false
      }
    })

    watch(() => endDate.value, value => {
      if (value) {
        emit("onDateChange", {
          startDate: startDate.value,
          endDate: endDate.value
        })
      }
    })

    return {
      startDate,
      endDate,
      endDisable,
      disableStartDate,
      endDisabledDate
    }
  }
})
</script>

<style scoped lang="less">
.date {
  margin: 20px;
  text-align: center;
  display: flex;
  justify-content: space-around;
}
</style>
