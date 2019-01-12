package com.kfit.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.kfit.demo.bean.Demo;
import com.kfit.demo.enums.SexEnum;

import scala.annotation.meta.param;


/**
 * 解决no found问题：
 * ------------------------
 * 1、使用@Mapper注解. --- 未来是需要每一个Mapper接口类都需要添加。
 * 2、使用统一的方式，统一注入，使用@MapperScan，是在App.java类进行配置。
 * 
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2017年8月16日
 */
///@Mapper : 已经使用@MapperScan进行包路径的指定.
public interface DemoMapper {
	
	/**
	 * 这里的话，
	 * 1、使用 @Insert声明一条添加数据的SQL语句;
	 * 2、使用 #{}进行变量的绑定。
	 * @param demo
	 * @return
	 */
	@Insert("insert into demo(name) values(#{name})")
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	public int save(Demo demo);
	
	/**
	 * 修改语句.
	 * @param demo
	 * @return
	 */
	@Update("update demo set name=#{name} where id=#{id}")
	public int update(Demo demo);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@Delete("delete from demo where id=#{id}")
	public int delete(int id);
	
	@Select("select *from demo")
	public List<Demo> selectAll();
	
	@Select("select *from demo where id=#{id}")
	@Results({
		@Result(property="updateTime",column="update_time"),
		@Result(property="sexEnum",column="sex_enum",javaType=SexEnum.class)
	})
	public Demo selectById(int id);
	
	@Select("select *from demo where name=#{name} and email=#{email}")
	public List<Demo> select1(@Param("name")String name,@Param("email")String email);
	
	/**
	 * #{} 和 ${}的区别？
	 */
	
	@Select("select *from demo where name=#{name}")
	public List<Demo> selectByName(String name);
	
	@Select("select *from demo where name='${name}'")
	public List<Demo> selectByName2(@Param("name")String name);
	
	//例1：查询Demo表id=X的记录。
	@Select("select *from where id=#{id}")
	public Demo select3(int id);
	
	//例2：查询Demo表的数据，并且按照指定字段id或者name降序排列。
	//select *from demo order by id/name{参数参入}
	
	@Select("select *from demo order by ${orderField}")//原样替换.
	public Demo select4(String orderField);
	/*
	 * 使用了#{}符号的话，那么会被解析为这样的语句：（id）
	 * select *from demo order by 'id'
	 * 
	 */
	
	//例3：查询Demo表的数据，并且按照指定字段id或者name升序或者降序排列。
	@Select("select *from demo order by ${orderField} ${ascOrDesc}")//原样替换.
	public Demo select5(@Param("orderField")String orderField,@Param("ascOrDesc")String ascOrDesc);
	
	
	@Select("<script>select *from demo where "
			+ "1=1 "
			+ " <if test='name != null'>and name=#{name} </if>"
			+ " <if test='email != null'> and email=#{email}</if>"
			+ "</script>")
	public List<Demo> select6(Demo demo);
	
	@SelectProvider(type=DemoSqlProvider.class,method="select7")
	public List<Demo> select7(Demo demo);
	
	@SelectProvider(type=DemoSqlProvider.class,method="select8")
	public List<Demo> select8(Demo demo);
	
	@InsertProvider(type=DemoSqlProvider.class,method="save2")
	public List<Demo> save2(Demo demo);
	
	@UpdateProvider(type=DemoSqlProvider.class,method="update2")
	public List<Demo> update2(Demo demo);
	
	@DeleteProvider(type=DemoSqlProvider.class,method="delete2")
	public List<Demo> delete2(Demo demo);
	
	@SelectProvider(type=DemoSqlProvider.class,method="selectNoParams")
	public List<Demo> selectNoParams();
	
	@SelectProvider(type=DemoSqlProvider.class,method="selectParams1")
	public List<Demo> selectParams1(int id);
	
	@SelectProvider(type=DemoSqlProvider.class,method="selectParamsMore")
	public List<Demo> selectParamsMore(@Param("name")String name,@Param("email")String email);
	
	//修改状态..
	//public int updateStatus(int id,int status);
}
