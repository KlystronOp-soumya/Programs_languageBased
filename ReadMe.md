This is a TS project to demonstrate the Azure Durable function in local.

### How To

<ol>
<li> Pull Azurtie docker container and run the image in local </li>
<li> Create a simple http trigger function following [Microsoft Doc](https://learn.microsoft.com/en-us/azure/azure-functions/durable/quickstart-ts-vscode?pivots=nodejs-model-v4)
</li>
<li>execute using: npm run start or func start in command</li>
</ol>

### Validate:

<p>Once the durable function is executed, it will return the following endpoints,</p>
<ul>
<li> statusQueryGetUri
<li> sendEventPostUri
<li> rewindPostUri
<li> terminatePostUri
</ul>
 > copy the link against any of the above entries to check the outout
