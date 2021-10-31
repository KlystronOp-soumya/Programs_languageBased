async function checkX(x){
    let promise = new Promise((resolve,error)=>{
        if(x<13)
          resolve("dorime");
        else
          error("ameno");
    });
    return  (await promise);
  /*  let resp = await promise;
   console.log(resp);
   console.log(typeof(resp)); */
}
checkX(5).then(resolve => console.log(resolve));
//console.log(  checkX(5));

