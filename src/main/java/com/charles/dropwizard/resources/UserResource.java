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

@Path(value = "person")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private UserDao UserDao;

    public UserResource(UserDao dao) {
        this.UserDao = dao;
    }

    @GET
    @Timed
    @UnitOfWork
    public User sayHello(@QueryParam("id") Long id) {
        return UserDao.findById(id);
    }
}  