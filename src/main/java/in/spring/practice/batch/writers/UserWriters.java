package in.spring.practice.batch.writers;

import in.spring.practice.batch.model.User;
import in.spring.practice.batch.repositories.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserWriters implements ItemWriter<User> {

    @Autowired
    private UserRepository repository;

    @Override
    public void write(List<? extends User> list) throws Exception {
        repository.saveAllAndFlush(list);
    }
}
