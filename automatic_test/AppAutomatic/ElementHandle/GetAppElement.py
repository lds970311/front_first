# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-11  23:57
# TOOLS : Pycharm
# FILENAME : GetAppElement.py
# STATEMENT:
import os
import time

from appium import webdriver

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


def connect_app():
    desc = init_info()
    driver = webdriver.Remote("http://localhost:4723/wd/hub", desc)
    # 启动app
    # driver.start_activity("com.bjcsxq.chat.carfriend", ".module_main.activity.MainActivity ")
    from selenium.webdriver.common.by import By
    bar = driver.find_element(By.ID, "com.bjcsxq.chat.carfriend:id/tv_enrol_search")
    bar.click()
    input = get_element(driver, By.ID, "com.bjcsxq.chat.carfriend:id/et_enrol_search")
    input.send_keys("远大驾校")
    get_element(driver, By.ID, "com.bjcsxq.chat.carfriend:id/tv_search_btn").click()
    driver_list = driver.find_elements_by_class_name("android.widget.LinearLayout")
    if len(driver_list) != 0:
        driver_list[0].click()
        current = driver.find_elements_by_id("com.bjcsxq.chat.carfriend:id/rel_item_banxing_parent")
        if len(current) != 0:
            print(current)
            current[0].click()
    # 关闭app
    driver.get_screenshot_as_file(os.path.abspath("../screenshot/shot.png"))
    time.sleep(5)
    driver.close_app()
    driver.quit()


if __name__ == '__main__':
    connect_app()
