// Author : evan lee
// Time ： 2022-01-26  19:37
// FILENAME : VerifyCode.java
// STATEMENT: redis实现手机验证码案例

package com.evanlee.jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.Scanner;

public class VerifyCode {
    private static final Jedis jedis;
    private static final Scanner scanner = new Scanner(System.in);

    static {
        jedis = new Jedis("192.168.208.146", 6379);
        jedis.auth("123456");
        //存入奇数hash,标记一天当中验证错误的次数
        jedis.hset("times", "input_time", "0");
        //设置时效为1天
        jedis.expire("times", 60 * 60 * 24);
    }

    private String getCode() {
        StringBuilder sb = new StringBuilder("");
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(nums[random.nextInt(nums.length)]);
        }
        return sb.toString();
    }

    private void saveCode(String code) {
        //如果没超3次,则保存新的验证码,否则返回fasle
        if (!jedis.hget("times", "input_time").equals("3")) {
            jedis.hincrBy("times", "input_time", 1);
            jedis.set("vcode", code);
            jedis.expire("vcode", 120);
            return;
        }
        //超过次数, 移除
        jedis.del("vcode");
    }

    public static void main(String[] args) {
        VerifyCode verifyCode = new VerifyCode();
        String code = verifyCode.getCode();
        verifyCode.saveCode(code);
        while (true) {
            String s = jedis.get("vcode");
            if (s == null) {
                //输入失败超过3次
                System.out.println("进入已经输入错误超过3次,请明天再来!");
                break;

            } else {
                System.out.println("当前验证码为" + s + "请输入,120s内有效");
                String input = scanner.nextLine();
                if (jedis.ttl("vcode") == -2) {
                    System.out.println("验证码已过期");
                    break;
                }
                if (input.equals(s)) {
                    System.out.println("输入正确!");
                    break;
                } else {
                    //输入错误
                    System.out.println("验证码输入错误,请重新输入!");
                    verifyCode.saveCode(verifyCode.getCode());
                }
            }
        }
    }
}
