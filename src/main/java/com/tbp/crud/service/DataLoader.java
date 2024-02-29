
package com.tbp.crud.service;

import com.tbp.crud.dao.TaskStateRepository;
import com.tbp.crud.dao.UserRepository;
import com.tbp.crud.entity.TaskState;
import com.tbp.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TaskStateRepository taskStateRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, TaskStateRepository taskStateRepository) {
        this.userRepository = userRepository;
        this.taskStateRepository = taskStateRepository;
    }

    @Override
    public void run(String... args) {
        loadUsers();
        loadTaskStates();
    }

    private void loadUsers() {

        if (userRepository.count() == 0) {
            User user1 = new User(1L, "nexus1", "spa1", "nexspa1", encodePassword("1234"));
            User user2 = new User(2L, "nexus2", "spa2", "nexspa2", encodePassword("5678"));
            userRepository.saveAll(List.of(user1, user2));
        }
    }
    private void loadTaskStates() {
        if (taskStateRepository.count() == 0) {
            TaskState state1 = new TaskState(1L,"To Do");
            TaskState state2 = new TaskState(2L,"In Progress");
            TaskState state3 = new TaskState(3L,"Completed");
            taskStateRepository.saveAll(List.of(state1, state2,state3));
        }
    }

    private String encodePassword(String value){
        int strength = 10; // work factor of bcrypt
        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(strength, new SecureRandom());
        return bCryptPasswordEncoder.encode(value);
    }
}
