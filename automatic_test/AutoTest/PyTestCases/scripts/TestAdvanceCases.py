# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-13  16:00
# TOOLS : Pycharm
# FILENAME : TestAdvanceCases.py
# STATEMENT:
import time

import pytest


def sub(num1: int, num2: int) -> int:
    result = num2 - num1
    return result


def multiple(num1: float, num2: float) -> float:
    return num1 * num2


class TestAdvance:
    def setup(self):
        print("测试用例开始执行时间:", time.strftime("%Y-%m-%D %H:%M:%S"))

    @pytest.mark.skipif(condition=True, reason="跳过减法测试")
    def test_sub(self) -> None:
        result = sub(2, 3)
        assert result == 1

    @pytest.mark.parametrize("x,y,expect", [(1, 2, 2), (2, 2, 4), (3, 2, 6)])
    def test_multiple(self, x, y, expect):
        result = multiple(x, y)
        assert result == expect

    def teardown(self):
        print("测试用例结束时间:", time.strftime("%Y-%m-%D %H:%M:%S"))
