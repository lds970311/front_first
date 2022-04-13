# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-11  23:54
# TOOLS : Pycharm
# FILENAME : ElementUtil.py
# STATEMENT:
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait


def get_element(driver, find_type, value):
    wait = WebDriverWait(driver, 10, 0.6)
    element = wait.until(lambda x: x.find_element(find_type, value))
    return element


def get_element_by_text(driver, value):
    wait = WebDriverWait(driver, 10, 0.6)
    element = wait.until(lambda x: x.find_element(By.XPATH, "//*[@text='%s']".format(value)))
    return element


def input_value(element, value):
    if element is not None:
        element.clear()
        element.send_keys(value)
    else:
        raise Exception("element not found!")


# 判断元素是否存
def element_is_exist(driver, element, value):  # element 表示的元素定位的值
    try:  # 捕获异常信息
        get_element(driver, element, value)  # 能够正常找元素，就返回True
        return True
    except Exception as e:  # 如果捕获到了异常，返回False
        return False


def get_toast(driver, message, timeout=3):
    # xpath = "//*[contains(@text, '" + message + "')]"   #.format(message)   # 通过{} 符号将message当参数传到xpath表达式中去
    xpath = F"//*[contains(@text, '{message}')]"
    wait = WebDriverWait(driver, timeout, 1)
    element = wait.until(lambda x: x.find_element(By.XPATH, xpath))
    return element.text
