package com.stydy.study1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



// 定义接口
@Controller
public class Test2 {
    // 定义具体地址
    // @Controller 默认把返回值当"视图名"去解析模板，返回纯文本必须加 @ResponseBody，
    // 否则会去找名为 "hello word" 的模板，报 500
    @GetMapping("/hello1")
    @ResponseBody
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
