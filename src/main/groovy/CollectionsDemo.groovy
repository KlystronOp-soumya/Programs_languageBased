/*
This script shows different methods for List
*/
intList = [11 , 12 , 13 , 14]
strList = ['Angular'  , 'Groovy' , 'Java']
nestList = [1 ,2,[3 ,4] , 5]
heteroList = ['Groovy' , 21 , 2.11]
emptyList= []

assert emptyList.isEmpty()

//add method : void add(int index, Object value)
intList.add(0 , 10)
intList.add(5 , 15)

println intList

//contains : boolean contains(Object value)

assert intList.contains(15)

//minus: Creates a new List composed of the elements of the original without those specified in the collection.
 def newlst = [];
 newlst = intList.minus([12,13]); 
 println(newlst); 

//plus: the original together with those specified in the collection.
 def newlst2 = [] ;
 newlst2 = intList.plus([100,200])
 println newlst2

//