class Weekday implements Comparable {

    static  final DAYS = ['Sun' , 'Mon' , 'Tue' , 'Wed' , 'Thu' , 'Fri' , 'Sat' ] ;

    private int index = 0 ;

    Weekday(String day)
    {
        index = DAYS.indexOf(day) ;
    }

    Weekday next()
    {
        //gets the next day
        return new Weekday(DAYS[(index+1) % DAYS.size()])
    }

    Weekday previous()
    {
        return new Weekday(DAYS[index-1]);
    }

    String toString()
    {
        return DAYS[index] ;
    }

    int compareTo(Object other)
    {
        return this.index <=> other.index ;

    }
}

def mon = new Weekday('Mon') ; //stores the index in the param constructor
def fri = new Weekday('Fri') ; 

def worklog='' ;

//this iterates through the objects
for (day in mon..fri)
{
    worklog+=day.toString()+' ' ;
}

println worklog ;