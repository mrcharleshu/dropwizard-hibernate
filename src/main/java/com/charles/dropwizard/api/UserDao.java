package com.charles.dropwizard.api;

import com.charles.dropwizard.model.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDao extends AbstractDAO<User> {

    public UserDao(SessionFactory factory) {
        super(factory);
    }

    public User findById(Long id) {
        return get(id);
    }

    public long create(User person) {
        return persist(person).getId();
    }

    @Override
    protected List<User> list(Query query) throws HibernateException {
        return super.list(query);
    }

    @Override
    protected List<User> list(Criteria criteria) throws HibernateException {
        return super.list(criteria);
    }
}  