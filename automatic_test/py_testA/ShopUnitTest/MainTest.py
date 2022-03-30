# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-03-29  20:04
# TOOLS : Pycharm
# FILENAME : MainTest.py
# STATEMENT:

import unittest

import requests


class MainTest(unittest.TestCase):
    def setUp(self) -> None:
        self.session = requests.Session()
        self.login_url = "http://192.168.208.129:92/index.php?m=Home&c=User&a=do_login"
        self.verify_url = "http://192.168.208.129:92/index.php?m=Home&c=User&a=verify"

    def tearDown(self) -> None:
        self.session.close()

    def test_login_success(self):
        response = self.session.get(url=self.verify_url)
        self.assertEqual(200, response.status_code)
        self.assertIn("image", response.headers.get("Content-type"))
        # 登录
        login_data = {
            "username": "2696612575@qq.com",
            "password": "19970311",
            "verify_code": 8888
        }
        result = self.session.post(url=self.login_url, data=login_data)
        self.assertEqual(200, result.status_code)
        self.assertIn("成功", result.json().get("msg"))

    def test_login_error(self):
        response = self.session.get(url=self.verify_url)
        self.assertEqual(200, response.status_code)
        self.assertIn("image", response.headers.get("Content-type"))
        # 登录
        login_data = {
            "username": "13066774532",
            "password": "19970311",
            "verify_code": 8888
        }
        result = self.session.post(url=self.login_url, data=login_data)
        self.assertEqual(200, result.status_code)
        self.assertIn("不存在", result.json().get("msg"))
