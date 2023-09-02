def twister = "she sells sea shells at the sea shore of seychelles"
// twister must contain a substring of size 3
// that starts with s and ends with a
/*
/s.a/ ->
/s -> starts with s
. -> any character
a/ -> ending with a

=~ to find a pattern
==~ to match a pattern
*/
assert twister =~ /s.a/

def finder = (twister =~ /s.a/)
assert finder instanceof java.util.regex.Matcher

//twister must contain
//only words delimited by single spaces
/*
(\w+ \w+)* ->
\w -> word characters
+ -> one or multiple occurrance
\w+ -> one or multiple occurance of word characters
() -> for grouping
*/
assert twister ==~ (/(\w+ \w+)*/)

def word = (/\w+/)
matches = (twister ==~ /($word $word)*/) //repeating group

assert matches instanceof java.lang.Boolean

assert !(twister ==~ /s.e/)

def wordsByX= twister.replaceAll(word , 'X');
println wordsByX

def wordsSplt = twister.split(/ /)
assert wordsSplt.size() == 10
assert wordsSplt[0] == 'she'

/*Patterns in Action*/
def myFairStringy = 'The rain in Spain staus mainly ins the plain!'

//words that end with 'ain': \b\w*ain\b
def wordEnding = / \w*ain / //slashy convention
def rhyme = /\b$wordEnding/ // means space any word containing "ain" substring in it

def found = ''
myFairStringy.eachMatch(rhyme){
    match -> found+=match+' '
}

println "Found:" + found

found = ''
(myFairStringy =~ rhyme).each{
    match -> found+=match+' '
}

//assert found == ' rain  Spain '

def cloze = myFairStringy.replaceAll(rhyme){
    it-'ain'+'___'
}

println cloze ;

