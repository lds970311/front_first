# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-03-30  9:19
# TOOLS : Pycharm
# FILENAME : TestLoginApi.py
# STATEMENT:

import json
import os
import unittest

import requests
from parameterized import parameterized

from api.Login import LoginApi


def build_data():
    test_data = []
    path = os.path.abspath(".") + '\\data\\login.json'

    with open(path, "r", encoding="utf-8") as file:
        json_data = json.load(file)
        for data in json_data:
            username = data.get("username")
            password = data.get("password")
            verify_code = data.get("verify_code")
            status_code = data.get("status_code")
            content_type = data.get("content_type")
            status = data.get("status")
            msg = data.get("msg")
            test_data.append((username, password, verify_code, status_code,
                              content_type, status, msg))
            print("test_data = {}".format((username, password, verify_code,
                                           status_code, content_type, status, msg)))
    return test_data


class LoginTest(unittest.TestCase):

    def setUp(self) -> None:
        self.session = requests.session()
        self.login_api = LoginApi()

    def tearDown(self) -> None:
        self.session.close()

    @parameterized.expand(build_data())
    def test_login_success(self, username, password, verify_code, status_code,
                           content_type, status, msg):
        response = self.login_api.get_verify_code(self.session)

        self.assertEqual(status_code, response.status_code)
        self.assertIn(content_type, response.headers.get("Content-Type"))
        # 调用登录接口
        response = self.login_api.login(self.session, username, password, verify_code)
        print(response.json())
        self.assertEqual(status_code, response.status_code)
        self.assertEqual(status, response.json().get("status"))
        self.assertIn(msg, response.json().get("msg"))
