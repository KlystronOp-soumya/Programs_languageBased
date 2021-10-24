fred='PETE'
call multiway fred, 7


exit
Multiway: procedure
   arg label .              /* One word, uppercase                  */
                            /* Can add checks for valid labels here */
   signal value label       /* Transfer control to wherever         */
Pete: say arg(1) '!' arg(2) /* Displays: "PETE ! 7"                 */
   return