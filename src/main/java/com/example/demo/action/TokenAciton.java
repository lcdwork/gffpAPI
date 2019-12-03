package com.example.demo.action;

import com.example.demo.tools.HttpTools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenAciton {
    @RequestMapping("/getToken")
    public String getToken(){
        String url = "http://211.160.73.240:19018/gffp/pv/data/gettoken";

        String res = HttpTools.postData(url);
        System.out.println(res);
        return res;
    }
}
