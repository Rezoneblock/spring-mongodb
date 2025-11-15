package com.gordeev.mongodb.user.dto.response;

import com.gordeev.mongodb.user.entity.UserDoc;
import com.gordeev.mongodb.user.repository.UserRepository;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String id;
    private String firstName;
    private String lastName;

    public static UserResponse of(UserDoc userDoc) {
        return UserResponse.builder()
                .id(userDoc.getId().toString())
                .firstName(userDoc.getFirstName())
                .lastName(userDoc.getLastName())
                .build();
    }
}
