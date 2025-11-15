package com.gordeev.mongodb.user.controller;

import com.gordeev.mongodb.user.dto.request.CreateUserRequest;
import com.gordeev.mongodb.user.dto.response.UserResponse;
import com.gordeev.mongodb.user.entity.UserDoc;
import com.gordeev.mongodb.user.exception.ObjectParseException;
import com.gordeev.mongodb.user.exception.UserNotFoundException;
import com.gordeev.mongodb.user.repository.UserRepository;
import com.gordeev.mongodb.user.routes.UserRoutes;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserApiController {
    private final UserRepository userRepository;

    @GetMapping(UserRoutes.GET)
    public Page<UserResponse> search(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "") String query
    ) {
        Pageable pageable = PageRequest.of(page, size);

        UserDoc probe = UserDoc.builder().lastName(query).firstName(query).build();

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("lastName", match -> match.contains().ignoreCase())
                .withMatcher("firstName", match -> match.contains().ignoreCase());

        Example<UserDoc> example = Example.of(probe, exampleMatcher);

        Page<UserDoc> users = userRepository.findAll(example, pageable);

        return users.map(UserResponse::of);
    }

    @PostMapping(UserRoutes.CREATE)
    public UserResponse create(@RequestBody CreateUserRequest request) {
        UserDoc userDoc = UserDoc.builder()
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .build();

        userDoc = userRepository.save(userDoc);
        return UserResponse.of(userDoc);
    }

    @GetMapping(UserRoutes.BY_ID)
    public UserResponse findById(@PathVariable String id) {
        if(!ObjectId.isValid(id)) throw new ObjectParseException();

        UserDoc userDoc = userRepository.findById(new ObjectId(id)).orElseThrow(UserNotFoundException::new);
        return UserResponse.of(userDoc);
    }

}
