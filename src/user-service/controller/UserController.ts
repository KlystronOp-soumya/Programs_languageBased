import { UserService } from '../service/UserService';

export class UserController {
  constructor(private service: UserService) {}

  createUser(id: number, name: string) {
    return this.service.createUser(id, name);
  }

  getUser(id: number) {
    try {
      return this.service.getUser(id);
    } catch (err) {
      if (err instanceof Error) {
        return { error: err.message };
      }
      return { error: 'Unknown error' };
    }
  }
}
