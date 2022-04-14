import time

import pytest


def add(x, y):
    return x + y


class TestADD:  # 定义的类名必须是以Test开头
    def setup_class(self):
        print("setup class")

    def setup(self):
        print("测试用例开始执行时间:", time.strftime("%Y-%m-%D %H:%M:%S"))

    @pytest.mark.run(order=1)
    def test_add_01(self):  # 定义的测试方法必须是以test开头
        result = add(1, 2)
        print(result)
        assert result is not None

    @pytest.mark.run(order=2)
    def test_add_02(self):
        result = add(2, 2)
        print(result)
        assert result == 3

    def teardown(self):
        print("测试用例结束时间:", time.strftime("%Y-%m-%D %H:%M:%S"))

    def teardown_class(self):
        print("teardown class")
