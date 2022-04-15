# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-15  18:33
# TOOLS : Pycharm
# FILENAME : HomePage.py
# STATEMENT:
from selenium.webdriver.common.by import By

from base.BaseInfo import BasePage


class HomePage(BasePage):

    def __init__(self) -> None:
        super().__init__()
        self.my_btn = (By.XPATH, "//*[@text='我的']")

    def get_my_btn(self):
        return self.find_element(self.my_btn)
