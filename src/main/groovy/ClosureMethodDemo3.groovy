class Solution{
    
    def static Display(Closure clos , float price)
    {
        calc(clos , price)
    }

    def static calc(Closure clos , def price)
    {
        def tax = 0.18
        def amount = price + price*tax
        println clos.call(amount)
    }

    static main(args) {
        int q = 12
        float price  = 2000.00
        Closure clos = {p-> new BigDecimal(p*q).round(2) }
       // DecimalFormat decim = new DecimalFormat("0.00")
        println clos.call(price)
        Solution.Display(clos , price)
    }
}