package com.yuk.girl.controller;

import com.github.pagehelper.PageInfo;
import com.yuk.girl.domain.LearnResource;
import com.yuk.girl.dto.PageResult;
import com.yuk.girl.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yuk on 2018/1/23.
 */
@RestController
@RequestMapping("/learn")
public class LearnController {

    @Autowired
    private LearnService learnService;

    @RequestMapping(value = "/queryList",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public PageResult queryLearnList(HttpServletRequest request , HttpServletResponse response) {
        String pageNum = request.getParameter("pageNum"); // 当前页数
        String pageSize = request.getParameter("pageSize"); // 每页显示行数
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        Map<String, Object> params = new HashMap<>();
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);
        params.put("author", author);
        params.put("title", title);
        List<LearnResource> learnList = learnService.queryList(params);
        PageInfo<LearnResource> pageInfo = new PageInfo(learnList);
        /*ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("learnList", learnList);*/
        PageResult pageResult = new PageResult(true,pageInfo.getTotal(),learnList);
        return pageResult;
    }

    @GetMapping(value = "/test")
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView("layui");
        return modelAndView;
    }

    @GetMapping(value = "/test2")
    public ModelAndView test2(){
        ModelAndView modelAndView = new ModelAndView("vue");
        return modelAndView;
    }

    @GetMapping(value = "/query")
    public ModelAndView test4(){
        ModelAndView modelAndView = new ModelAndView("pagination");
        return modelAndView;
    }

}
