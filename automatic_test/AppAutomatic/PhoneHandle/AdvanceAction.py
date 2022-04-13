# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-12  19:32
# TOOLS : Pycharm
# FILENAME : AdvanceAction.py
# STATEMENT: 高级手势操作
from appium import webdriver
from appium.webdriver.common.touch_action import TouchAction
from selenium.webdriver.common.by import By

from utils import get_element


def init_info():
    des_cap = dict()  # 定义字典参数

    des_cap["platformName"] = "android"  # 表示的是android 或者IOS系统
    des_cap["platformVersion"] = "7.1.2"  # 表示的是平台系统的版本号
    des_cap["deviceName"] = "****"  # 表示的是设备的ID名称（如果只有一个设备可以用****来替代）
    des_cap["resetKeyboard"] = True
    des_cap["unicodeKeyboard"] = True
    des_cap["noReset"] = True
    return des_cap


def actions():
    config_info = init_info()
    driver = webdriver.Remote("http://localhost:4723/wd/hub", config_info)
    # 轻巧操作
    action = TouchAction(driver)
    element = get_element(driver, By.ID, "com.netease.newsreader.activity:id/bre")
    # action.tap(element=element, x=100, y=100, count=2)
    # action.tap(element=element, count=2)
    # 长按操作
    action.press(el=element).wait(400).release()
    action.perform()


if __name__ == '__main__':
    actions()
