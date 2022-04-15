# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-14  23:42
# TOOLS : Pycharm
# FILENAME : LogDemos.py
# STATEMENT:

import logging
import time
from logging import handlers


def output_logs():
    fmt = '%(asctime)s %(levelname)s [%(name)s] [%(filename)s(%(funcName)s:%(lineno)d)] - %(message)s'
    # 设置日志的级别
    logging.basicConfig(level=logging.WARNING, format=fmt, filename='a.log')
    # 调用logging输出日志
    logging.debug("这是一条调试级别的日志")
    logging.info("这是一条信息级别的日志")
    logging.warning("这是一条警告级别的日志")
    logging.error("这是一条错误级别的日志")
    logging.critical("这是一条严重级别的日志")


def logger_components():
    logger = logging.getLogger("myLogger")  # 创建logger日志器
    logger.setLevel(logging.DEBUG)  # 设置日志器的级别

    # 创建 输出日志到文件的处理器， 文件按时间来切割的
    handler = logging.FileHandler(filename="test.log", encoding='utf-8')
    handler.setLevel(logging.INFO)
    fmt = '%(asctime)s %(threadName)s %(levelname)s [%(name)s] [%(filename)s(%(funcName)s:%(lineno)d)] - %(message)s'
    formatter = logging.Formatter(fmt=fmt)
    handler.setFormatter(fmt=formatter)

    timed_rotating_file_handler = handlers.TimedRotatingFileHandler("testa.log", when='S', interval=5, backupCount=3,
                                                                    encoding='utf-8')
    timed_rotating_file_handler.setLevel(logging.DEBUG)
    timed_rotating_file_handler.setFormatter(fmt=formatter)

    # 过滤器
    logging_filter = logging.Filter("main")
    # 设置输出到控制台的日志
    console_handler = logging.StreamHandler()
    console_handler.setFormatter(fmt=formatter)
    logger.addHandler(console_handler)
    # logger.addHandler(handler)
    logger.addHandler(timed_rotating_file_handler)
    for i in range(10):
        #  输出日志信息
        time.sleep(1)
        logger.info("这是一条信息级别的日志!")


if __name__ == '__main__':
    # output_logs()
    logger_components()
