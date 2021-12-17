<template>
  <div class="icons" @click="handleClick">
    <el-button :type="buttonType ? buttonType: 'primary'">
      <slot>
        选择一个图标
      </slot>
    </el-button>
    <el-dialog
        v-model="isOpen"
        :title="title"
        width="50%"
    >
      <div class="icon-list">
        <el-scrollbar>
          <ul>
            <li v-for="(item, index) in Object.keys(Icons)"
                :key="index"
                @click="copyElement(item)">
              <div>
                <component :is="item"></component>
              </div>
              <p>{{ item }}</p>
            </li>
          </ul>
        </el-scrollbar>
      </div>
    </el-dialog>
  </div>
</template>

<script lang="ts">
import {defineComponent, ref, watch} from "vue"
import * as Icons from "@element-plus/icons-vue"
import useCopy from "../../../hooks/useCopy";
import {ElMessage} from 'element-plus'

export default defineComponent({
  name: "",
  props: {
    buttonType: String,
    title: String, //弹出框标题
    visible: Boolean, //控制弹出框的显示
  },
  emits: ['update:visible'],

  setup(props, {slots, attrs, emit}) {
    const isOpen = ref(props.visible)

    function handleClick() {
      emit('update:visible', !props.visible)
    }

    function copyElement(item: string): void {
      useCopy(item)
      ElMessage({
        message: '代码复制成功!',
        type: 'success',
      })
    }

    watch(() => props.visible, val => {
      isOpen.value = val
    })

    watch(() => isOpen.value, val => {
      emit('update:visible', val)
    })

    return {
      handleClick,
      isOpen,
      Icons,
      copyElement,
    }
  }
})
</script>

<style scoped lang="less">
.icons {
  margin: 30px;
}

.icon-list {
  height: 300px;
  overflow: auto;

  ul {
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;

    li {
      flex: 0 0 80px;
      list-style: none;
      font-size: 12px;
      cursor: pointer;
      height: 60px;

      div, p {
        text-align: center;
      }
    }
  }
}
</style>
