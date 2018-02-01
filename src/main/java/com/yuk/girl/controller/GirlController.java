package com.yuk.girl.controller;

import com.yuk.girl.domain.Girl;
import com.yuk.girl.domain.Result;
import com.yuk.girl.exception.GirlException;
import com.yuk.girl.handle.RequestHandle;
import com.yuk.girl.repository.GirlRepository;
import com.yuk.girl.service.GirlService;
import com.yuk.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Yuk on 2018/1/16.
 */
@RestController
public class GirlController {

    private static Logger logger = LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private Girl girl;

    @Autowired
    private GirlService girlService;

    @Autowired
    private ResultUtil resultUtil;

    @Autowired
    private RequestHandle requestHandle;

    /**
     * 查询所有列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            // 获取错误信息
            return resultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return resultUtil.success(0,"成功",girlRepository.save(girl));
    }

    /**,
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Result girlOne(@PathVariable("id") Integer id){
        girl = girlRepository.findOne(id);
        if(girl==null){
            return requestHandle.isNull();
        }else{
            return requestHandle.success(girl);
        }
    }

    /**
     * 根据age查询
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 根据id更新
     * @param id
     * @param age
     * @param cupSize
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("age") Integer age,
                           @RequestParam("cupSize") String cupSize){
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
       girlRepository.delete(id);
    }

    /**
     * 同时添加两条数据，测试事务
     */
    @PostMapping(value = "/girls/two")
    public void insertTwo(){
        girlService.insertTwo();
    }

    /**
     * 获取age进行判断
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/girls/getAge/{id}")
    public Result getAge(@PathVariable("id")Integer id)throws Exception{
        girl = girlRepository.findOne(id);
        if(girl!=null){
            Integer age = girl.getAge();
            if(age>15){
                return requestHandle.success(girl);
            }
            girlService.getAge(age);

        }
        return requestHandle.isNull();


    }
}
