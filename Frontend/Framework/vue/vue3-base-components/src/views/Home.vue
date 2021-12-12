<template>
  <router-view></router-view>
</template>

<script lang="ts">
import {useRoute} from "vue-router";

export default {
  name: "Home",
  components: {
    Navigator,
  },
  setup() {
    const route = useRoute()
    return {
      route
    }
  }
}
</script>

<style scoped>

</style>
