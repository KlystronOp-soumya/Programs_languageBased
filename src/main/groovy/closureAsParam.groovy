class A{
    def m1(){
        println "Method1"
    }

    def m2(){
        println "Method1"
    }

    def commands(closure) {
        def c = closure.clone()
        c.delegate = this
        println "before"
        c()
        println "after"
    }
}