<template>
  <div class="options">
    <el-select v-model="provinceRef" clearable placeholder="请选择省份" @change="provinceChange">
      <el-option
          v-for="item in provinces"
          :key="item.code"
          :label="item.name"
          :value="item.code"
      >
      </el-option>
    </el-select>
    <el-select v-model="cityRef" clearable placeholder="请选择城市">
      <el-option
          v-for="item in cityOptions"
          :key="item.code"
          :label="item.name"
          :value="item.code"
      >
      </el-option>
    </el-select>
    <el-select v-model="districtRef" clearable placeholder="请选择区县">
      <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
      >
      </el-option>
    </el-select>
  </div>
</template>

<script lang="ts">
import {defineComponent, reactive, ref} from "vue"
import allProvince from "../../../data/Province.json"

// import useAxios from "../../hooks/useAxios";

interface District {
  code: string,
  name: string
  children?: District[]
}

export default defineComponent({
  name: "",
  setup(props, {slots, attrs, emit}) {

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
      },
    ])
    const provinceRef = ref('')
    const cityRef = ref('')
    const districtRef = ref('')
    const provinces = reactive(allProvince)
    let cityOptions = reactive<District[]>([])

    function provinceChange(val: string) {
      console.log(val)
      cityOptions = allProvince.filter(province => {
        return province.code === val
      })[0].children
      console.log(cityOptions)
    }


    return {
      options,
      provinceRef,
      cityRef,
      districtRef,
      provinces,
      provinceChange,
      cityOptions
    }
  }
})
</script>

<style scoped lang="less">
.options {
  margin-top: 20px;
  display: flex;
  justify-content: space-around;
  align-items: center;
}
</style>
