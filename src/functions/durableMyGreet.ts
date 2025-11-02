import { app, HttpHandler } from "@azure/functions";
import * as df from 'durable-functions';
import { myGreetHttpTrigger } from "./triggers/myGreetHttpTrigger";
import { myGreetHandler } from "./activities/myGreetHandler";
import { durableMyGreetOrchestrator } from "./orchestrator/durableMyGreetOrch";
import { ActivityHandler, OrchestrationHandler } from "durable-functions";


const myGreetActivity:ActivityHandler = myGreetHandler;
const myGreetTrigger : HttpHandler = myGreetHttpTrigger;
const myGreetOrch:OrchestrationHandler = durableMyGreetOrchestrator;

//register the orch
df.app.orchestration(myGreetOrch.name, myGreetOrch);

//register the activity
df.app.activity(myGreetActivity.name, {handler: myGreetActivity});

app.http(myGreetTrigger.name, {
    route: 'greetOrchestrator',
    extraInputs: [df.input.durableClient()],
    handler: myGreetTrigger, //takes the http trigger
})