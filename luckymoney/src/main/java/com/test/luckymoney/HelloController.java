package com.test.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
//@Controller
//@ResponseBody
@RequestMapping("/hello")
public class HelloController {

//    @Value("${minMoney}")
//    private BigDecimal minMoney;
//
//    @Value("${description}")
//    private String description;

    @Autowired
    private LimitConfig limitConfig;

//    @ResponseBody
    @GetMapping("/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
//        return "说明：" + limitConfig.getDescription();
        return "id:" + myId;
//        return "index";
    }

//    @GetMapping("/hello2")
//    public String say2() {
//        return "index";
//    }

}
