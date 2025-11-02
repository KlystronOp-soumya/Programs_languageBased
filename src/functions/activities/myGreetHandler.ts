import { ActivityHandler } from "durable-functions";

const myGreetHandler : ActivityHandler = (input:string):string => {
     return `Completing activity, ${input}`;
}

export {myGreetHandler};