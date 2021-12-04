<template>
  <div>
    <h3>
      {{ name }}
    </h3>
    <button @click="changeTitle">点我切换标题</button>
  </div>
</template>

<script lang="ts">
import {ref} from "vue";

export default {
  name: "Home",
  setup() {
    const name = ref("Home")

    function changeTitle() {
      name.value = "world"
    }

    return {
      name,
      changeTitle
    }
  }
}
</script>

<style scoped>

</style>
