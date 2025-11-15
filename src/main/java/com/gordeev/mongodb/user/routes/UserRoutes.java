package com.gordeev.mongodb.user.routes;

public class UserRoutes {
    private final static String ROOT = "/api/v1";

    public final static String GET_ALL = ROOT + "/users";

    public final static String CREATE = ROOT + "/user";

    public final static String BY_ID = ROOT + "/user/{id}";
}
