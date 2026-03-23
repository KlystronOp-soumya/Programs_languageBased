import { UserDao } from '../src/user-service/dao/UserDao';

test('should save and retrieve user', () => {
  const dao = new UserDao();

  dao.save({ uId: 1, uName: 'Test' });

  const user = dao.findById(1);

  expect(user).toEqual({ uId: 1, uName: 'Test' });
});
