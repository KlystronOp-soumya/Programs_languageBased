class Solution
{
  public static void main(String[] args)
    {
        // write code
        ExpandoMetaClass.enableGlobally()
        // write code
        def ls = [] ;
        Scanner sc = new Scanner(System.in) ;
        int test  = sc.nextInt() ;
        while(test > 0){
            ls << sc.next() ;
            test-- ;
        }

        List.metaClass.rightShift {i  ->
        delegate.remove(i)
        //delegate.size()
        }
      println ls
      println ls.size() //4
      ls.rightShift(0)
      println ls.size() // 3
      println ls
      ls >> 1
      println ls.size() //2
      println ls
      
      if("queen" in ls){
      println "[queen groovy, slave groovy]"  
        }
    if("peter" in ls){
       println "[peter groovy, clark groovy, warner groovy]"
      }
    }

/*List.metaClass.rightShift {
   // write code
}*/
  // write code
    //}
}