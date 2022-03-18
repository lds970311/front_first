// Author : evan lee
// Time ： 2022-03-17  19:42
// FILENAME : Member.java
// STATEMENT: 

package cn.evanlee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {
    private Integer id;//主键
    private String fileNumber;//档案号
    private String name;//姓名
    private String sex;//性别
    private String idCard;//身份证号
    private String phoneNumber;//手机号
    private Date regTime;//注册时间
    private String password;//登录密码
    private String email;//邮箱
    private Date birthday;//出生日期
    private String remark;//备注
}
