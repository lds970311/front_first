<template>
  <div class="list-tabs-item">
    <el-tabs>
      <el-tab-pane v-for="(item, index) in dataList"
                   :key="item.title"
                   :label="item.title"
                   :stretch="true">
        <el-scrollbar max-height="300px">
          <div
              class="container"
              @click="clickItem(item1, index1)"
              v-for="(item1, index1) in item.content"
              :key="index1"
          >
            <div class="avatar" v-if="item1.avatar">
              <el-avatar size="small" :src="item1.avatar"></el-avatar>
            </div>
            <div class="content">
              <div v-if="item1.title" class="title">
                <div>{{ item1.title }}</div>
                <el-tag v-if="item1.tag" size="mini" :type="item1.tagType">{{ item1.tag }}</el-tag>
              </div>
              <div class="time" v-if="item1.desc">{{ item1.desc }}</div>
              <div class="time" v-if="item1.time">{{ item1.time }}</div>
            </div>
          </div>
          <div class="actions">
            <div
                class="a-item"
                :class="{ 'border': i !== actions.length }"
                v-for="(action, i) in actions"
                :key="i"
                @click="clickAction(action, i)"
            >
              <div class="a-icon" v-if="action.icon">
                <component :is="action.icon"></component>
              </div>
              <div class="a-text">{{ action.text }}</div>
            </div>
          </div>
        </el-scrollbar>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script lang="ts">
import {defineComponent, onMounted, PropType} from "vue"
import {ActionOptions, ListItem} from "./types";

export default defineComponent({
  name: "",
  emits: ['clickItem', "clickAction"],
  props: {
    dataList: {
      type: Array as PropType<ListItem[]>,
      // default: []
    },
    actions: {
      type: Array as PropType<ActionOptions[]>,
      // default: []
    }
  },
  setup(props, {slots, attrs, emit}) {
    onMounted(() => {
      console.log(props.actions)
      console.log(props.dataList)
    })

    function clickItem(item: ListItem, index: number) {
      emit("clickItem", item, index)
    }

    function clickAction(item: ActionOptions, index: number) {
      emit("clickAction", item, index)
    }

    return {
      clickItem,
      clickAction
    }
  }
})
</script>

<style scoped lang="less">
.el-tabs {
  width: 100%;
}

.el-tabs__nav {
  width: 100%;
}

.icon {
  width: 18px;
  height: 18px;
}

.container {
  display: flex;
  align-items: center;
  padding: 12px 20px;
  cursor: pointer;

  &:hover {
    background: #e6f6ff;
  }

  .avatar {
    flex: 1;
  }

  .content {
    flex: 3;

    .title {
      display: flex;
      align-items: center;
      justify-content: space-between;
    }

    .time {
      font-size: 12px;
      color: #999;
      margin-top: 4px;
    }
  }
}

.actions {
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  border-top: 1px solid #eee;

  .a-item {
    height: 30px;
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: center;
    cursor: pointer;

    .a-icon {
      margin-right: 4px;
      position: relative;
      top: 2px;
    }

    .a-text {
      margin-left: 5px;
    }
  }
}

.border {
  border-right: 1px solid #eee;
}
</style>
