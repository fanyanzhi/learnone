package com.pine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class FirstController {
	

	@GetMapping("/{id}")
    public String queryById(@PathVariable("id") Long id) throws InterruptedException {
        if (id == 1) {
            // 休眠，触发熔断
            Thread.sleep(60);
        } else if (id == 2) {
            throw new RuntimeException("故意出错，触发熔断");
        }
        return "hhhh";
    }
	
	public static void main(String[] args) {
//		new Thread(() -> {System.out.println(111);}).start();
	}
}
