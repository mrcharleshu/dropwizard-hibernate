package com.charles.dropwizard.resources;

import com.charles.dropwizard.api.UserDao;
import com.charles.dropwizard.model.User;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path(value = "user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private UserDao UserDao;

    public UserResource(UserDao dao) {
        this.UserDao = dao;
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("findOne")
    public User findOne(@QueryParam("id") Long id) {
        // curl http://localhost:8080/user/findOne
        return UserDao.findById(id);
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("create")
    public Integer create(@QueryParam("name") String name,
                          @QueryParam("age") Integer age,
                          @QueryParam("email") String email,
                          @QueryParam("password") String password) {
        // curl http://localhost:8080/user/create?name=Lily&age=23&email=23123213@qq.com&password=123456
        return UserDao.create(new User(name, age, email, password));
    }
}