# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-15  18:36
# TOOLS : Pycharm
# FILENAME : BaseInfo.py
# STATEMENT:
import logging

from appium.webdriver import WebElement
from selenium.webdriver.support.wait import WebDriverWait

from utils.Utils import DriverUtils


class BasePage:
    def __init__(self) -> None:
        self.driver = DriverUtils.get_app_driver()

    def find_element(self, location):
        wait = WebDriverWait(self.driver, 5, 1)
        return wait.until(lambda x: x.find_element(*location))


class BaseHandle:
    def input_text(self, element: WebElement, text: str):
        element.click()
        element.send_keys(text)

    def set_radio_checked(self, element: WebElement):
        logging.info(element.get_attribute("checked"))
        if not element.get_attribute("checked"):
            element.click()
