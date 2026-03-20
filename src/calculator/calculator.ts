import { Logger } from '../logger/logger';
import { TaxService } from '../tax/tax_service';

export class Calculator {
  constructor(
    private logger: Logger,
    private taxService: TaxService,
  ) {}

  add(a: number, b: number): number {
    const result = a + b;
    this.logger.log(`Adding ${a} + ${b} = ${result}`);
    return result;
  }

  async calculateTotalWithTax(amount: number): Promise<number> {
    if (amount < 0) {
      throw new Error('Invalid amount');
    }

    const taxRate = await this.taxService.getTaxRate();
    const total = amount + amount * taxRate;

    this.logger.log(`Total with tax: ${total}`);
    return total;
  }
}
