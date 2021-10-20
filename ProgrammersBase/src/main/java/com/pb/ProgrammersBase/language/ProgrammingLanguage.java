/* Created by Adam Jost on 09/13/2021 */
package com.pb.ProgrammersBase.language;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "programming_language",indexes = @Index(columnList = "pl_name",unique = true))
public class ProgrammingLanguage {

    @Id
    @SequenceGenerator(
            name = "programming_language_sequence",
            sequenceName = "programming_language_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "programming_language_sequence"
    )
    @Min(value = 0,message = "min value 0")
    @Column(name = "pl_id")
    private Long id;

    @NotBlank(message = "cannot be empty")
    @Size(max = 30,message = "max size 30")
    @Column(name = "pl_name",length = 30)
    private String name;

    public ProgrammingLanguage() {}

    public ProgrammingLanguage(String name) {
        this.name = name;
    }

    public ProgrammingLanguage(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProgrammingLanguage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
