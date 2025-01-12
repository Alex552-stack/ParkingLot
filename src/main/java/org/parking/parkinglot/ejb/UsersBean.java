package org.parking.parkinglot.ejb;

import org.parking.parkinglot.common.UserDto;
import org.parking.parkinglot.entities.User;
import org.parking.parkinglot.entities.UserGroup;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UsersBean {
    private static final Logger LOG = Logger.getLogger(UsersBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;
    @Inject
    PasswordBean passwordBean;

    public List<UserDto> findAllUsers() {
        LOG.info("findAllUsers");
        try {
            TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
            List<User> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserDto> copyUsersToDto(List<User> users) {
        LOG.info("copyUsersToDto");
        List<UserDto> userDtos = new ArrayList<UserDto>();
        for (User user : users) {
            UserDto userDto = new UserDto(
                    user.getId(),
                    user.getUsername(),
                    user.getCars(),
                    user.getEmail()
            );
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public void createUser(String username, String email, String password,
                           Collection<String> groups) {
        LOG.info("createUser");
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(passwordBean.convertToSha256(password));
        entityManager.persist(newUser);
        assignGroupsToUser(username, groups);
    }

    private void assignGroupsToUser(String username, Collection<String>
            groups) {
        LOG.info("assignGroupsToUser");
        for (String group : groups) {
            UserGroup userGroup = new UserGroup();
            userGroup.setUsername(username);
            userGroup.setUserGroup(group);
            entityManager.persist(userGroup);
        }
    }

    public Collection<String> findUsernamesByUserIds(Collection<Long> userIds) {
        List<String> usernames = entityManager.createQuery("SELECT u.username FROM User u WHERE u.id IN :userIds", String.class)
                .setParameter("userIds", userIds)
                .getResultList();
        return usernames;
    }

    public User findUserById(Long userId) {
        LOG.info("findUserById");
        return entityManager.find(User.class, userId);
    }

    public void updateUserWithoutPassword(Long userId, String username, String email) {
        LOG.info("updateUserWithoutPassword");
        User user = entityManager.find(User.class, userId);
        if (user != null) {
            user.setUsername(username);
            user.setEmail(email);
            entityManager.merge(user);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    public void updateUserWithPassword(Long userId, String username, String email, String password) {
        LOG.info("updateUserWithPassword");
        User user = entityManager.find(User.class, userId);
        if (user != null) {
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(passwordBean.convertToSha256(password));
            entityManager.merge(user);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }
}
