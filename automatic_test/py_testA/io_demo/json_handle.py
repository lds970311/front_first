# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-03-28  10:42
# TOOLS : Pycharm
# FILENAME : json_handle.py
# STATEMENT:

import json


def read_json(path):
    with open(path, "r", encoding='utf-8') as json_file:
        data = json.load(json_file)

        for k, v in data.items():
            print(f'{k}:{v}')


def write_json(path):
    with open(path, "a", encoding='utf-8') as json_file:
        dict1 = {"hobby": "football"}
        json.dump(dict1, json_file, ensure_ascii=False)


write_json("F:\\Java\\front_first\\automatic_test\\py_testA\io_demo\\data.json")
