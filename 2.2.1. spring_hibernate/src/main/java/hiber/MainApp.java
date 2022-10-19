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
      User userO = new User("Moby","Mory", "moby@mail.ru");
      User userT = new User("Roby","Gory", "roby@mail.ru");
      Car carO = new Car("BMW",4);
      Car carT = new Car("Audi",6);
      userService.add(carO);
      userService.add(carT);
      List<Car> cars = userService.listCars();
      userO.setCar(cars.get(0));
      userT.setCar(cars.get(1));
      userService.add(userO);
      userService.add(userT);
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+ user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
      }
      System.out.println(userService.userHasCar(cars.get(0)));
      context.close();

   }
}

