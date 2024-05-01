package com.msk.joblisting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "JobPost")
public class Post {

    @Id
    private String id;
    private String profile;
    private String desc;
    private int exp;
    private String[] techs;

}
