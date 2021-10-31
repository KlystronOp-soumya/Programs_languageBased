/*
Statement:
Record Collection
You are given a JSON object representing a part of your musical album collection. Each album has a unique id number as its key and several other properties. Not all albums have complete information.

You start with an updateRecords function that takes an object like collection, an id, a prop (like artist or tracks), and a value. Complete the function using the rules below to modify the object passed to the function.

Your function must always return the entire object.
If prop isn't tracks and value isn't an empty string, update or set that album's prop to value.
If prop is tracks but the album doesn't have a tracks property, create an empty array and add value to it.
If prop is tracks and value isn't an empty string, add value to the end of the album's existing tracks array.
If value is an empty string, delete the given prop property from the album.
Note: A copy of the collection object is used for the tests.

*/
/* var myStorage = {
    "car": {
      "inside": {
        "glove box": "maps",
        "passenger seat": "crumbs"
       },
      "outside": {
        "trunk": "jack"
      }
    }
  };
  
  var gloveBoxContents = myStorage.car.inside["glove box"];
  console.log(gloveBoxContents));

  tracks=[];
console.log(tracks)); */

// Setup
var collection = {
    2548: {
      albumTitle: 'Slippery When Wet',
      artist: 'Bon Jovi',
      tracks: ['Let It Rock', 'You Give Love a Bad Name']
    },
    2468: {
      albumTitle: '1999',
      artist: 'Prince',
      tracks: ['1999', 'Little Red Corvette']
    },
    1245: {
      artist: 'Robert Palmer',
      tracks: []
    },
    5439: {
      albumTitle: 'ABBA Gold'
    }
  };
  
  // Only change code below this line
  function updateRecords(object, id, prop, value) {
      //if prop isnt tracks and value isnt empty string
      try {
        //console.log(`id=${id} prop=${prop} value=${value}`);
     if(value === ""){
       console.log("Inside the IF");
       delete object[id][prop];
      }
       
    else{
      if(prop!="tracks" && value.length > 0)
      {
        //object.id[prop] = "";
        let val=value;
        object[id][prop]  =val;
      }
        
      if(prop === "tracks"){
        if(!object[id].hasOwnProperty("tracks")){
          object[id].tracks=[];
          object[id][prop].push(value);
        }
        else{
          object[id][prop].push(value);
        }
       
      }
    }
      } catch (error) {
        console.log(error);
      }
      
    
     
      return object;
   // return object[id];
  }
  
  /* console.log("Query1");
  console.log(updateRecords(collection, 5439, 'artist', 'ABBA')); */
  /* console.log("Query2");
  console.log(updateRecords(collection, 5439, "tracks", "Take a Chance on Me")); */
 //console.log(collection[5439].hasOwnProperty("albumTitle"));
  /* console.log("Query3");
  console.log(updateRecords(collection, 2548, "artist", "")); */
    /* console.log("Query4");
  console.log(updateRecords(collection, 1245, "tracks", "Addicted to Love")); */
 /* console.log("Query5");
  console.log(updateRecords(collection, 2468, "tracks", "Free")); */
 /* console.log("Query6");
  console.log(updateRecords(collection, 2548, "tracks", "")); */
console.log("Query7");
  console.log(updateRecords(collection, 1245, "albumTitle", "Riptide"));