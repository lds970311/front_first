// Author : evan lee
// Time ： 2022-02-28  16:41
// FILENAME : Phone.java
// STATEMENT: 

package com.evanlee.construct.constructor;

public class Phone {

    private String cpu;
    private String screen;
    private String memory;
    private String mainboard;

    private Phone(Builder builder) {
        cpu = builder.cpu;
        screen = builder.screen;
        memory = builder.memory;
        mainboard = builder.mainboard;
    }

    public static final class Builder {
        private String cpu;
        private String screen;
        private String memory;
        private String mainboard;

        public Builder() {
        }

        public Builder cpu(String val) {
            cpu = val;
            return this;
        }

        public Builder screen(String val) {
            screen = val;
            return this;
        }

        public Builder memory(String val) {
            memory = val;
            return this;
        }

        public Builder mainboard(String val) {
            mainboard = val;
            return this;
        }

        public Phone build() {
            return new Phone(this);
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", mainboard='" + mainboard + '\'' +
                '}';
    }
}

class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .mainboard("华硕")
                .memory("金士顿")
                .screen("三星")
                .build();
        System.out.println(phone);
    }
}