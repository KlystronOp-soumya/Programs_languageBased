class SimpleEvent{
    @Delegate(deprecated = true)
    Date when ;
    @Delegate List entries=[] ;
    String desc ;
    int numOfStudents ;

}

static void main(String[] args)

{ 
   BufferedReader rd = new BufferedReader(new InputStreamReader(System.in)) ;
    int numOfStrs = Integer.parseInt(rd.readLine()) ;
    def names = []
    for(int i = 0 ; i< numOfStrs; i++){
        names << rd.readLine() ;
    }
    def desc = rd.readLine() ;
    def numOfStudents = Integer.parseInt(rd.readLine()) ;



  // write code
  SimpleEvent obj = new SimpleEvent(when: Date.parse('yyyy/mm/dd' , '1997/08/03') ,
  desc:desc ,
  numOfStudents:numOfStudents
  ) ;
  def now = new Date()
  //out of the list before instance
  println obj.size() ; //4

  obj.setEntries(names) ; // 0
  println obj.before(now) ; //true
  println obj.getNumOfStudents() ; //4
  println obj.size() == 2; //true
  println obj.get(0) ;
  println obj.get(1) ;
  println obj.minus(obj.get(0)) ;
  rd.close() ;  
}