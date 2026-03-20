import { Calculator } from "../src/calculator/calculator";
import { Logger } from "../src/logger/logger";
import { TaxService } from "../src/tax/tax_service";

describe("test calculator", ()=>{

    beforeEach(()=> console.log("About start--->"))

    test("should log additon", () =>{

        const logger = {log: jest.fn()}; //object with the function
        const taxService = {getTaxRate: jest.fn()}; //object with the function

        const calc = new Calculator(logger as Logger, taxService as TaxService);

        calc.add(2,3);

        expect(logger.log).toHaveBeenCalledWith("Adding 2 + 3 = 5");
    });

    test("should inspect mock.calls", () =>{

        const logger = {log: jest.fn()};
        const taxService = {getTaxRate: jest.fn()};

        const calc = new Calculator(logger as any, taxService as any);

        calc.add(1, 1);

        const calls = logger.log.mock.calls;

        expect(calls[0][0]).toBe("Adding 1 + 1 = 2");
    });

    

});