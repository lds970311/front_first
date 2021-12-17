<template>
  <div class="menus">
    <!--    无限层级菜单-->
    <InfiniteMenu :menus="data2"
                  :router="false">
    </InfiniteMenu>
    <!--二级菜单-->
    <Menu :menus="data1"
          default-active="1">

    </Menu>
  </div>
</template>

<script lang="ts" setup>
import {ref} from "vue";
import Menu from "./Menu.vue";
import InfiniteMenu from "./InfiniteMenu.vue";

const data1 = ref([
  {
    name: '导航1',
    index: '1',
    icon: 'Notebook'
  },
  {
    name: '导航2',
    index: '2',
    icon: 'Notebook'
  },
  {
    name: '导航3',
    index: '3',
    icon: 'Notebook',
    children: [
      {
        name: '导航3-1',
        index: '3-1',
        icon: 'Notebook',
      }
    ]
  }
])

const data2 = ref([
  {
    name: '导航1',
    index: '1',
    icon: 'Document'
  },
  {
    name: '导航2',
    index: '2',
    icon: 'Document'
  },
  {
    name: '导航3',
    index: '3',
    icon: 'Document',
    children: [
      {
        name: '导航3-1',
        index: '3-1',
        icon: 'Document',
        children: [
          {
            name: '导航3-1-1',
            index: '3-1-1',
            icon: 'Document',
            children: [
              {
                name: '导航3-1-1-1',
                index: '3-1-1-1',
                icon: 'Document',
                children: [
                  {
                    name: '导航3-1-1-1-1',
                    index: '3-1-1-1-1',
                    icon: 'Document',
                  }
                ]
              }
            ]
          }
        ]
      }
    ]
  }])
</script>

<style scoped lang="less">
.menus {
  display: flex;
  justify-content: space-between;
  padding: 20px;
  height: 80%;
}
</style>
