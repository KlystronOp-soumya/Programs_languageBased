trait StudentID{
    int id
}
trait StudentName{
    def name
}
class student implements StudentID , StudentName{

    void display()
    {
        print this.id + ":" + this.name
    }
}
BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        int i = Integer.parseInt(br.readLine())
        String name = br.readLine()
        def s = new student(id : i, name : name)
        s.display()