# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-12  23:51
# TOOLS : Pycharm
# FILENAME : ToastInfo.py
# STATEMENT:
from appium import webdriver
from selenium.webdriver.common.by import By

from utils import PhoneUtils, ElementUtil


def init_info() -> dict:
    des_cap = dict()  # 定义字典参数

    des_cap["platformName"] = "android"  # 表示的是android 或者IOS系统
    des_cap["platformVersion"] = "7.1.2"  # 表示的是平台系统的版本号
    des_cap["deviceName"] = "****"  # 表示的是设备的ID名称（如果只有一个设备可以用****来替代）
    des_cap["resetKeyboard"] = True
    des_cap["unicodeKeyboard"] = True
    des_cap["noReset"] = True
    des_cap["automationName"] = "UIautomator2"
    return des_cap


def handle_toast():
    config_info = init_info()
    driver = webdriver.Remote("http://localhost:4723/wd/hub", config_info)
    PhoneUtils.execute_swipe(driver, "top", 2)
    element = ElementUtil.get_element(driver, By.XPATH, "//*[@text='关于平板电脑']")
    element.click()
    PhoneUtils.execute_swipe(driver, "top", 2)
    version = ElementUtil.get_element(driver, By.XPATH, "//*[@text='版本号']")
    version.click()
    # 查找toast
    toast_text = ElementUtil.get_toast(driver, "开发者模式", 1)
    print(toast_text)


if __name__ == '__main__':
    handle_toast()
