package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.PageInfo;
import com.example.demo.domain.Pen;

public interface PenRepository  extends JpaRepository<Pen, Integer>,JpaSpecificationExecutor<Pen>{

	Pen findById(Integer id);
	
	//按名字查找
	@Query(value = "select name from Pen p where p.name like %:name%")
	List<Pen> findByNameMatch(@Param("name") String name);
	
	//添加
	//@Query(value="insert into Pen (name,price) values(?,?)")
	Pen insert(String name,double price);
	
	//按id删除
	@Query(value = "delete from Pen where id=?1 ")
	@Modifying
	Integer deleteStormManageById(@Param("id") Integer id);
	
	//修改
	@Query(value = "update Pen p set p.name=?1 where p.id=?3 ")
	@Modifying
	Pen updateById(@Param("name") String name, @Param("id") Integer id);
	
	//多个id查询
	List<Pen> findAllByIds(List<Integer> ids);
	
	//自定义条件查询
	List<Pen> findByNameOrderByIdDesc(String name, Integer id);
	
	public Page<Pen> search(final Pen p, PageInfo page);
}
