import { instance, mock, verify, when } from 'ts-mockito';
import { UserService } from '../src/user-service/service/UserService';
import { UserController } from '../src/user-service/controller/UserController';

test('controller should return user', () => {
  const serviceMock = mock(UserService);

  when(serviceMock.getUser(1)).thenReturn({
    uId: 1,
    uName: 'Soumya',
  });

  const controller = new UserController(instance(serviceMock));

  const result = controller.getUser(1);

  expect(result).toEqual({ uId: 1, uName: 'Soumya' });

  verify(serviceMock.getUser(1)).once();
});

test('controller should handle error', () => {
  const serviceMock = mock(UserService);

  when(serviceMock.getUser(1)).thenThrow(new Error('User not found'));

  const controller = new UserController(instance(serviceMock));

  const result = controller.getUser(1);

  expect(result).toEqual({ error: 'User not found' });

  verify(serviceMock.getUser(1)).once();
});
