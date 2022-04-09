# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-08  22:53
# TOOLS : Pycharm
# FILENAME : GetCookies.py
# STATEMENT:
import time

from selenium import webdriver


def init_driver():
    return webdriver.Chrome()


def handle_screenshot():
    driver = init_driver()
    driver.implicitly_wait(5)
    driver.maximize_window()
    driver.get("https://www.baidu.com")
    driver.add_cookie({"name": "BDUSS",
                       "value": "052T3EwbUoyakxBUkZWVXU4MUQwdDRPUXhSb1ZmQlJwWFRqUTdBYklkalJQbDlpSVFBQUFBJCQAAAAAAAAAAAEAAACPy~iw2K9za-zh1b3AxwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANGxN2LRsTdiS"})
    driver.refresh()
    # 获取cookies
    cookies = driver.get_cookies()
    for cookie in cookies:
        print(cookie)
    time.sleep(10)
    driver.quit()


if __name__ == '__main__':
    handle_screenshot()
