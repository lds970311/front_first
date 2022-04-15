# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-15  18:20
# TOOLS : Pycharm
# FILENAME : Utils.py
# STATEMENT:
from appium import webdriver


class DriverUtils:
    _driver = None

    @classmethod
    def get_app_driver(cls):
        if cls._driver is None:
            des_cap = dict()  # 定义字典参数

            des_cap["platformName"] = "android"  # 表示的是android 或者IOS系统
            des_cap["platformVersion"] = "7.1.2"  # 表示的是平台系统的版本号
            des_cap["deviceName"] = "****"  # 表示的是设备的ID名称（如果只有一个设备可以用****来替代）
            des_cap["resetKeyboard"] = True
            des_cap["unicodeKeyboard"] = True
            des_cap["noReset"] = True
            des_cap["automationName"] = "UIautomator2"
            cls._driver = webdriver.Remote("http://localhost:4723/wd/hub", des_cap)
        return cls._driver

    @classmethod
    def quit_app_driver(cls):
        if cls._driver is not None:
            cls._driver.quit()
            cls._driver = None
