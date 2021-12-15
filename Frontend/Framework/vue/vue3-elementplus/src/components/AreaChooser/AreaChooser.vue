<template>
  <div class="options">
    <el-select v-model="provinceRef" clearable placeholder="请选择省份">
      <el-option
          v-for="item in provinces"
          :key="item.code"
          :label="item.name"
          :value="item.code"
      >
      </el-option>
    </el-select>
    <el-select v-model="cityRef" clearable
               placeholder="请选择城市"
               :disabled="!provinceRef">
      <el-option
          v-for="item in cityOptions"
          :key="item.code"
          :label="item.name"
          :value="item.code"
      >
      </el-option>
    </el-select>
    <el-select v-model="districtRef" clearable placeholder="请选择区县"
               :disabled="!provinceRef || !cityRef">
      <el-option
          v-for="item in districtOptions"
          :key="item.code"
          :label="item.name"
          :value="item.code"
      >
      </el-option>
    </el-select>
  </div>
</template>

<script lang="ts">
import {defineComponent, getCurrentInstance, reactive, ref, watch} from "vue"

// import useAxios from "../../hooks/useAxios";

export interface District {
  code: string,
  name: string
  children?: District[]
}

export interface Data {
  name: string,
  code: string
}

export default defineComponent({
  name: "area-chooser",
  emits: ['change'],
  setup(props, {slots, attrs, emit}) {
    const instance = getCurrentInstance()
    //@ts-ignore
    const {proxy} = getCurrentInstance()
    let provinces = reactive<District[]>([])

    //获取所有数据
    proxy.$axios.get("/provinces").then(response => {
      /*provinces = response.data.data
      console.log(provinces)*/
      provinces.push(...response.data.data)
    }).catch(error => {
      console.log(error)
    })
    const provinceRef = ref('')
    const cityRef = ref('')
    const districtRef = ref('')
    const cityOptions = ref<District[]>([])
    const districtOptions = ref<District[]>([]);

    //监听省份变化
    watch(() => provinceRef.value, value => {
      if (value) {
        cityOptions.value = provinces.find(item => item.code === value)!.children!
      }
      cityRef.value = ''
      districtRef.value = ''
    })

    //监听城市变化
    watch(() => cityRef.value, value => {
      if (value) {
        districtOptions.value = cityOptions.value.find(item => item.code === value)!.children!
      }
      districtRef.value = ''
    })

    //监听 district来触发事件
    watch(() => districtRef.value, value => {
      if (value) {
        const provinceData: Data = {
          code: provinceRef.value,
          name: provinces.find(item => item.code === provinceRef.value)!.name
        }
        const cityData: Data = {
          code: cityRef.value,
          name: cityOptions.value.find(item => item.code === cityRef.value)!.name
        }
        const districtData: Data = {
          code: districtRef.value,
          name: districtOptions.value.find(item => item.code === value)!.name
        }
        // console.log(provinceData, cityData, districtData)
        emit('change', {
          provinceData,
          cityData,
          districtData
        })
      }
    })

    return {
      provinceRef,
      cityRef,
      districtRef,
      provinces,
      cityOptions,
      districtOptions
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
