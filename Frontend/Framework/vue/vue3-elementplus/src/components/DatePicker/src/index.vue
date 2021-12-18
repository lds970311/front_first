<template>
  <DatePicker :disable-today="false" @onDateChange="handleDateChange"></DatePicker>
</template>

<script lang="ts" setup>
import DatePicker from "./DatePicker.vue";
import {Date} from "../types";

function handleDateChange(val: Date) {
  console.log(val)
}

</script>

<style scoped>

</style>
