/* Created by Adam Jost on 09/13/2021 */
package com.pb.ProgrammersBase.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ref_categories")
public class Category {

    @Id
    @SequenceGenerator(
            name = "resource_category_sequence",
            sequenceName = "resource_category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "resource_category_sequence"
    )
    @Min(value = 0,message = "min value 0")
    @Column(name = "resource_category_code")
    private Long categoryCode;

    @NotNull
    @Size(max = 30,message = "max size 30")
    @Column(name = "programming_language",length = 30)
    private String programmingLanguage;

    @NotNull
    @Size(max = 50,message = "max size 50")
    @Column(name = "category_name",length = 50)
    private String categoryName;

    public Category(){}

    public Category(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public Category(String programmingLanguage, String categoryName) {
        this.programmingLanguage = programmingLanguage;
        this.categoryName = categoryName;
    }

    public Category(Long categoryCode, String programmingLanguage, String categoryName) {
        this.categoryCode = categoryCode;
        this.programmingLanguage = programmingLanguage;
        this.categoryName = categoryName;
    }

    public Long getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(Long categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ResourceCategory{" +
                "categoryCode=" + categoryCode +
                ", programmingLanguage='" + programmingLanguage + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
