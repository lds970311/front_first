# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-14  19:50
# TOOLS : Pycharm
# FILENAME : HomePageHandle.py
# STATEMENT:
from PO.Handle.BaseHandle import BaseHandle
from PO.Page.HomePage import HomePage


class HomePageHandle(BaseHandle):
    def __init__(self) -> None:
        self.page = HomePage()

    def click_login(self):
        self.page.get_login_btn().click()
