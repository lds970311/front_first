// Author : evan lee
// Time ： 2022-01-03  20:49
// FILENAME : sport.java

/*
我们现在有乒乓球运动员和篮球运动员，乒乓球教练和篮球教练。
  为了出国交流，跟乒乓球相关的人员都需要学习英语。
  请用所学知识分析，这个案例中有哪些具体类，哪些抽象类，哪些接口，并用代码实现
 */

package com.codewolf.java.oop.exec;

class Man {
    private String name;
    private String id;

    public Man(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

interface IStudy {
    void studyEnglish();
}

abstract class SportMan extends Man {

    public SportMan(String name, String id) {
        super(name, id);
    }

    public abstract void learn();
}

abstract class Coach extends Man {

    public Coach(String name, String id) {
        super(name, id);
    }

    public abstract void teach();
}

class PinPangSportMan extends SportMan implements IStudy {

    public PinPangSportMan(String name, String id) {
        super(name, id);
    }

    @Override
    public void learn() {
        System.out.println("learn pin pang");
    }

    @Override
    public void studyEnglish() {
        System.out.println(" PinPangSportMan stydy English");
    }
}

class BasketBallSportMan extends SportMan implements IStudy {

    public BasketBallSportMan(String name, String id) {
        super(name, id);
    }

    @Override
    public void learn() {
        System.out.println("learn basketBall");
    }

    @Override
    public void studyEnglish() {
        System.out.println("BasketBallSportMan stydy English");
    }
}

class PinPangCoach extends Coach {

    public PinPangCoach(String name, String id) {
        super(name, id);
    }

    @Override
    public void teach() {
        System.out.println("teach pinpang");
    }
}

class BasketBallCoach extends Coach {

    public BasketBallCoach(String name, String id) {
        super(name, id);
    }

    @Override
    public void teach() {
        System.out.println("teach basketball");
    }
}

public class sport {
    public static void main(String[] args) {
        SportMan sam = new PinPangSportMan("sam", "001");
        // sam.studyEnglish();
        sam.learn();
        ((PinPangSportMan) sam).studyEnglish();
        Coach coach = new BasketBallCoach("tommy", "1351");
        coach.teach();
    }
}
