package com.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScanTestController {

    public ScanTestController() {
        System.out.println("==========Injecting ScanTestController bean by Spring IOC=========");
    }

    @RequestMapping("/test")
    public String hello() {
        return "@SpringBootApplication defines an automatic Component Scan on the package com.app and all its sub-packages";
    }

}
