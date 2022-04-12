# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-11  21:33
# TOOLS : Pycharm
# FILENAME : GetAdbConnection.py
# STATEMENT:
# 导入webdriver
import time

from appium import webdriver

if __name__ == '__main__':
    des_cap = dict()  # 定义字典参数

    des_cap["platformName"] = "android"  # 表示的是android 或者IOS系统
    des_cap["platformVersion"] = "7.1.2"  # 表示的是平台系统的版本号
    des_cap["deviceName"] = "****"  # 表示的是设备的ID名称（如果只有一个设备可以用****来替代）
    des_cap["appPackage"] = "com.sina.weibo"  # 表示的是app的包名
    des_cap["appActivity"] = ".MainTabActivity"  # 表示的是app的界面名

    driver = webdriver.Remote("http://localhost:4723/wd/hub", des_cap)

    time.sleep(6)

    driver.quit()
