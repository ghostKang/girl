package com.yuk.girl.repository;

import com.yuk.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Yuk on 2018/1/16.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer>{
    List<Girl> findByAge(Integer age);
}
