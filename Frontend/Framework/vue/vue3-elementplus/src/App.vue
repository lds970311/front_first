<template>
  <Navigator :nav-list="navList"></Navigator>
  <router-view></router-view>
</template>

<script setup lang="ts">

import Navigator from "./components/Navigator.vue";

const navList = [
  {
    name: '首页',
    path: '/'
  }, {
    name: '伸缩菜单',
    path: '/container'
  }]
</script>


<style scoped>

</style>
