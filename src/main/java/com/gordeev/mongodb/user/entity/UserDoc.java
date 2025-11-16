package com.gordeev.mongodb.user.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDoc {
    private ObjectId id;
    private String firstName;
    private String lastName;
}
