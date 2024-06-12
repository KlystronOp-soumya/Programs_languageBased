// Script to demonstrate the expandometaclass
class Book {
   String title
}

Book.metaClass.titleInUpperCase << {-> title.toUpperCase() }

def b = new Book(title:"The Stand")

assert "THE STAND" == b.titleInUpperCase()

// two different ways of assigning property
Book.metaClass.author = "Stephen King"
def b1 = new Book()

assert "Stephen King" == b.author

Book.metaClass.getAuthor << {-> "Stephen King" }

def b3 = new Book()

assert "Stephen King" == b.author

Book.metaClass.constructor << { String title -> new Book(title:title) }
def book = new Book('Groovy in Action - 2nd Edition')
assert book.title == 'Groovy in Action - 2nd Edition'