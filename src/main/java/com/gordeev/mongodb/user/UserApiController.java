package com.gordeev.mongodb.user;

import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserApiController {
    private final UserRepository userRepository;

    @GetMapping("/")
    public UserDoc test() {
        List<UserDoc> findTest = userRepository.findByFirstName("TestName");
        List<UserDoc> findTestList = userRepository.findByLastName("TestNameLast");


        UserDoc test1 = UserDoc.builder()
                .id(new ObjectId())
                .firstName("TestName")
                .lastName("TestNameLast")
                .build();
        userRepository.save(test1);
        return test1;
    }
}
