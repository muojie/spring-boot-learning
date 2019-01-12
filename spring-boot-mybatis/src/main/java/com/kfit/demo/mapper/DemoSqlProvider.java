package com.kfit.demo.mapper;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.kfit.demo.bean.Demo;

public class DemoSqlProvider {
	
	
	public String select7(Demo demo){
		StringBuffer sql = new StringBuffer("select *from demo where 1=1 ");
		if(demo.getName() != null){
			sql.append("and name=#{name} ");
		}
		if(demo.getEmail() != null){
			sql.append("and email=#{email} ");
		}
		return sql.toString();
	}
	
	public String select8(final Demo demo){
		return new SQL(){{
			SELECT("id,name");
			FROM("demo");
			//不需要where 1=1的代码，底层会自动判断.
			//WHERE()方法  ==  XML 使用<where>标签的有等同的效果.
			if(demo.getName() != null){
				WHERE("name=#{name}");
			}
			if(demo.getEmail() != null){
				WHERE("email=#{email}");
			}
		}}.toString();
	}
	
	public String save2(Demo demo){
		return new SQL(){{
			INSERT_INTO("demo");
			//多个写法.
			INTO_COLUMNS("name","email");
			INTO_VALUES("#{name}","#{email}");
			
			//条件写法.
//			if(demo.getName() != null){
//				VALUES("name","#{name}");
//			}
//			if(demo.getEmail() != null){
//				VALUES("email","#{email}");
//			}

		}}.toString();
	}
	
	public String update2(final Demo demo){
		return new SQL(){{
			UPDATE("demo");
			//条件写法.
			if(demo.getName() != null){
				SET("name=#{name}");
			}
			if(demo.getEmail() != null){
				SET("email=#{email}");
			}
		}}.toString();
	}
	
	
	public String delete2(Demo demo){
		return new SQL(){{
			DELETE_FROM("demo");
			WHERE("id=#{id}");
		}}.toString();
	}
	
	public String selectNoParams(){
		return new SQL(){{
			SELECT("*");
			FROM("demo");
		}}.toString();
	}
	
	
	public String selectParams1(){
		return new SQL(){{
			SELECT("*");
			FROM("demo");
			WHERE("id=#{id}");
		}}.toString();
	}
	
	public String selectParamsMore(final Map<String,Object> map){
		System.out.println(map);
		return new SQL(){{
			SELECT("*");
			FROM("demo");
			if(map.get("name") != null){
				WHERE("name=#{name}");
			}
			if(map.get("email") != null){
				WHERE("email=#{email}");
			}
		}}.toString();
	}
}
