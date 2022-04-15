# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-15  18:33
# TOOLS : Pycharm
# FILENAME : LoginPage.py
# STATEMENT:
from appium.webdriver import WebElement
from selenium.webdriver.common.by import By

from base.BaseInfo import BasePage


class LoginPage(BasePage):

    def __init__(self) -> None:
        super().__init__()
        self.tel_no = (By.ID, "com.bjcsxq.chat.carfriend:id/login_phone_et")
        self.password = (By.ID, "com.bjcsxq.chat.carfriend:id/login_pwd_et")
        self.read_checkbox = (By.ID, "com.bjcsxq.chat.carfriend:id/check")
        self.login_btn = (By.ID, "com.bjcsxq.chat.carfriend:id/login_btn")
        self.txt_msg = (By.ID, "com.bjcsxq.chat.carfriend:id/txt_msg")
        self.confirm = (By.ID, "com.bjcsxq.chat.carfriend:id/btn_pos")

    def get_tel_no(self) -> WebElement:
        return self.find_element(self.tel_no)

    def get_password(self) -> WebElement:
        return self.find_element(self.password)

    def get_read_checkbox(self) -> WebElement:
        return self.driver.find_element(*self.read_checkbox)

    def get_login_btn(self) -> WebElement:
        return self.find_element(self.login_btn)

    def get_txt_msg(self) -> WebElement:
        return self.find_element(self.txt_msg)

    # 查找确定按钮
    def find_confirm(self):
        return self.find_element(self.confirm)
