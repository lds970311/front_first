<template>
  <TimePicker start-time="8:45" step="10" end-time="23:00" v-on:onSelect="handleTimeSelect"></TimePicker>
</template>

<script lang="ts" setup>
import TimePicker from "./TimePicker.vue";
import {Time} from "../types";

function handleTimeSelect(val: Time) {
  console.log(val)
}

</script>

<style scoped>

</style>
