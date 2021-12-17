<template>
  <Progress :percentage="20"></Progress>
  <Progress :percentage="80" status="warning" :text-inside="true" :stroke-width="20">
    <span>Content</span>
  </Progress>
  <Progress :percentage="70" status="exception" type="circle" :time="1000">
    <el-button type="success" icon="Check" circle></el-button>
  </Progress>
  <Progress :percentage="70" type="dashboard">
    <template #default="{ percentage }">
      <span class="percentage-value">{{ percentage }}%</span>
      <span class="percentage-label">Progressing</span>
    </template>
  </Progress>
</template>

<script lang="ts">
import {defineComponent} from "vue"
import Progress from "./Progress.vue";

export default defineComponent({
  name: "progress",
  components: {
    Progress
  },
  setup(props, {slots, attrs, emit}) {

    return {}
  }
})
</script>

<style scoped>

</style>
