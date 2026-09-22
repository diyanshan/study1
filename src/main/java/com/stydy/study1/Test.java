package com.stydy.study1;

import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



// 定义接口
@RestController 
@RequestMapping ("/user")
public class Test {
    // 定义具体地址
    @GetMapping("/hello")
    public String getMethodName() {
        return "hello word"; 
    }
    @PostMapping ("/getJson")
    public User getJson() {
        // Map<String, String> mapObj = new HashMap<>();
        // mapObj.put("a", "123");
        // mapObj.put("b", "3");
        return new User();
    }
    
    
}
