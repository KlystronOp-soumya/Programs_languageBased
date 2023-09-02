/*This class will throw exception as
 [Static type checking]- cannot return value
 of type java.lang.String on method returning type int
*/
import groovy.transform.TypeChecked

class Universe
{
    @TypeChecked
    int answer()
    {
        "hello world"
    }
}