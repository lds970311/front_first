# 云日记项目

## 1. 用户模块

通过用户行为来区分 actionName

- 用户登录 actionName="login"
- 进入个人中心 actionName="userCenter"
- 加载头像 actionName="avatar"
- 验证昵称的唯一性 actionName="checkUnique"
- 修改用户信息 actionName="updateUser"
- 用户退出 actionName="logout"

在UserServlet的service方法中:

1. 获取用户行为

```java
String actionName=request.getParameter("actionName");
```

2. 判断用户行为，调用对应的方法

```java
if("login".equals(actionName)){
        // 用户登录
        }else if("userCenter".equals(actionName)){
// 进入个人中心
        }
```

### 1.1 前端实现

1. 添加表单，设置表单属性
2. 设置表单元素的name属性值，修改id属性值（首字母改小写）
3. 在 js文件中，添加按钮的点击事件绑定的函数 checkLogin()
    - 获取表单元素的值（姓名、密码）
    - 判断元素的值是否为空, 是否符合格式要求
    - 如果不为空，则提交表单

### 1.2 后端实现

1. 获取参数 （姓名、密码）
2. 参数的非空校验 （ResultInfo的封装类，用来封装响应结果 状态码、提示信息、返回的对象）
3. 如果不为空，通过用户名查询用户对象
4. 判断用户对象是否为空
5. 如果用户对象不为空，将数据库中查询到的用户对象的密码与前台传递的密码作比较 （将密码加密后再比较）
6. 如果密码正确:
    - 将用户信息存到session作用域中
    - 判断用户是否选择记住密码（rem的值是1）
    - 如果是，将用户姓名与密码存到cookie中，设置失效时间，并响应给客户端,如果否，清空原有的cookie对象,
    - 重定向跳转到index页面