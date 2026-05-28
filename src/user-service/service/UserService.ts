import { UserDao } from '../dao/userDao';
import User from '../model/user';

export class UserService {
  constructor(private userDao: UserDao) {}

  createUser(id: number, name: string): User {
    const user: User = { uId: id, uName: name };
    this.userDao.save(user);
    return user;
  }

  getUser(id: number): User {
    const user = this.userDao.findById(id) as User;

    if (!user) {
      throw new Error('User not found');
    }

    return user;
  }
}
