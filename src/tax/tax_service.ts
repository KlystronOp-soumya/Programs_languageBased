export class TaxService {
  async getTaxRate(): Promise<number> {
    return 0.1;
  }
}