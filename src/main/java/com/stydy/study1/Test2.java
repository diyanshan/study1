package com.stydy.study1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



// 定义接口
@Controller
public class Test2 {
    // 定义具体地址
    @GetMapping("/hello1")
    public String getMethodName() {
        return "hello word"; 
    }
    @GetMapping ("/getJson1")
    public String getJson() {
        // Map<String, String> mapObj = new HashMap<>();
        // mapObj.put("a", "123");
        // mapObj.put("b", "3");
        return "b";
    }
    
    
}
