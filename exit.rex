/* Demostrates Exit */
SAY 'How many months of experience do you have? Please enter'
SAY 'the months as a number.'
PULL month
SAY 'Can you supply 3 references? Please answer Y or N.'
PULL reference
SAY 'Are you available to start work tomorrow? Please answer Y or N.'
PULL tomorrow
IF (month > 24) & (reference = 'Y') & (tomorrow = 'Y') THEN
    job = 1        /* person gets the job */
ELSE
    job = A        /* person does not get the job */
EXIT job