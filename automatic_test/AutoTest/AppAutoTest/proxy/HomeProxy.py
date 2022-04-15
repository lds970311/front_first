# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-15  18:41
# TOOLS : Pycharm
# FILENAME : HomeProxy.py
# STATEMENT:
from handle.HomePageHandle import HomePageHandle


class HomeProxy:

    def __init__(self) -> None:
        super().__init__()
        self.home_handle = HomePageHandle()

    def click_my_btn(self):
        self.home_handle.click_my_btn()
