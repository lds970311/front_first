# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-03-29  18:40
# TOOLS : Pycharm
# FILENAME : ShopLogin.py
# STATEMENT:
import requests

session = requests.Session()

base_url = "http://192.168.208.129:92/index.php"

verify = "m=Home&c=User&a=verify"
login = "m=Home&c=User&a=do_login"

response = session.get(base_url, params=verify)

php_session_id = response.cookies.get("PHPSESSID")

login_data = {
    "username": "2696612575@qq.com",
    "password": "19970311",
    "verify_code": 8888
}

cookies = {
    "PHPSESSID": php_session_id
}

login_response = requests.post(base_url,
                               params=login,
                               data=login_data,
                               cookies=cookies)

print(login_response.json())
