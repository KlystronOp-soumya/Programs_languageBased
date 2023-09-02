def matcher = 'a b c' =~ /\S/

assert matcher[0] == 'a'
assert matcher[1..2] == ['b' , 'c']
assert matcher.size() == 3

//paraller assignment feature
def(a,b,c) = 'a b c' =~ /\S/

println "a:$a"
