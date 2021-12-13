<template>
  <div style="font-size: 20px;">
    <!-- Since svg icons do not carry any attributes by default -->
    <!-- You need to provide attributes directly -->
    <edit style="width: 1em; height: 1em; margin-right: 8px;"/>
    <share style="width: 1em; height: 1em; margin-right: 8px;"/>
    <delete style="width: 1em; height: 1em; margin-right: 8px;"/>
    <search style="width: 1em; height: 1em; margin-right: 8px;"/>
  </div>
</template>

<script lang="ts">
import {computed, defineComponent} from "vue"
import {mapState, useStore} from "vuex";


export default defineComponent({
  name: "",
  components: {
    Navigator
  },
  setup() {
    const store = useStore()
    const stateFuncs = mapState(['homeTitle'])
    const storeState = {}
    Object.keys(stateFuncs).forEach((key: any) => {
      const fn = stateFuncs[key].bind({$store: store})
      storeState[key] = computed(fn)
    })

    return {
      store,
      storeState,
    }
  }
})
</script>

<style scoped>

</style>
