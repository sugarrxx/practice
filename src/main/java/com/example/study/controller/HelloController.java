package com.example.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:lixiaoxiang@vpgame.cn">lxx</a>
 * @date 2019-08-19
 */
@RestController("/hello")
public class HelloController {

    @GetMapping
    public Object hello() {

        return "this is worked";
    }

}
