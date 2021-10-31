function myDisplayer(some) {
   console.log(some);
  }
  
  let myPromise = new Promise(function(myResolve, myReject) {
    let x = 0; 
  
  // some code (try to change x to 5)
  
    if (x == 0) {
      myResolve("OK");
    } else {
      myReject("Error");
    }
  });

  myPromise.then(resolve => myDisplayer(resolve) 
      
  
    /* function(val) {myDisplayer(val);} ,
    function(er) {myDisplayer(er);} */
  ).catch(error => myDisplayer(error));

  myPromise.then(
         resolveRespose => myDisplayer(resolveRespose),
         errorResponse => myDisplayer(errorResponse)
         
  );
