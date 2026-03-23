import { UserDao } from './user-service/dao/userDao';
import { UserService } from './user-service/service/userService';
import { UserController } from './user-service/controller/userController';

function main() {
  const dao = new UserDao();
  const service = new UserService(dao);
  const controller = new UserController(service);

  controller.createUser(1, 'Soumya');

  const user = controller.getUser(1);
  console.log(user);

  const missing = controller.getUser(99);
  console.log(missing);
}

main();
