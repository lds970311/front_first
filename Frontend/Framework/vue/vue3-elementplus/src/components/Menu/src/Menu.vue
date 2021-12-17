<template>
  <div class="menu">
    <el-menu
        :default-active="defaultActive"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        :router="router"
        v-bind="$attrs"
    >
      <template v-for="(item, index) in menus" :key="item.name">
        <el-menu-item :index="item.index" v-if="!item.children || item.children.length===0">
          <el-icon>
            <component :is="item.icon" v-if="item.icon"></component>
          </el-icon>
          <span>{{ item.name }}</span>
        </el-menu-item>
        <el-sub-menu v-if="item.children && item.children.length !== 0" :index="item.index">
          <template #title>
            <el-icon>
              <component :is="item.icon" v-if="item.icon"></component>
            </el-icon>
            <span>{{ item.name }}</span>
          </template>
          <el-menu-item v-for="(subItem, subIndex) in item.children" :key="subItem.name" :index="subItem.index">
            <el-icon>
              <component :is="subItem.icon" v-if="subItem.icon"></component>
            </el-icon>
            <span>{{ subItem.name }}</span>
          </el-menu-item>
        </el-sub-menu>
      </template>

    </el-menu>
  </div>
</template>

<script lang="ts">
import {defineComponent, PropType} from "vue"
import {MenuItem} from "../types";

export default defineComponent({
  name: "",
  props: {
    menus: {
      type: Array as PropType<MenuItem[]>,
      default: [],
      required: true
    },
    defaultActive: {
      type: String,
      default: '1'
    },
    router: {
      type: Boolean,
      default: false
    }
  },
  setup(props, {slots, attrs, emit}) {
    console.log(props)

    function handleOpen() {

    }

    function handleClose() {

    }

    return {
      handleOpen,
      handleClose
    }
  }
})
</script>

<style scoped lang="less">
.menu {
  width: 300px;
  margin: 10px 0;
}
</style>
