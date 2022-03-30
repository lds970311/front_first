# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-03-29  17:58
# TOOLS : Pycharm
# FILENAME : SendRequest.py
# STATEMENT:

import requests

response = requests.get("https://www.baidu.com")

print(response.url)
