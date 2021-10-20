/* Created by Adam Jost on 09/13/2021 */
package com.pb.ProgrammersBase.category;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pb.ProgrammersBase.resource.ResourceService;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ResourceService resourceService;
    
    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ResourceService resourceService) {
		super();
		this.categoryRepository = categoryRepository;
		this.resourceService = resourceService;
	}

/*
    public List<Category> findByProgrammingLanguage(String programmingLanguage) {

       return categoryRepository.findByProgrammingLanguage(programmingLanguage);
    }
    */

    public Category findByCategoryCode(Long categoryCode) {

        Optional<Category> categoryOptional = categoryRepository.findById(categoryCode);

        if (!categoryOptional.isPresent()) {
            throw new IllegalStateException("Category with category code "
                    + categoryCode + " does not exist");
        }

        return categoryOptional.get();
    }

    public void save(Category category) {

        category.setCategoryName(category.getCategoryName().trim());

        if (category.getCategoryName().length() == 0) {
            throw new IllegalStateException("Name field cannot be blank.");
        }

        categoryRepository.save(category);
    }

    @Transactional
    public void update(Long categoryCode, String categoryName) {

        Category category = categoryRepository.findById(categoryCode).orElseThrow(() ->
                new IllegalStateException("Category with category code " + categoryCode + " does not exist."));

        String trimmedName = categoryName.trim();

        if (trimmedName.length() != 0 && !Objects.equals(trimmedName, category.getCategoryName())) {
            category.setCategoryName(trimmedName);
        }
    }

    public void deleteAllByProgramingLangueName(final String programingLangueName)
    {
    	final Optional<Set<Long>> categoryCodes=categoryRepository.findByrPogramingLangue(programingLangueName);
    	for (Long categoryCode : categoryCodes.get()) {
    		resourceService.deleteAllByCategortId(categoryCode);
		}
    	categoryRepository.deleteByProgramingLangue(programingLangueName);   	
    }
    public void deleteById(Long categoryCode) {

    	resourceService.deleteAllByCategortId(categoryCode);
        categoryRepository.deleteById(categoryCode);
    }

    
    public Page<Category> findPaginated(int pageNum, int pageSize, String sortField,
                                        String sortDirection, String programmingLanguage) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);

        return this.categoryRepository.findByProgrammingLanguage(programmingLanguage, pageable);
    }
}
