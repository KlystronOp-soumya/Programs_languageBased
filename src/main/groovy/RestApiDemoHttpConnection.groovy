/*
This scripts demostrates the Rest Api handling capability in Groovy
*/

import groovy.json.JsonSlurper ;

class Jira{

def base = 'https://issues.apache.org/jira/rest/api/latest/issue/'

def slurper = new JsonSlurper() ;

def query(key){
    def httpConnection = new URL(base + key).openConnection() ;

    assert httpConnection.responseCode == httpConnection.HTTP_OK ;
    slurper.parse(httpConnection.inputStream.newReader()) ;
}

}

println "Called"
def jira = new Jira() ;
def response = jira.query("GROOVY-5999") ;
assert response != null
println response
response.fields.with{
    assert summary == "Make @Delegate work with @DelegatesTo"
    assert fixVersions.name == ['2.1.1']
}