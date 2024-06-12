class SimpleEvent{
    @Delegate 
    Date when ;
    @Delegate
    List marks ;

    String name , sec , roll ;

}


List<Double> marks = [] ;
marks.add(99.98);
marks.add(99.98);
marks.add(99.98);
marks.add(99.98);
marks.add(99.98);
def student1 = new SimpleEvent(name: "Jhon Doe" , sec: "B" , roll: "13" , when: Date.parse("yyyy/mm/dd" , "2013/03/13") , marks: marks);
List<Double> marks2 = [] ;
marks2.add(80.85);
marks2.add(80.85);
marks2.add(80.85);
marks2.add(80.85);

def student2 = new SimpleEvent(name: "Jhon Doe" , sec: "B" , roll: "13" , when: Date.parse("yyyy/mm/dd" , "2013/03/13") , marks: marks2);
println student1.addAll(student2.marks) ;

println student1.marks ;