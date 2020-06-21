package com.test.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.test.app.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	public List<Category> findAll();
}
