import { OrchestrationContext, OrchestrationHandler } from "durable-functions";

const durableMyGreetOrchestrator : OrchestrationHandler = function* (context:OrchestrationContext) {
    const outputs = [];
    // Extract activityName from orchestrator input
    const activityName = context.df.getInput() as string;
    outputs.push(yield context.df.callActivity("myGreetHandler", 'ORDERED'));//executes the activity
    outputs.push(yield context.df.callActivity("myGreetHandler", 'PAYMENT'));
    outputs.push(yield context.df.callActivity("myGreetHandler", 'DISPATCHED'));

    return outputs;
};

export {durableMyGreetOrchestrator};