package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.app.model.ProgramingLangue;

@Repository
public interface ProgramingLangueRepository extends JpaRepository<ProgramingLangue, Long>{
 
	 @Query(value = "SELECT pl FROM ProgramingLangue pl WHERE pl.id=?1 ",nativeQuery = true)
	 public List<ProgramingLangue> allProgramingLangueId(Long id);

}
