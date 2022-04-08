# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-06  16:32
# TOOLS : Pycharm
# FILENAME : DriverTest.py
# STATEMENT:
# 导入selenium
import time

from selenium import webdriver

# 实例化浏览器驱动对象（创建浏览器驱动对象）

driver = webdriver.Chrome()  # 创建的是谷歌浏览器驱动对象   chrome后面有括号，而且第一个字母要大写
# driver = webdriver.Firefox() # 创建火狐浏览器驱动对象
driver.maximize_window()
# 打开百度网站
driver.get("https://www.163.com")

btn = driver.find_elements_by_xpath(
    "//ul[@class='cm_ul_round']/li[3]/a")
# 获取元素文本

time.sleep(3)
print(btn[0])
print(btn[0].text)
btn[0].click()
# 等待3s（代表业务操作）
time.sleep(5)  # 通过快捷导包的方式导入time模块，  光标要在time后面再按alt+enter
# 退出浏览器驱动(释放系统资源)
driver.quit()
