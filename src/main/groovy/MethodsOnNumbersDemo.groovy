def store = ''
10.times{
    store+='$ '
}

println store
//reset
store = ''
1.upto(5){
    eachNum -> store+=eachNum
}

println store

store = ''
2.downto(-2){//starting from 2 to -2 
    eachNum -> store+= eachNum+' '
}

println store
