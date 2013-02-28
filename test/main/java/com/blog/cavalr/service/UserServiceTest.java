package com.blog.cavalr.service;

import com.blog.cavalr.entity.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/hibernateContext.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    private final String userName = "user01";

    @After
    public void tearDown() throws Exception {
        userService.deleteUser(userName);
    }

    @Test
    public void testSaveUser() throws Exception {
        User user = createUser();
        User found = userService.findByUserName(user.getUserName());
        assertEquals(user, found);
    }

    private User createUser() {
        User user = new User(userName, "firstName", "lastName", "password");
        user.setCreatedOn(new Date());
        userService.saveUser(user);
        return user;
    }

    @Test
    public void testSearchUser() throws Exception {
        createUser();
        List<User> users = userService.findUsers("user01");
        assertEquals(1, users.size());
        assertEquals("user01", users.iterator().next().getUserName());
    }

    @Test
    public void testDeleteUser() throws Exception {
        createUser();
        assertNotNull(userService.findByUserName("user01"));
        userService.deleteUser("user01");
        assertNull(userService.findByUserName("user01"));
    }

    @Test
    public void testUpdateUser() throws Exception {
        createUser();
        User user01 = userService.findByUserName("user01");
        assertNotNull(user01);
        assertEquals("firstName", user01.getFirstName());
        assertEquals("lastName", user01.getLastName());

        user01.setFirstName("newFirstName");
        user01.setLastName("newLastName");
        userService.saveUser(user01);

        User found = userService.findByUserName("user01");
        assertNotNull(found);
        assertEquals("newFirstName", found.getFirstName());
        assertEquals("newLastName", found.getLastName());



    }
}
