<template>
  <div class="router">
    <h3>{{ $store.state.count }}</h3>
    <button @click="$store.dispatch('getAdd',10)">++</button>
  </div>
</template>

<script>
export default {
  name: "RouterTest"
}
</script>

<style scoped>

</style>
