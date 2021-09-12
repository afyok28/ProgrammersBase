package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.ProgramingLangue;
import com.example.app.repository.ProgramingLangueRepository;

@Service
public class ProgramingLangueService {

	private ProgramingLangueRepository programingLangueRepository;

	@Autowired
	public void setProgramingLangueRepository(ProgramingLangueRepository programingLangueRepository) {
		this.programingLangueRepository = programingLangueRepository;
	}

	public ProgramingLangueService() {
		// TODO Auto-generated constructor stub
	}

	public List<ProgramingLangue> findAll() {
		return programingLangueRepository.findAll();
	}

	public boolean delete(Long id) {
		try {
			programingLangueRepository.delete(new ProgramingLangue(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean update(ProgramingLangue programingLangue) {
		if (programingLangue.getId() < 1) {
			if (programingLangueRepository.save(programingLangue) != null)
				return true;
			else
				return false;
		} else
			throw new IllegalArgumentException("id min value 1");

	}

	public boolean insert(ProgramingLangue programingLangue) {

		try {
			if (programingLangueRepository.save(programingLangue) != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

}
