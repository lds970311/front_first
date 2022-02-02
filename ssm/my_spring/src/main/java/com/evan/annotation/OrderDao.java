package com.evan.annotation;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
    void addOrder();
}
