package in.spring.practice.batch.processors;

import in.spring.practice.batch.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UserProcessor implements ItemProcessor {


    public enum USER_TYPE {


        STUDENT(1,"Student"), EMPLOYEE(2,"Employee");

        private int id;
        private String value;
        USER_TYPE(int id, String value) {
            this.id = id;
            this.value = value;
        }
        public static USER_TYPE getUserType(int id) {
            return Arrays.stream(values()).filter(value -> value.id == id).findFirst().get();
        }
    }
    @Override
    public Object process(Object input) throws Exception {
        User user = (User) input;
        USER_TYPE userType = USER_TYPE.getUserType(Integer.valueOf(user.getUserType()));
        user.setUserType(userType.value);
        return user;
    }
}
