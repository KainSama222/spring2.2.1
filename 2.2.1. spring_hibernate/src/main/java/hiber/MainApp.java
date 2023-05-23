package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
/*

      User user1 = new User("Vasya", "Vasechkin", "vasechkin@mail.io");
      User user2 = new User("Petya", "Sidorov", "sidorov@mail.io");
      User user3 = new User("Olga", "Petrova", "petrova@mail.io");
      User user4 = new User("Svetlana", "Ivanova", "ivanova@mail.io");

      Car car1 = new Car("Volvo", 9);
      Car car2 = new Car("BMW", 325);
      Car car3 = new Car("Sisuki", 4);
      Car car4 = new Car("Ladaa", 21014);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));
*/

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user + " " + user.getCar());
      }

      System.out.println(userService.getUserByCar("BMW", 325));

      context.close();
   }
}
