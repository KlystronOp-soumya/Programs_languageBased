import { when as jestWhen } from 'jest-when';
import { UserService } from '../src/user-service/service/UserService';
import { UserDao } from '../src/user-service/dao/UserDao';
import { anything, instance, mock, verify, when } from 'ts-mockito';

test('should return user', () => {
  const dao = {
    save: jest.fn(),
    findById: jest.fn(),
  } as unknown as UserDao;

  jestWhen(dao.findById)
    .calledWith(jestWhen((input) => input === 1)) // or calledWith(1)
    .mockReturnValue({ uId: 1, uName: 'Soumya' });

  const service = new UserService(dao as UserDao);

  const user = service.getUser(1);

  expect(user.uName).toBe('Soumya');
});

test('should throw error when user not found', () => {
  const dao = {
    save: jest.fn(),
    findById: jest.fn(),
  } as unknown as UserDao;

  jestWhen(dao.findById)
    .calledWith(jestWhen((input) => input === 1)) // or calledWith(1)
    .mockReturnValue(null);

  const service = new UserService(dao as UserDao);
  expect(() => service.getUser(1)).toThrow('User not found');
  expect(dao.findById).toHaveBeenCalledTimes(1);
  expect(dao.findById).toHaveBeenCalledWith(1);
});

test('[TS-Mockito]should throw error when user not found', () => {
  // Arrange
  const userDaoMock = mock<UserDao>();

  when(userDaoMock.findById(2)).thenReturn(null);

  const service = new UserService(instance(userDaoMock));

  // Act + Assert (exception)
  expect(() => service.getUser(2)).toThrow('User not found');

  // Verify interaction
  verify(userDaoMock.findById(2)).once();
  verify(userDaoMock.findById(1)).never();
  verify(userDaoMock.save(anything())).never();
});
