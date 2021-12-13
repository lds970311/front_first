<script lang="tsx">
import {defineComponent, reactive, ref} from "vue"

export default defineComponent({
  name: "TestButton",
  setup() {
    const state = reactive({count: 0});
    const showRef = ref(true)
    const handleClick = () => state.count++;
    return () => (
        <button v-if="showRef" onClick={handleClick} class="btn">
          count: {state.count}
        </button>
    )
  }
})
</script>

<style scoped lang="less">
.btn {
  width: 100px;
  height: 30px;
  background-color: blueviolet;
}
</style>
