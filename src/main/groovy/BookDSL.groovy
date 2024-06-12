class BookBuilder {
    String title
    String author
    def build(Closure closure) {
        closure.delegate = this
        closure.call()
    }

    // this works as Groovy extends the Groovy Object
    def methodMissing(String name , Object args){
        println "methodMissing invoked $name $args"
    }

    def title(String title){
        this.title = title ;
    }

    def author(String author){
        this.author = author ;
    }
}

def book = new BookBuilder()
book.build({
    title "Groovy In Action"
    author "John Doe"
})

book.Display(book.title , book.author)


