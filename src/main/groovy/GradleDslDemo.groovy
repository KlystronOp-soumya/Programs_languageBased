//this script is trying to replicate the DSL of gradle for Jar build
//create a method which takes closure as an argument
def jar(final Closure closure)
{
    closure()
}

def dependsOn(final String dependency)
{
    println dependency ;
}

jar {

    dependsOn "groovy-4.1" ;
}

jar({
     dependsOn("groovy-4.1") ;
})

Closure closure = {dependsOn("log4j-2.7.1")}
jar(closure) ;