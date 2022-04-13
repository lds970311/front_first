# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-12  16:39
# TOOLS : Pycharm
# FILENAME : SwipeEvent.py
# STATEMENT:

from appium import webdriver
from selenium.webdriver.common.by import By

from utils import ElementUtil
from utils.PhoneUtils import execute_swipe, swipe_find


def init_info():
    des_cap = dict()  # 定义字典参数

    des_cap["platformName"] = "android"  # 表示的是android 或者IOS系统
    des_cap["platformVersion"] = "7.1.2"  # 表示的是平台系统的版本号
    des_cap["deviceName"] = "****"  # 表示的是设备的ID名称（如果只有一个设备可以用****来替代）
    des_cap["resetKeyboard"] = True
    des_cap["unicodeKeyboard"] = True
    des_cap["noReset"] = True
    return des_cap


def phone_handle():
    config_info = init_info()
    driver = webdriver.Remote("http://localhost:4723/wd/hub", config_info)
    # 获取网路
    execute_swipe(driver, "top", 3)
    element = ElementUtil.get_element(driver, By.CLASS_NAME, "android.widget.HorizontalScrollView")
    swipe_find(driver, element, (By.XPATH, "//*[@text='军事']"))


if __name__ == '__main__':
    phone_handle()
