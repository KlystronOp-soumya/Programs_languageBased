//This groovy script demonstrates the different aspects of the List, Map in Groovy
def roman = ['' , 'I' , 'II' , 'III']
assert roman[2] == 'II'

roman[4] = 'IV' // value assignment

assert roman.size() == 5

/*Defining a dictionary*/
def httpResponses = [
    100 : 'CONTINUE' ,
    200 : 'OK' ,
    400 : 'BAD REQUEST'
]

assert httpResponses[200] == 'OK'

httpResponses[500] = 'INTERNAL SERVER ERROR'

assert httpResponses.size() == 4

/*Ranges demo*/
def x = 1..10

assert !x.contains(15)
assert x.size() == 10
assert x.from == 1
assert x.to == 10
assert x.reverse() == 10 .. 1
