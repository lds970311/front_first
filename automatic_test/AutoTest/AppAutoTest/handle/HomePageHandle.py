from base.BaseInfo import BaseHandle
from pages.HomePage import HomePage


class HomePageHandle(BaseHandle):

    def __init__(self) -> None:
        super().__init__()
        self.home_page = HomePage()

    def click_my_btn(self):
        self.home_page.get_my_btn().click()
