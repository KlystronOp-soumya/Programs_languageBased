def example = 1..100 ;
print(example.getTo());
assert example.contains(101) == false
assert example.contains(10)

assert example instanceof Range

//Bounds checking
assert (0.0 .. 1.0).containsWithinBounds(0.5)

def today = new Date()
def yesterday = today-1

assert (yesterday ..today ).size() == 2

assert ('a' .. 's').contains('x') == false

def log = ''
for (eachElem in 6..9)
{
    log+=eachElem
}
print(log)

(200 ..< 100).each{
    eachElem -> log+=eachElem ;
}

//println log ;

def str = "A".."S" ;
assert (0..10).isCase(5) ;
//range in switch case
def age = 36

switch(age) {
    case 16..20: rate=0.05 ; break ;
    case 21..50: rate=0.06 ; break ;
    case 51..65: rate=0.07 ; break ;
    default: throw new IllegalArgumentException() ;
}

def ages = [20 , 36, 42, 56] ;
def midAge = 21..50 ;
assert ages.grep(midAge) == [36,42] ;
