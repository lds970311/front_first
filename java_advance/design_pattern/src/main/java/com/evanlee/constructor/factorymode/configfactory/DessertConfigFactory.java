// Author : evan lee
// Time ： 2022-02-24  17:14
// FILENAME : DessertConfigFactory.java
// STATEMENT: 

package com.evanlee.constructor.factorymode.configfactory;

import com.evanlee.constructor.factorymode.abstractfactory.Dessert;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class DessertConfigFactory {
    private static final Map<String, Dessert> map = new HashMap<>();

    static {
        Properties properties = new Properties();
        InputStream inputStream = DessertConfigFactory.class.getClassLoader().getResourceAsStream("dessert.properties");
        try {
            properties.load(inputStream);
            Set<Object> set = properties.keySet();
            for (Object object : set) {
                String className = properties.getProperty((String) object);
                Class<?> name = Class.forName(className);
                Dessert o = (Dessert) name.getDeclaredConstructor().newInstance();
                map.put((String) object, o);
            }
        } catch (IOException | ClassNotFoundException | InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static Dessert getDessert(String name) {
        return map.get(name);
    }
}
