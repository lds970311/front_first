// Author : evan lee
// Time ： 2022-01-06  11:41
// FILENAME : Main.java
// STATEMENT: 

package com.codewolf.moviebuy;


import com.codewolf.moviebuy.beans.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static final List<User> allUsers = new ArrayList<>(); //存放系统注册的用户对象信息
    private static final Map<Business, List<Movie>> businessMap = new HashMap<>(); //存放商家和其排片信息
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final Scanner scanner = new Scanner(System.in);
    private static User loginUser;
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 定义一个静态的Map集合存储电影的评分
     */
    public static final Map<String, List<Double>> movieScore = new HashMap<>();


    //准备一些测试数据
    static {
        Customer c = new Customer();
        c.setLoginName("zyf888");
        c.setPassword("123456");
        c.setTrueName("黑马刘德华");
        c.setGender(Gender.Male);
        c.setAccountNum(10000.0);
        c.setTel("110110");
        allUsers.add(c);

        Customer c1 = new Customer();
        c1.setLoginName("gzl888");
        c1.setPassword("123456");
        c1.setTrueName("黑马关之琳");
        c1.setGender(Gender.Female);
        c1.setAccountNum(2000.0);
        c1.setTel("111111");
        allUsers.add(c1);

        Business b = new Business();
        b.setLoginName("baozugong888");
        b.setPassword("123456");
        b.setTrueName("黑马包租公");
        b.setAccountNum(0.0);
        b.setGender(Gender.Male);
        b.setTel("110110");
        b.setAddress("火星6号2B二层");
        b.setBusinessName("甜甜圈国际影城");
        allUsers.add(b);
        // 注意，商家一定需要加入到店铺排片信息中去
        List<Movie> movies = new ArrayList<>();
        businessMap.put(b, movies); // b = []

        Business b2 = new Business();
        b2.setLoginName("baozupo888");
        b2.setPassword("123456");
        b2.setTrueName("黑马包租婆");
        b2.setAccountNum(0.0);
        b2.setGender(Gender.Male);
        b2.setTel("110110");
        b2.setAddress("火星8号8B八层");
        b2.setBusinessName("巧克力国际影城");
        allUsers.add(b2);
        // 注意，商家一定需要加入到店铺排片信息中去
        List<Movie> movies3 = new ArrayList<>();
        businessMap.put(b2, movies3); // b2 = []
    }

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        while (true) {
            System.out.println("================黑影首页=================");
            System.out.println("1、登录");
            System.out.println("2、用户注册");
            System.out.println("3、商家注册");
            System.out.println("4、退出系统");
            System.out.println("请输入操作命令：");
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "1":
                    login();
                    break;
                case "2":
                    registerCustomer();
                    break;
                case "3":
                    registerBusiness();
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("输入有误");
                    logger.error("输入有误!");
            }
        }
    }

    public static void registerBusiness() {
        System.out.println("===============商家注册页面=================");
        System.out.println("请输入登录名");
        String loginName = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        String gender = null;
        Gender g;
        while (true) {
            System.out.println("请输入性别");
            gender = scanner.nextLine();
            if ("男".equals(gender)) {
                g = Gender.Male;
                break;
            } else if ("女".equals(gender)) {
                g = Gender.Female;
                break;
            } else {
                System.out.println("输入有误,请重新输入!");
            }
        }
        System.out.println("请输入真实姓名!");
        String realName = scanner.nextLine();
        System.out.println("请输入电话号码");
        String tel = scanner.nextLine();
        System.out.println("请输入店铺名称");
        String businessName = scanner.nextLine();
        System.out.println("请输入店铺地址");
        String address = scanner.nextLine();
        Business business = new Business(loginName, password, realName, g, tel, 0.0, businessName, address);
        allUsers.add(business);
        businessMap.put(business, new ArrayList<>());
        System.out.println(loginName + "注册成功!");
        logger.info("商家" + loginName + "注册成功!");
    }

    public static void registerCustomer() {
        System.out.println("===============用户注册页面=================");
        System.out.println("请输入登录名");
        String loginName = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        String gender = null;
        Gender g;
        while (true) {
            System.out.println("请输入性别");
            gender = scanner.nextLine();
            if ("男".equals(gender)) {
                g = Gender.Male;
                break;
            } else if ("女".equals(gender)) {
                g = Gender.Female;
                break;
            } else {
                System.out.println("输入有误,请重新输入!");
            }
        }
        System.out.println("请输入真实姓名!");
        String realName = scanner.nextLine();
        System.out.println("请输入电话号码");
        String tel = scanner.nextLine();
        while (true) {
            try {
                System.out.println("请输入账户余额!");
                Double accountNum = Double.valueOf(scanner.nextLine());
                Customer customer = new Customer(loginName, password, realName, g, tel, accountNum, new HashMap<>());
                allUsers.add(customer);
                System.out.println("用户" + loginName + "注册成功");
                logger.info("用户" + loginName + "注册成功");
                break;
            } catch (NumberFormatException e) {
                System.out.println("账户金额输入格式有误!,请重新输入");
                logger.error(loginName + "账户金额输入格式有误!,请重新输入");
                e.printStackTrace();
            }
        }
    }

    public static void login() {
        while (true) {
            System.out.println("请您输入登录名称：");
            String loginName = scanner.nextLine();
            System.out.println("请您输入登录密码：");
            String passWord = scanner.nextLine();

            //找到loginName对应的user
            User user = findUser(loginName);
            if (user != null) {
                if (user.getPassword().equals(passWord)) {
                    loginUser = user;
                    logger.info(user.getLoginName() + "登陆了系统!");
                    if (loginUser instanceof Customer) {
                        showCostomerMenu();
                    } else {
                        showBusinessMenu();
                    }
                    break;
                } else {
                    System.out.println("密码输入错误!");
                    logger.error("密码输入错误");
                }
            } else {
                System.out.println("用户名不存在");
                logger.error("用户名或密码错误");
            }
        }
    }

    //显示商户菜单
    private static void showBusinessMenu() {
        boolean flag = false;
        do {
            System.out.println("============黑马电影商家界面===================");
            System.out.println(loginUser.getLoginName() + (loginUser.getGender() == Gender.Male ? "先生" : "女士" + "欢迎您进入系统"));
            System.out.println("1、展示详情:");
            System.out.println("2、上架电影:");
            System.out.println("3、下架电影:");
            System.out.println("4、修改电影:");
            System.out.println("5、退出:");
            System.out.println("请输入您要操作的命令：");
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "1":
                    showMovieDetail();
                    break;
                case "2":
                    addMovie();
                    break;
                case "3":
                    deleteMovie();
                    break;
                case "4":
                    modifyMovie();
                    break;
                case "5":
                    flag = true;
                    break;
                default:
                    System.out.println("输入指令有误, 请重新输入!");
            }
        } while (!flag);
    }

    /**
     * (商家)修改电影
     */
    private static void modifyMovie() {
        System.out.println("================修改电影====================");
        Business business = (Business) loginUser;
        List<Movie> movies = businessMap.get(business);

        if (movies.size() == 0) {
            System.out.println("当期无片可以修改~~");
            return;
        }

        // 2、让用户选择需要下架的电影名称
        while (true) {
            System.out.println("请您输入需要修改的电影名称：");
            String movieName = scanner.nextLine();

            // 3、去查询有没有这个影片对象。
            Movie movie = getMovieByName(movieName, movies);
            if (movie != null) {
                // 修改它
                System.out.println("请您输入修改后的片名：");
                String name = scanner.nextLine();
                System.out.println("请您输入修改后主演：");
                String actor = scanner.nextLine();
                System.out.println("请您输入修改后时长：");
                String time = scanner.nextLine();
                System.out.println("请您输入修改后票价：");
                String price = scanner.nextLine();
                System.out.println("请您输入修改后票数：");
                String totalNumber = scanner.nextLine(); // 200\n
                while (true) {
                    try {
                        System.out.println("请您输入修改后的影片放映时间：");
                        String stime = scanner.nextLine();

                        movie.setName(name);
                        movie.setActor(actor);
                        movie.setPrice(Double.valueOf(price));
                        movie.setTime(Double.valueOf(time));
                        movie.setTickCount(Integer.valueOf(totalNumber));
                        movie.setStartTime(dateFormatter.parse(stime));

                        System.out.println("恭喜您，您成功修改了该影片了！！！");
                        showMovieDetail();
                        return; // 直接退出去
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error("时间解析出了毛病");
                    }
                }
            } else {
                System.out.println("您的店铺没有上架该影片！");
                System.out.println("请问继续修改吗？y/n");
                String command = scanner.nextLine();
                if ("y".equals(command)) {
                    continue;
                } else {
                    System.out.println("好的！");
                    return;
                }
            }
        }
    }

    /**
     * (商家)下架电影
     */
    private static void deleteMovie() {
        System.out.println("================下架电影====================");
        Business business = (Business) loginUser;
        List<Movie> movies = businessMap.get(business);
        if (movies.size() == 0) {
            System.out.println("当前没有可以下架的电影!");
            return;
        }
        // 2、让用户选择需要下架的电影名称
        while (true) {
            System.out.println("请您输入需要下架的电影名称：");
            String name = scanner.nextLine();
            Movie toRemove = getMovieByName(name, movies);
            if (toRemove != null) {
                movies.remove(toRemove);
                System.out.printf("%s 删除成功!\n", toRemove.getName());
                logger.info(business.getBusinessName() + "删除了电影" + toRemove.getName());
                return;
            } else {
                System.out.println("您的店铺没有上架该影片！");
                System.out.println("请问继续下架吗？y/n");
                String cmd = scanner.nextLine();
                if (Objects.equals(cmd, "y") || Objects.equals(cmd, "Y")) {
                    continue;
                } else {
                    break;
                }
            }
        }
    }

    private static Movie getMovieByName(String name, List<Movie> movies) {
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }

    /**
     * (商家)上架电影
     */
    private static void addMovie() {
        System.out.println("================上架电影====================");
        // 根据商家对象(就是登录的用户loginUser)，作为Map集合的键 提取对应的值就是其排片信息 ：Map<Business , List<Movie>> ALL_MOVIES
        Business business = (Business) loginUser;
        List<Movie> movies = businessMap.get(business);

        System.out.println("请您输入新片名：");
        String name = scanner.nextLine();
        Movie m = getMovieByName(name, movies);
        if (m == null) {
            System.out.println("请输入评分");
            String rate = scanner.nextLine();
            System.out.println("请您输入主演：");
            String actor = scanner.nextLine();
            System.out.println("请您输入时长：");
            String time = scanner.nextLine();
            System.out.println("请您输入票价：");
            String price = scanner.nextLine();
            System.out.println("请您输入票数：");
            String totalNumber = scanner.nextLine(); // 200\n
            while (true) {
                try {
                    System.out.println("请您输入影片放映时间：");
                    String stime = scanner.nextLine();
                    // public Movie(String name, String actor, double time, double price, int number, Date startTime)        // 封装成电影对象 ，加入集合movices中去
                    Movie movie = new Movie(name, actor, Double.parseDouble(rate), Double.valueOf(time), Double.valueOf(price)
                            , Integer.valueOf(totalNumber), dateFormatter.parse(stime));
                    movies.add(movie);
                    System.out.println("您已经成功上架了：《" + movie.getName() + "》");
                    break; // 直接退出去
                } catch (ParseException e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
            }
        } else {
            System.out.println("该电影已经上架,不能重复上架!");
            logger.warn("该电影已经上架,不能重复上架!");
        }

    }

    /**
     * (商家)展示详情
     */
    private static void showMovieDetail() {
        System.out.println("================商家详情界面=================");
        logger.info(loginUser.getLoginName() + "商家，正在看自己的详情~~~");
        // 根据商家对象(就是登录的用户loginUser)，作为Map集合的键 提取对应的值就是其排片信息 ：Map<Business , List<Movie>> ALL_MOVIES
        Business business = (Business) loginUser;
        System.out.println(business.getBusinessName() + "\t\t电话：" + business.getTel()
                + "\t\t地址:" + business.getAddress() + "\t\t余额：" + business.getAccountNum());
        List<Movie> movies = businessMap.get(business);
        if (movies.size() > 0) {
            System.out.println("片名\t\t\t主演\t\t时长\t\t评分\t\t票价\t\t余票数量\t\t放映时间");
            for (Movie movie : movies) {

                System.out.println(movie.getName() + "\t\t\t" + movie.getActor() + "\t\t" + movie.getTime()
                        + "\t\t" + movie.getRating() + "\t\t" + movie.getPrice() + "\t\t" + movie.getTickCount() + "\t\t"
                        + dateFormatter.format(movie.getStartTime()));
            }
        } else {
            System.out.println("您的店铺当前无片在放映~~~~");
        }
    }


    //显示顾客菜单
    private static void showCostomerMenu() {
        boolean flag = false;
        do {
            System.out.println("============黑马电影客户界面===================");
            System.out.println(loginUser.getLoginName() + (loginUser.getGender() == Gender.Male ? "先生" : "女士" + "欢迎您进入系统" +
                    "\t余额：" + loginUser.getAccountNum()));
            System.out.println("请您选择要操作的功能：");
            System.out.println("1、展示全部影片信息:");
            System.out.println("2、根据电影名称查询电影信息:");
            System.out.println("3、评分功能:");
            System.out.println("4、购票功能:");
            System.out.println("5、退出系统:");
            System.out.println("请输入您要操作的命令：");
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "1":
                    showAllMovies();
                    break;
                case "2":
                    getMovieDetail();
                    break;
                case "3":
                    goRate();
                    break;
                case "4":
                    buyTicket();
                    break;
                case "5":
                    flag = true;
                    break;
                default:
                    System.out.println("输入指令有误, 请重新输入!");
            }
        } while (!flag);
    }

    /**
     * (客户)购票
     */
    private static void buyTicket() {
        showAllMovies();
        Customer customer = (Customer) loginUser;
        System.out.println("=============用户购票功能=================");
        while (true) {
            System.out.println("请您输入需要买票的门店：");
            String showName = scanner.nextLine();
            Business business = findBusinessByName(showName);
            if (business == null) {
                System.out.printf("店铺%s不存在\n", showName);
                System.out.println("请问继续购票吗？y/n");
                String cmd = scanner.nextLine();
                if (Objects.equals(cmd, "y") || Objects.equals(cmd, "Y")) {
                    continue;
                } else {
                    break;
                }
            } else {
                //查询店铺对应的影片
                System.out.println("请输入电影名称");
                String movieName = scanner.nextLine();
                List<Movie> movieList = businessMap.get(business);
                if (movieList.size() != 0) {
                    Movie selectedMovie = getMovieByName(movieName, movieList);
                    if (selectedMovie != null) {
                        while (true) {
                            System.out.println("请输入购票的数量");
                            try {
                                int tickCount = 0;
                                while (true) {
                                    tickCount = Integer.parseInt(scanner.nextLine());
                                    if (tickCount > selectedMovie.getTickCount()) {
                                        System.out.println("票数不足,请重新购买");
                                        logger.error(selectedMovie.getName() + "票数不足, 重新购买");
                                        System.out.println("请问继续购票吗？y/n");
                                        String cmd = scanner.nextLine();
                                        if (Objects.equals(cmd, "y") || Objects.equals(cmd, "Y")) {
                                            continue;
                                        } else {
                                            return;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                Double totalMoney = tickCount * selectedMovie.getPrice();
                                if (totalMoney <= customer.getAccountNum()) {
                                    //商户余额++ 客户余额--
                                    customer.setAccountNum(customer.getAccountNum() - totalMoney);
                                    business.setAccountNum(business.getAccountNum() + totalMoney);
                                    selectedMovie.setTickCount(selectedMovie.getTickCount() - tickCount);
                                    Map<String, Boolean> buyMovies = customer.getBuyMovies();
                                    buyMovies.put(selectedMovie.getName(), false); //添加到已观看序列
                                    System.out.println("成功购买了" + selectedMovie.getName() + "票" + tickCount + "张");
                                    System.out.println("当前余额为:" + customer.getAccountNum());
                                    logger.info(customer.getLoginName() + "成功购买了" + selectedMovie.getName() + "票" + tickCount + "张");
                                    return;
                                } else {
                                    System.out.println("当前余额不足,请重新选择票数!");
                                    String cmd = scanner.nextLine();
                                    if (!Objects.equals(cmd, "y") && !Objects.equals(cmd, "Y")) {
                                        return;
                                    }
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("数量填写不正确! 请重新输入!");
                                logger.error(e.getMessage());
                            }
                        }
                    } else {
                        //没有该影片
                        System.out.println("该影院没有上架该影片!");
                        logger.warn("该影院没有上架该影片!");
                        System.out.println("是否继续购票? y/n");
                        String cmd = scanner.nextLine();
                        if (Objects.equals(cmd, "y") || Objects.equals(cmd, "Y")) {
                            continue;
                        } else {
                            break;
                        }
                    }
                } else {
                    //没有影片
                    System.out.println("该影院已关门,请去别家");
                    System.out.println("请问继续购票吗？y/n");
                    String cmd = scanner.nextLine();
                    if (Objects.equals(cmd, "y") || Objects.equals(cmd, "Y")) {
                        continue;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private static Business findBusinessByName(String showName) {
        Set<Business> businessSet = businessMap.keySet();
        for (Business business : businessSet) {
            if (business.getBusinessName().equals(showName)) {
                return business;
            }
        }
        return null;
    }

    /**
     * (客户)评分
     */
    private static void goRate() {
        // 1、查询当前登录成功的用户历史购买记录，看哪些电影是它可以评分的。
        Customer c = (Customer) loginUser;
        Map<String, Boolean> movies = c.getBuyMovies();
        if (movies.size() == 0) {
            System.out.println("当前您没有看过电影，不能评价！");
            return;
        }

        // 买过了 ，看哪些电影是它可以评分的。
        movies.forEach((name, flag) -> {
            if (flag) {
                System.out.println(name + "此电影已评价");
            } else {
                System.out.println("请您对：" + name + "进行打分（0-10）：");
                double score = Double.parseDouble(scanner.nextLine());

                // 先根据电影名称拿到评分数据
                List<Double> scores = movieScore.get(name); // MOVIES_SCORE = [ 名称=[10] , ... ]
                if (scores == null) {
                    // 说明此电影是第一次评价
                    scores = new ArrayList<>();
                    scores.add(score);
                    movieScore.put(name, scores);
                } else {
                    scores.add(score);
                }

                movies.put(name, true);
            }
        });
    }

    /**
     * (客户)根据电影名称查询电影信息
     */
    private static void getMovieDetail() {
        System.out.println("请输入电影名称");
        String name = scanner.nextLine();
        Collection<List<Movie>> values = businessMap.values();
        for (List<Movie> value : values) {
            for (Movie movie : value) {
                if (movie.getName().equals(name)) {
                    showMovieDetail(movie);
                    break;
                }
            }
        }
        System.out.println("未查到相关电影!");
    }

    private static void showMovieDetail(Movie movie) {
        System.out.println("片名\t\t\t主演\t\t\t时长\t\t评分\t\t票价\t\t余票数量\t\t\t放映时间");
        System.out.println(movie.getName() + "\t\t\t" + movie.getActor() + "\t\t" + movie.getTime()
                + "\t\t" + movie.getRating() + "\t\t" + movie.getPrice() + "\t\t" + movie.getTickCount() + "\t\t"
                + dateFormatter.format(movie.getStartTime()));
    }

    /**
     * (客户)展示全部影片信息
     */
    private static void showAllMovies() {
        System.out.println("=============展示全部商家排片信息=================");
        businessMap.forEach((business, movies) -> {
            System.out.println(business.getBusinessName() + "\t\t电话：" + business.getTel() + "\t\t地址:" + business.getAddress());
            System.out.println("\t\t\t片名\t\t\t主演\t\t时长\t\t评分\t\t票价\t\t余票数量\t\t放映时间");
            for (Movie movie : movies) {
                System.out.println("\t\t\t" + movie.getName() + "\t\t\t" + movie.getActor() + "\t\t" + movie.getTime()
                        + "\t\t" + movie.getRating() + "\t\t" + movie.getPrice() + "\t\t" + movie.getTickCount() + "\t\t"
                        + dateFormatter.format(movie.getStartTime()));
            }
        });
    }

    private static User findUser(String loginName) {
        for (User user : allUsers) {
            if (user.getLoginName().equals(loginName)) {
                return user;
            }
        }
        return null;
    }
}
