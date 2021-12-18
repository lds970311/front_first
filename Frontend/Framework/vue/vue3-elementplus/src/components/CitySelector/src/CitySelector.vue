<template>
  <div class="city">
    <el-popover
        placement="bottom-start"
        :width="450"
        trigger="click"
        :visible="popperVisible"
    >
      <template #reference>
        <div class="info">
          <span @click="popperVisible = !popperVisible">{{ result }}</span>
          <el-icon>
            <ArrowUp :class="popperVisible ? 'rotate':''"></ArrowUp>
          </el-icon>
        </div>
      </template>
      <div class="container">
        <el-row>
          <el-col :span="8">
            <el-radio-group v-model="radio" size="small" :style="{textAlign:'center'}">
              <el-radio-button label="按城市"></el-radio-button>
              <el-radio-button label="按省份"></el-radio-button>
            </el-radio-group>
          </el-col>
          <el-col :span="16">
            <div class="my-radio">
              <el-select size="small" v-model="cityValue" clearable placeholder="Select">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                >
                </el-option>
              </el-select>
              <Close @click="popperVisible = false"></Close>
            </div>
          </el-col>
        </el-row>
        <div id="city-info">
          <ul>
            <li v-for="(item, index) in Object.keys(cityData)"
                :key="index">{{ item }}
            </li>
          </ul>
        </div>
      </div>
    </el-popover>
  </div>
</template>

<script lang="ts">
import {defineComponent, getCurrentInstance, onMounted, ref} from "vue"

export default defineComponent({
  name: "",
  setup(props, {slots, attrs, emit}) {
    const result = ref("请选择城市")
    const radio = ref("")
    const cityValue = ref("")
    const popperVisible = ref(false)
    const cityData = ref({}) //城市数据
    //@ts-ignore
    const {proxy} = getCurrentInstance()
    onMounted(() => {
      proxy.$axios.get("/cities").then(res => {
        cityData.value = res.data.cities
        console.log(cityData.value)
      })
    })
    const options = ref([
          {
            value: 'Option1',
            label: 'Option1',
          },
          {
            value: 'Option2',
            label: 'Option2',
          },
          {
            value: 'Option3',
            label: 'Option3',
          },
          {
            value: 'Option4',
            label: 'Option4',
          },
          {
            value: 'Option5',
            label: 'Option5',
          }
        ]
    )
    return {
      result,
      radio,
      cityValue,
      options,
      popperVisible,
      cityData
    }
  }
})
</script>

<style scoped lang="less">
#city-info {
  ul {
    list-style: none;
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;


    li {
      padding: 3px 6px;
      margin-right: 4px;
      flex: 0 1 20px;
      width: 20px;
      height: 20px;
      border: 1px solid #a2efef;
      margin-top: 10px;
      text-align: center;
      border-radius: 50%;
    }
  }
}

.city {
  margin: 20px;
  list-style: none;

  svg {
    position: relative;
    top: 2px;
    margin-left: 3px;
    transition: all .25s;
  }

  .rotate {
    transform: rotate(180deg);
  }

  .info {
    cursor: pointer;
  }

  .container {

    .el-radio-group {
      width: 100%;
      text-align: center;
    }
  }

  span {
    font-size: 16px;
  }

}

.my-radio {
  display: flex;
  justify-content: right;
  margin-right: 10px;

  svg {
    position: fixed;
    top: 5px;
    right: 5px;
    width: 12px;
    height: 12px;
  }

  svg:hover {
    border: 1px solid #6a6e6a;
    border-radius: 50%;

  }
}
</style>
