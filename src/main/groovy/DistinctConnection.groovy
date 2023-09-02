def totalClinks = 0
def partyPeople = 100

1.upto(partyPeople)
{
    guestNumber ->
        clinksWithGuest = guestNumber-1
        totalClinks += clinksWithGuest
}

println "Showing Result: ${totalClinks}"
assert totalClinks == (partyPeople*(partyPeople-1)) / 2

