package org.parking.parkinglot.ejb;

import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.parking.parkinglot.common.CarDto;
import org.parking.parkinglot.common.UserDto;
import org.parking.parkinglot.entities.Car;
import org.parking.parkinglot.entities.User;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UserBean {
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<UserDto> findAllUsers() {
        LOG.info("find all users");
        try {
            List<UserDto> result;
            TypedQuery<User> typedQuery = entityManager.createQuery("select c from User c", User.class);

            List<User> users = typedQuery.getResultList();
            result = users.stream().map(UserDto::new).toList();

            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
}
