package com.example.demo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;

import com.example.demo.domain.PageInfo;
import com.example.demo.domain.Pen;
import com.example.demo.repository.PenRepository;

public class PenService{

	@Inject
	PenRepository penRepository;
	
	public Pen findById() {
		return penRepository.findById(1);
	}
	
	public List<Pen> findByNameMatch(String name){
		return penRepository.findByNameMatch(name);
		
	}
	
	public Integer deleteStormManageById(Integer id) {
		return penRepository.deleteStormManageById(id);
	}
	
	public Pen updateById(String name,Integer id) {
		return penRepository.updateById(name, id);
	}
	
	public Pen insertPen(String name,double price) {
		return penRepository.insert(name,price);
	}
	
	public List<Pen> findAllByIds(List<Integer> ids){
		return penRepository.findAllByIds(ids);
	}
	
	public List<Pen> findByNameOrderByIdDesc(String name, Integer id){
		return penRepository.findByNameOrderByIdDesc(name, id);
	}
	public Page<Pen> search(final Pen p, PageInfo page){
		return penRepository.search(p, page);
	}
}
