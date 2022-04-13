# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-12  16:31
# TOOLS : Pycharm
# FILENAME : PhoneUtils.py
# STATEMENT:


# 封装滑屏操作方法
import time


def execute_swipe(driver, fx, count=1):
    size = driver.get_window_size()
    print(size)
    w = size["width"]  # 获取手机屏幕的宽度
    h = size["height"]  # 获取手机屏幕的高度
    # w=1080  h=1920
    if fx == "top":  # 往上滑
        zb = (w / 2, h * 0.9, w / 2, h * 0.1)
    elif fx == "down":  # 往下滑
        zb = (w / 2, h * 0.1, w / 2, h * 0.9)
    elif fx == 'left':  # 往左滑
        zb = (w * 0.9, h / 2, w * 0.1, h / 2)
    else:  # 往右滑
        zb = (w * 0.1, h / 2, w * 0.9, h / 2)
    for i in range(count):
        driver.swipe(*zb, duration=1200)
        time.sleep(1)


# 变滑动边查找
def swipe_find(driver, element, target_element):
    ele_size = element.size  # 获取元素大小
    width = ele_size["width"]  # 获取元素的宽度
    height = ele_size["height"]  # 获取元素的高度
    # 获了element元素左上角点的坐标
    ele_position = element.location
    print(f"滑动元素的位置:{ele_position}")
    x = ele_position["x"]  # 获取左上角点的x坐标值
    y = ele_position["y"]  # 获取左上角点的y坐标值

    start_x = x + width * 0.9  # 获取的是起始点X的值
    y = y + height * 0.8  # 获取的是起始及终止点的Y的值
    end_x = x + width * 0.1  # 获取的是终止点X的值
    while True:
        page = driver.page_source  # 记录查找前的页面资源,通过对比页面资源来退出死循环
        try:
            driver.find_element(*target_element).click()  # 如果有找到对应的元素那么点击并返回
            return True
        except Exception as e:
            print("没有找到该元素！")
        driver.swipe(start_x, y, end_x, y, duration=1000)  # 没有找到元素，那么滑屏后再对比并重新查找
        time.sleep(1)
        if page == driver.page_source:
            print("滑屏操作完成且没有找到元素信息")
            return False
