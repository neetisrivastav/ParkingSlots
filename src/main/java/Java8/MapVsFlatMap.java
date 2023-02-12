package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMap {
    public static void main(String[] args) {


        List<User> user = Stream.of(
                new User("Neeti", "94512344", Arrays.asList("abc@gmail.com", "default@gmail.com", "xyz@gmail.com")),
                new User("Anurag", "94512344", Arrays.asList("abc@gmail.com", "default@gmail.com", "xyz@gmail.com")),
                new User("Ankita", "94512344", Arrays.asList("abc@gmail.com", "default@gmail.com", "xyz@gmail.com")),
                new User("Amit", "1000", Arrays.asList("abc@gmail.com", "default@gmail.com", "xyz@gmail.com")),
                new User("Priti", "2000", Arrays.asList("abc@gmail.com", "default@gmail.com", "xyz@gmail.com")),
                new User("Neeti", "1000", Arrays.asList("abc@gmail.com", "default@gmail.com", "xyz@gmail.com")),
                new User("Anurag", "1000", Arrays.asList("abc@gmail.com", "default@gmail.com", "xyz@gmail.com")),
                new User("Neeti", "2000", Arrays.asList("abc@gmail.com", "default@gmail.com", "xyz@gmail.com"))
        ).collect(Collectors.toList());
        List<String> collect = user.stream().map(User::getPhoneNumber).collect(Collectors.toList());
        System.out.println(collect);
        //flat Map

        List<String> collect1 = user.stream().flatMap(users -> users.getEmail().stream()).collect(Collectors.toList());
        System.out.println(collect1);


    }
}

class User{
    private String name;
    private String phoneNumber;
    private List<String> email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public User(String name, String phoneNumber, List<String> email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email=" + email +
                '}';
    }
}