import { OrchestrationContext, OrchestrationHandler } from "durable-functions";

const durableMyGreetOrchestrator : OrchestrationHandler = function* (context:OrchestrationContext) {
    const outputs = [];
    
    outputs.push(yield context.df.callActivity("myGreetHandler", 'ORDERED!!'));//executes the activity
    outputs.push(yield context.df.callActivity("myGreetHandler", 'PAYMENT DONE'));
    outputs.push(yield context.df.callActivity("myGreetHandler", 'DISPATCHED'));

    return outputs;
};

export {durableMyGreetOrchestrator};