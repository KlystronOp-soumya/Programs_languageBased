//define two classes
class Person {
    String name
}
class Thing {
    String name
}

def p = new Person(name: 'Norman')
def t = new Thing(name: 'Teapot')

//define a closure with delegation
// delegate -> can be interpreted as current object reference
def upperCasedName = { delegate.name.toUpperCase() }

upperCasedName.delegate = p // so in the the object reference is of Person class Hence delegate.name i.e. (p.name)
assert upperCasedName() == 'NORMAN'
upperCasedName.delegate = t
assert upperCasedName() == 'TEAPOT'

def target = p
def upperCasedNameUsingVar = { target.name.toUpperCase() }
assert upperCasedNameUsingVar() == 'NORMAN'