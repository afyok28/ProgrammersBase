/* Created by Adam Jost on 09/13/2021 */
package com.pb.ProgrammersBase.resource;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "resources")
public class Resource {

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
    @Column(name = "resource_id")
    private Long id;
    
    @NotBlank(message = "cannot be empty")
    @Column(name = "resource_title")
    private String title;
    
    @Column(name = "resource_desc")
    private String desc;
    
    @NotBlank(message = "cannot be empty")
    @Column(name = "resource_body")
    private String body;
    
    @NotNull
    @Column(name = "resource_category_code")
    private Long categoryCode;
    
    @Column(name = "resource_link")
    private String link;
    
    
    @Column(name = "resource_image")
    private byte[] image;


    // reource id deleteted: image table all image delete. not extra code
    // imagee id deleted: image delete
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "image_id", foreignKey = @ForeignKey(name = "FK_Resorce_Image" ,value = ConstraintMode.CONSTRAINT))
    private List<Image> images;
    
  
    public Resource() {
    }

    public Resource(Long id, String title, String desc, String body,
                    Long categoryCode, String link, byte[] image) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.body = body;
        this.categoryCode = categoryCode;
        this.link = link;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(Long categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", body='" + body + '\'' +
                ", categoryCode=" + categoryCode +
                ", link='" + link + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}