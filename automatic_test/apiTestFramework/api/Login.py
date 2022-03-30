# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-03-30  9:04
# TOOLS : Pycharm
# FILENAME : Login.py
# STATEMENT: 登录接口封装


class LoginApi:
    def __init__(self) -> None:
        self.login_url = "http://192.168.208.129:92/index.php?m=Home&c=User&a=do_login"
        self.verify_url = "http://192.168.208.129:92/index.php?m=Home&c=User&a=verify"

        # 获取验证码接口

    def get_verify_code(self, session):
        return session.get(self.verify_url)

    def login(self, session, username, password, verify_code):
        login_data = {
            "username": username,
            "password": password,
            "verify_code": verify_code
        }
        return session.post(url=self.login_url, data=login_data)
