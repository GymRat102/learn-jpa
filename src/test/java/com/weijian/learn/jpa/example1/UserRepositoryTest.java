package com.weijian.learn.jpa.example1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 由于没有引入H2依赖，这里需要额外配置
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = userRepository.save(User.builder()
                .name("jackxx")
                .email("123456@126.com")
                .build());
        assertNotNull(user);

        List<User> users = userRepository.findAll();
        System.out.println(users);
        assertNotNull(users);
    }

}