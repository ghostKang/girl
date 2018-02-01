package com.yuk.girl.dao;

import com.yuk.girl.domain.LearnResource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Yuk on 2018/1/23.
 */
@Component
@Mapper
public interface LearnMapper {
    List<LearnResource> queryList(Map<String, Object> params);
}
