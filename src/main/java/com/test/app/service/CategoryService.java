package com.test.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.app.model.Category;

@Service
public interface CategoryService {

	public List<Category> listAllCategories();
}
