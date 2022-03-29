# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-03-28  11:08
# TOOLS : Pycharm
# FILENAME : testcase_01.py
# STATEMENT:
import unittest

from parameterized import parameterized


def my_sum(a, b) -> int:
    return a + b


def setUpModule():
    print("setUpModule自动调用了")


def tearDownModule():
    print("tearDownModule自动调用了")


list1 = [(1, 2, 3), (5, 6, 11), (-1, 3, 2)]


class my_test(unittest.TestCase):

    @classmethod
    def setUpClass(cls) -> None:
        print("setupclass自动调用了")

    @classmethod
    def tearDownClass(cls) -> None:
        print("teardownclass自动调用了")

    def setUp(self) -> None:
        print("setup被自动调用了")

    def tearDown(self) -> None:
        print("teardown被自动调用了")

    @parameterized.expand(list1)
    def test_001(self, a, b, c):
        res = my_sum(a, b)
        self.assertEqual(res, c)

    @unittest.skip
    def test_002(self):
        res = my_sum(0, 3)
        self.assertIn(res, [1, 2, 3, 4])
