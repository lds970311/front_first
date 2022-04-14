# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-13  22:16
# TOOLS : Pycharm
# FILENAME : BasePage.py
# STATEMENT:
from PO.utils.UtilsDriver import UtilsDriver


class BasePage:
    def __init__(self) -> None:
        self.driver = UtilsDriver.get_driver()

    def find_element(self, location: tuple):
        return self.driver.find_element(location[0], location[1])
