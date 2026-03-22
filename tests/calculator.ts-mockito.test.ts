import { mock, instance, when, verify, capture } from 'ts-mockito';
import { Logger } from '../src/logger/logger';
import { TaxService } from '../src/tax/tax_service';
import { Calculator } from '../src/calculator/calculator';

describe('ts-mockito', () => {
  test('should verify logging', () => {
    const loggerMock = mock(Logger);
    const taxMock = mock(TaxService);

    const calc = new Calculator(instance(loggerMock), instance(taxMock));

    calc.add(2, 3);

    verify(loggerMock.log('Adding 2 + 3 = 5')).once();
  });

  test('should stub async', async () => {
    const loggerMock = mock(Logger);
    const taxMock = mock(TaxService);

    when(taxMock.getTaxRate()).thenResolve(0.1);

    const calc = new Calculator(instance(loggerMock), instance(taxMock));

    const result = await calc.calculateTotalWithTax(100);

    expect(result).toBe(110);
  });

  test('should capture arguments', () => {
    const loggerMock = mock(Logger);
    const taxMock = mock(TaxService);

    const calc = new Calculator(instance(loggerMock), instance(taxMock));

    calc.add(5, 5);

    const [message] = capture(loggerMock.log).last();

    expect(message).toBe('Adding 5 + 5 = 10');
  });

  test('should reject invalid amount', async () => {
    const loggerMock = mock(Logger);
    const taxMock = mock(TaxService);

    const calc = new Calculator(instance(loggerMock), instance(taxMock));

    await expect(calc.calculateTotalWithTax(-1)).rejects.toThrow(
      'Invalid amount',
    );
  });
});
