package com.yuk.girl.service;

import com.yuk.girl.domain.LearnResource;

import java.util.List;
import java.util.Map;

/**
 * Created by Yuk on 2018/1/23.
 */
public interface  LearnService {

    List<LearnResource> queryList(Map<String, Object> params);
}
