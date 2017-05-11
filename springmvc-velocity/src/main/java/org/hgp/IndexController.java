package org.hgp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by hgp on 2017/3/27.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("name","World");

        // 循环
        List<Map<String,Object>> list = new ArrayList<>();
        for(int i=0;i<10;i++ ) {
            Map<String,Object> m = new HashMap<>();
            m.put("name","name"+i);
            m.put("password","password"+i);
            m.put("age",10+i);
            m.put("date",new Date());

            list.add(m);
        }

        model.addAttribute("list",list);

        return "index";
    }


}
