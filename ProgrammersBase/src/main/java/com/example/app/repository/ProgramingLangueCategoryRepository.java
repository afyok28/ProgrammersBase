package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.app.model.PrograminLangueCategory;

@Repository
public interface ProgramingLangueCategoryRepository extends JpaRepository<PrograminLangueCategory, Long> {
	
	 @Query(value = "SELECT plc FROM PrograminLangueCategory plc WHERE plc.programingLangue.id=?1 ",nativeQuery = false)
	 public  List<PrograminLangueCategory> findProgramingLangueCategoryByPlId(Long plId);

}
