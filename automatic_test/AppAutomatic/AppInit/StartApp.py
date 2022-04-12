# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-11  22:19
# TOOLS : Pycharm
# FILENAME : StartApp.py
# STATEMENT:
import time

from appium import webdriver


def init_info():
    des_cap = dict()  # 定义字典参数

    des_cap["platformName"] = "android"  # 表示的是android 或者IOS系统
    des_cap["platformVersion"] = "7.1.2"  # 表示的是平台系统的版本号
    des_cap["deviceName"] = "****"  # 表示的是设备的ID名称（如果只有一个设备可以用****来替代）
    # des_cap["appPackage"] = "com.andriod.settings"  # 表示的是app的包名
    # des_cap["appActivity"] = ".Settings"  # 表示的是app的界面名

    return des_cap


def connect_app():
    desc = init_info()
    driver = webdriver.Remote("http://localhost:4723/wd/hub", desc)
    # 启动app
    driver.start_activity("com.sina.weibo", ".VisitorMainTabActivity")
    print(driver.current_package)
    print(driver.current_activity)
    time.sleep(5)
    # 关闭app
    driver.close_app()
    driver.quit()


if __name__ == '__main__':
    connect_app()
