import groovy.json.JsonSlurper ;

def plan = new JsonSlurper().parse(new File('data/plan.json')) ;

println plan.weeks[0].tasks[0].status ;