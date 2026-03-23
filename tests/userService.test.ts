import { when } from 'jest-when';
import { UserService } from '../src/user-service/service/UserService';
import { UserDao } from '../src/user-service/dao/UserDao';

test('should return user', () => {
  const dao = {
    save: jest.fn(),
    findById: jest.fn(),
  } as unknown as UserDao;

  when(dao.findById)
    .calledWith(when((input) => input === 1)) // or calledWith(1)
    .mockReturnValue({ uId: 1, uName: 'Soumya' });

  const service = new UserService(dao as UserDao);

  const user = service.getUser(1);

  expect(user.uName).toBe('Soumya');
});
