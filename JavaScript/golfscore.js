var names = ["Hole-in-one!", "Eagle", "Birdie", "Par", "Bogey", "Double Bogey", "Go Home!"];
function golfScore(par, strokes) {
  // Only change code below this line
  var dec;
  if(strokes==1)
   dec=names[0];
 else{
    if(strokes<=(par-2))
    dec=names[1];
    if(strokes==(par-1))
    dec=names[2];
    if(strokes==par)
    dec=names[3];
    if(strokes==(par+1))
    dec=names[4];
    if(strokes==(par+2))
    dec=names[5];
    if(strokes>=(par+3))
    dec=names[6];
 }
  
  


  return dec;
  // Only change code above this line
}

console.log(golfScore(5, 4));
console.log(golfScore(1,1));
console.log(golfScore(4,1));