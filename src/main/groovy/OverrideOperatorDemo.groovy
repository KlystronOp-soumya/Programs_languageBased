import groovy.transform.Immutable

@Immutable
class Money
{
    int amount
    String currency

    Money plus(Money other)
    {
        if(null == other)
            return this //returns the current object
        
        if(other.currency != currency)
        {
            throw new IllegalArgumentException("cannot add $other.currency to $currency")
        }
        
        return new Money(this.amount + other.amount , currency)
    }
}

Money buck = new Money(1, 'USD')
assert buck
Money buck2  = new Money(1 , "USD")
assert buck == buck2 //overridden equals which is overridden by default
Money buck3 = new Money(2 , "USD")
assert buck+buck2 == buck3 //implemented plus operator
assert buck.equals(buck2)
println "Currency is: " + buck.currency