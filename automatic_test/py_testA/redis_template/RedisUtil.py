# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-16  10:14
# TOOLS : Pycharm
# FILENAME : RedisUtil.py
# STATEMENT:

import redis


class RedisUtil(object):
    _redis = None

    @classmethod
    def get_redis_connection_pool(cls):
        if cls._redis is None:
            cls._redis = redis.Redis(host='192.168.208.129',
                                     port=6379, decode_responses=True)

    @classmethod
    def string_handle(cls, key, value):
        cls._redis.set(key, value)


if __name__ == '__main__':
    RedisUtil.get_redis_connection_pool()
    RedisUtil.string_handle("name", "123")
