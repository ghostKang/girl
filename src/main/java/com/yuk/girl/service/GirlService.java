package com.yuk.girl.service;

import com.yuk.girl.domain.Girl;
import com.yuk.girl.enums.ResultEnum;
import com.yuk.girl.exception.GirlException;
import com.yuk.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Yuk on 2018/1/16.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setAge(21);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        //int a = 1/0;
        Girl girlB = new Girl();
        girlB.setAge(21);
        girlB.setCupSize("B");
        girlRepository.save(girlB);

    }

    public void getAge(Integer age)throws Exception{
        if(age<=10){
            throw new GirlException(ResultEnum.primary);
        }else if(age>10 && age<15){
            throw new GirlException(ResultEnum.high);
        }
        throw new GirlException(ResultEnum.success);
    }
}
