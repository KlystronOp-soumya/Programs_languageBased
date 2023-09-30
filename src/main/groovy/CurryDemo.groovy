/*
Currying helps to set a parameter in closure and creates a new closure
*/
def Employee  = { int id, String str-> str*id}
def emp = Employee.curry(2) //sets tge id as 2
assert emp('abc') == 'abcabc'
assert emp('abc') == Employee(2, 'abc')