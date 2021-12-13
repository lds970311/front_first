//CREATE AT: 2021-12-12
import {mount} from '@vue/test-utils'
import TestComponent from "../components/TestComponent.vue"

test("component test", async () => {
    const wrapper = await mount(TestComponent)
    expect(wrapper.find('p').text()).toBe('123')
})
