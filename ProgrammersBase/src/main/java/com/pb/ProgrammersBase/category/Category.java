/* Created by Adam Jost on 09/13/2021 */
package com.pb.ProgrammersBase.category;

import javax.persistence.*;

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
    @Column(name = "resource_category_code")
    Long categoryCode;

    @Column(name = "programming_language")
    String programmingLanguage;

    @Column(name = "category_name")
    String categoryName;

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
