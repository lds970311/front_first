# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-03-28  9:45
# TOOLS : Pycharm
# FILENAME : dog.py

class Dog:

    def __init__(self, name, age) -> None:
        self.name = name
        self.age = age

    def show_name(self) -> None:
        print(self.name)

    def get_age(self) -> int:
        return self.age


dog = Dog("tom", 12)
dog.show_name()

print(dog.get_age())
print(dog)
