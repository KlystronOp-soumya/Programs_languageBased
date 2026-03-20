import { Calculator } from "./calculator/calculator";
import { Logger } from "./logger/logger";
import { TaxService } from "./tax/tax_service";

async function main():Promise<void> {
  const logger = new Logger();
  const taxService = new TaxService();

  const calc = new Calculator(logger, taxService);

  const result = calc.add(2, 3);
  console.log("Add result:", result);

  try {
    const total = await calc.calculateTotalWithTax(100);
    console.log("Total with tax:", total);
  } catch (error: any) {
    console.error("Error:", error.message);
  }
}

main();