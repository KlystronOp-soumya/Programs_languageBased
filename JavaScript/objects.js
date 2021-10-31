//However, if your object has any non-string properties, JavaScript will automatically typecast them as strings.
var cat = {
    "name": "Whiskers",
    "legs": 4,
    "tails": 1,
    "enemies": ["Water", "Dogs"]
  };

  var anotherObject = {
    make: "Ford",
    5: "five",
    "model": "focus"
  };

  /* There are two ways to access the properties of an object: dot notation (.) and bracket notation ([]), similar to an array.

Dot notation is what you use when you know the name of the property you're trying to access ahead of time. */
var myObj = {
    prop1: "val1",
    prop2: "val2"
  };
  var prop1val = myObj.prop1;
  var prop2val = myObj.prop2;

  var myObj = {
    "Space Name": "Kirk",
    "More Space": "Spock",
    "NoSpace": "USS Enterprise"
  };
  myObj["Space Name"];
  myObj['More Space'];
  myObj["NoSpace"];
/* Another way you can use this concept is when the property's name is collected dynamically during the program execution, as follows: */

  var someObj = {
    propName: "John"
  };
  function propPrefix(str) {
    var s = "prop";
    return s + str;
  }
  var someProp = propPrefix("Name");
  console.log(someObj[someProp]);

 // You can add new properties to existing JavaScript objects the same way you would modify them.

/*Here's how we would add a bark property to ourDog:

ourDog.bark = "bow-wow";
or

ourDog["bark"] = "bow-wow";
Now when we evaluate ourDog.bark, we'll get his bark, bow-wow.

Example:*/

var ourDog = {
  "name": "Camper",
  "legs": 4,
  "tails": 1,
  "friends": ["everything!"]
};

ourDog.bark = "bow-wow";
/* We can also delete properties from objects like this:

delete ourDog.bark; */
var ourDog = {
    "name": "Camper",
    "legs": 4,
    "tails": 1,
    "friends": ["everything!"],
    "bark": "bow-wow"
  };
  
  //deleting a property from an object
  delete ourDog.bark;

  //lookup for the value

  var nme="camper";

  if(ourDog.name === nme){
    console.log("found");
  }

  //check if an object holds an attribute
  var myObj={
  top: "hat",
  bottom: "pants"
};
concole.log(myObj.hasOwnProperty("top"));
console.log(myObj.hasOwnProperty("middle"));

//array of the objects
var ourPets = [
  {
    animalType: "cat",
    names: [
      "Meowzer",
      "Fluffy",
      "Kit-Cat"
    ]
  },
  {
    animalType: "dog",
    names: [
      "Spot",
      "Bowser",
      "Frankie"
    ]
  }
];
ourPets[0].names[1];
ourPets[1].names[0];

var person = {
  firstName: "John",
  lastName : "Doe",
  id       : 5566,
  fullName : function() {
    return this.firstName + " " + this.lastName;
  }
};

for( x in person)
 console.log(x);

Properties:

delete keyword is used to delete properties from a JSON object.
Example


delete myObj.cars.car2;