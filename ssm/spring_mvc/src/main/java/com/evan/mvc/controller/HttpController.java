// Author : evan lee
// Time ： 2022-02-08  21:59
// FILENAME : HttpController.java
// STATEMENT: HttpMessageConverter对象

package com.evan.mvc.controller;

import com.evan.mvc.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/http")
public class HttpController {

    @PostMapping("/a")
    public String getBody(@RequestBody String body) {
        System.out.println(body);
        return "index";
   /*     Content-Disposition: form-data; name="username"

        123123
                ----------------------------868926026092744785658691
        Content-Disposition: form-data; name="password"

        hehe
    }*/
    }

    @GetMapping("/emp")
    @ResponseBody
    public Employee getEmployee() {
        return new Employee(1, "evan", "evan@gmail.com", 1);
        /*
          {
              "id": 1,
              "lastName": "evan",
              "email": "evan@gmail.com",
              "gender": 1
          }
         */
    }
}
