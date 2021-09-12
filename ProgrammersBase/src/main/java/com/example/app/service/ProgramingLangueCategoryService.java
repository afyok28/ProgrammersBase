package com.example.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.PrograminLangueCategory;
import com.example.app.repository.ProgramingLangueCategoryRepository;
@Service
public class ProgramingLangueCategoryService {

	private ProgramingLangueCategoryRepository programingLangueCategoryRepository;

	@Autowired
	public void setProgramingLangueCategoryRepository(ProgramingLangueCategoryRepository programingLangueCategoryRepository) {
		this.programingLangueCategoryRepository = programingLangueCategoryRepository;
	}

	public ProgramingLangueCategoryService() {
		// TODO Auto-generated constructor stub
	}

	public List<PrograminLangueCategory> findAll() {
		return programingLangueCategoryRepository.findAll();
	}
	
	public List<PrograminLangueCategory> findProgramingLangueCategoryByPlId(Long plId) {
		return programingLangueCategoryRepository.findProgramingLangueCategoryByPlId(plId);
	}
	public boolean delete(Long id) {
		try {
			programingLangueCategoryRepository.delete(new PrograminLangueCategory(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean update(PrograminLangueCategory programinLangueCategory) {
		if (programinLangueCategory.getId() < 1) {
			if (programingLangueCategoryRepository.save(programinLangueCategory) != null)
				return true;
			else
				return false;
		} else
			throw new IllegalArgumentException("id min value 1");
	}

	public boolean insert(PrograminLangueCategory programinLangueCategory) {

		try {
			if (programingLangueCategoryRepository.save(programinLangueCategory) != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

}
