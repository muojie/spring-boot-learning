package com.kfit.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.kfit.demo.bean.Demo;
import com.kfit.demo.mapper.DemoMapper;
import com.kfit.demo.service.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	private DemoService demoService;
	@Autowired
	private DemoMapper demoMapper;//实际开发，不建议这么写，这里只是为了测试方便。
	
	@GetMapping("/save")
	public Demo save(Demo demo){
		//保存成功的条数...并不是主键id.
		int rs = demoService.save(demo);
		System.out.println("rs-->"+rs+"-->id="+demo.getId());
		return demo;
	}
	
	// http://127.0.0.1:8080/update?id=32&name=Andy
	@GetMapping("/update")
	public int update(Demo demo){
		return demoService.update(demo);
	}
	
	// http://127.0.0.1:8080/delete?id=32
	@GetMapping("/delete")
	public int delete(int id){
		return demoService.delete(id);
	}
	
	
	@GetMapping("/selectAll")
	public List<Demo> selectAll(int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return demoService.selectAll();
	}
	
	
	@GetMapping("/selectById")
	public Demo selectById(int id){
		return demoService.selectById(id);
	}
	
	@GetMapping("/select1")
	public List<Demo> select1(String name,String email){
		return demoService.select1(name,email);
	}
	
	@GetMapping("/selectByName")
	public List<Demo> selectByName(String name){
		return demoService.selectByName(name);
	}
	
	@GetMapping("/selectByName2")
	public List<Demo> selectByName2(String name){
		return demoService.selectByName2(name);
	}
	
	@GetMapping("/select6")
	public List<Demo> select6(Demo demo){
		return demoMapper.select6(demo);
	}
	
	@GetMapping("/select7")
	public List<Demo> select7(Demo demo){
		return demoMapper.select7(demo);
	}
	
	@GetMapping("/select8")
	public List<Demo> select8(Demo demo,int pageNum){
		PageHelper.startPage(pageNum, 2);
		return demoMapper.select8(demo);
	}
	
	@GetMapping("/selectNoParams")
	public List<Demo> selectNoParams(){
		return demoMapper.selectNoParams();
	}
	
	@GetMapping("/selectParams1")
	public List<Demo> selectParams1(int id){
		return demoMapper.selectParams1(id);
	}
	
	@GetMapping("/selectParamsMore")
	public List<Demo> selectParamsMore(String name,String email){
		return demoMapper.selectParamsMore(name,email);
	}
}
