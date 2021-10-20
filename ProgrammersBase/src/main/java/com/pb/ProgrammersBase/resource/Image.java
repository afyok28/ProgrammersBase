package com.pb.ProgrammersBase.resource;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "IMAGE")
public class Image {

    @Id
    @SequenceGenerator(
            name = "resource_sequence",
            sequenceName = "resource_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "resource_sequence"
    )
    @Min(value = 0,message = "min value 0")
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "IMAGE")
    @Lob
    private byte[] image;
    
    
	public Image() {
		// TODO Auto-generated constructor stub
	}

}
