package com.yuk.girl.service.impl;

import com.github.pagehelper.PageHelper;
import com.yuk.girl.dao.LearnMapper;
import com.yuk.girl.domain.LearnResource;
import com.yuk.girl.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Yuk on 2018/1/23.
 */
@Service
public class LearnServiceImpl implements LearnService {

    @Autowired
    private LearnMapper learnMapper;

    @Override
    public List<LearnResource> queryList(Map<String, Object> params){
        PageHelper.startPage(Integer.parseInt(params.get("pageNum").toString()), Integer.parseInt(params.get("pageSize").toString()));
        return this.learnMapper.queryList(params);
    }
}
