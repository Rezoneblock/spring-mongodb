package com.gordeev.mongodb.user.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserRequest {
    protected String firstName;
    protected String lastName;
}
