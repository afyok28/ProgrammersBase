/* Created by Adam Jost on 09/13/2021 */
package com.pb.ProgrammersBase.category;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Page<Category> findByProgrammingLanguage(String programmingLanguage, Pageable pageable);
    
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from Category c WHERE c.programmingLanguage =?1 ",nativeQuery = false)
    public void deleteByProgramingLangue(String programmingLanguage);
    
    @Query(value = "select c.categoryCode from Category c WHERE c.programmingLanguage =?1 ",nativeQuery = false)
    public Optional<Set<Long>> findByrPogramingLangue(String programmingLanguage);


}
