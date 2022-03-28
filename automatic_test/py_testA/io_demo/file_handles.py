# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-03-28  10:10
# TOOLS : Pycharm
# FILENAME : file_handles.py
# STATEMENT:

path = "F:\\Java\\front_first\\automatic_test\\py_testA\\news.txt"


def read_file(src_path):
    with open(src_path, "r", encoding="utf-8") as file:
        while True:
            txt = file.readline()

            if txt == "":
                break

            print(txt)


if __name__ == '__main__':
    read_file(path)
