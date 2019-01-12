package com.kfit.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.kfit.demo.bean.Cat;

/**
 * Repository -- 是接口 ，不是class.
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2016年12月18日
 */
public interface CatRepository extends CrudRepository<Cat, Integer>{

}
