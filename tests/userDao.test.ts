import { UserDao } from '../src/user-service/dao/UserDao';
let dao: UserDao;
beforeAll(() => {
  dao = new UserDao();
});

test('should save and retrieve user', () => {
  //const dao = new UserDao(); //uncomment this if beforeAll is not being used

  dao.save({ uId: 1, uName: 'Test' });

  const user = dao.findById(1);

  expect(user).toEqual({ uId: 1, uName: 'Test' });
});

test('should not find user', () => {});
