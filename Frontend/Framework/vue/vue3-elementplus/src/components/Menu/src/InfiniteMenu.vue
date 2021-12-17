<script lang="tsx">
import {defineComponent, h, resolveComponent, useAttrs} from "vue";
import {MenuItem} from "../types";


export default defineComponent({

  props: {
    menus: {
      type: Array,
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
  setup(props, ctx) {
    const attrs = useAttrs()

    function renderMenu(data: MenuItem[]) {
      return data.map((item: MenuItem) => {
        let slots = {
          title: () => {
            return (
                <>
                  <el-icon>
                    {h(resolveComponent(item.icon!))}
                  </el-icon>
                  <span>{item.name}</span>
                </>
            )
          }
        }
        if (item.children && item.children.length !== 0) {
          return (
              <el-sub-menu index={item.index} v-slots={slots}>
                {renderMenu(item.children)}
              </el-sub-menu>
          )
        }
        return (
            <el-menu-item index={item.index}>
              <el-icon>
                {h(resolveComponent(item.icon!))}
              </el-icon>
              <span>{item.name}</span>
            </el-menu-item>
        )
      })
    }

    return () => (
        <div class="infinite">
          <el-menu
              class="el-menu-vertical-demo"
              default-active={props.defaultActive}
              router={props.router || false}
              {...attrs}
          >
            {renderMenu(props.menus as MenuItem[])}
          </el-menu>
        </div>
    )
  }
})
</script>

<style scoped lang="less">
.infinite {
  min-width: 200px;
}
</style>
