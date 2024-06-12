//Simple script to demonstrate the EmailDSL
class Email{
    String to
    String from
    List cc
    List bcc
    String message
    String signature

    // a static method
    def static Email  build(Closure closure){
        Email obj = new Email()
        obj.cc = []
        closure.delegate = obj
        closure()
        return obj
        
    }

    void to(final String to)
    {
        this.to = to
    }
    void from(final String from)
    {
        this.from = from ;
    }
    void cc(final String cc)
    {
        this.cc.add(cc) ;
    }
    void bcc(final String bcc)
    {
        this.bcc = bcc ;
    }
    void message(final String message)
    {
        this.message = message
    }
    void signature(final String signature){
        this.signature = signature ;
    }

    void methodMissing(String name , Object args)
    {
        println "calling methodMissing $name $args"
    }

    void Display()
    {
        println this.to + " " + this.from ;
    }
    
}

def email = Email.build({

    to "abc@gmail.com"
    from "ghd@gmail.com"
    cc "xyz@gmail.com"
    message "hi this is Groovy"

})

email.Display()