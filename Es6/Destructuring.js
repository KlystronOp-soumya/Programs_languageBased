const Temperatures = {
  yesterday: 88,
  today: 68,
  tomorrow: 60,
};
/*The code below wont work,the variable names must be equal to the object names */
const { today, tomorrow } = Temperatures; //this is a valid code
//const {t1,t2}=Temperatures;
console.log(today, tomorrow);
