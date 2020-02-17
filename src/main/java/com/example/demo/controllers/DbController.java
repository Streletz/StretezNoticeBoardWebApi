package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repo.Category;
import com.example.demo.repo.CategoryRepository;
import com.example.demo.request.DbPostRequest;

import response.DbResponse;

@RestController
@RequestMapping("/db")
public class DbController {

	@Autowired
	private CategoryRepository repository;

	public DbController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping
	public DbResponse index() {
		List<Category> list = repository.findAll();
		DbResponse response = new DbResponse(list);
		return response;
	}

	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public void create(@RequestBody DbPostRequest request) {
		Category category = new Category(request.getCategoryName());
		repository.save(category);
	}

	@PostMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public void update(@RequestBody DbPostRequest request) {
		Category category = new Category(request.getId(), request.getCategoryName());
		repository.save(category);
	}

	@PostMapping(path = "/delete", consumes = "application/json", produces = "application/json")
	public void delete(@RequestBody DbPostRequest request) {
		Category category = new Category(request.getId(), request.getCategoryName());
		repository.delete(category);
	}

}
