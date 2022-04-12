# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-11  22:38
# TOOLS : Pycharm
# FILENAME : InstallApp.py
# STATEMENT:

import time

from appium import webdriver


def init_info():
    des_cap = dict()  # 定义字典参数

    des_cap["platformName"] = "android"  # 表示的是android 或者IOS系统
    des_cap["platformVersion"] = "7.1.2"  # 表示的是平台系统的版本号
    des_cap["deviceName"] = "****"  # 表示的是设备的ID名称（如果只有一个设备可以用****来替代）

    return des_cap


def install_app():
    desc = init_info()
    driver = webdriver.Remote("http://localhost:4723/wd/hub", desc)
    # 安装app
    # driver.install_app("H:\\Java\\softwareTest\\apks\\zuoyebang.apk")
    # 卸载app
    driver.remove_app("com.baidu.homework")
    time.sleep(5)
    # 关闭app


if __name__ == '__main__':
    install_app()
