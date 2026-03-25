import User from '../model/user';

export class UserDao {
  private users: Map<number, User>;

  constructor() {
    this.users = new Map<number, User>();
  }

  save(user: User): User {
    try {
      this.users.set(user.uId, user);
    } catch (error) {
      console.error(`Can not save User ${user}`);
    }
    return user;
  }

  findById(id: number): User | unknown {
    return this.users.get(id) || null;
  }
}
