def matcher = 'a:1 b:2 c:3' =~ /(\S+):(\S+)/

println matcher.hasGroup()
println "First group matched:" + matcher[0]
println "Second group matched:" + matcher[0]
println "Second element is second group" + matcher[1][2]

//using the closures

matcher.each {
    full , key , value ->
    assert full.size() == 3
    assert key.size() == 1 //a,b,c
    assert value.size() == 1
}