class Ex
{
public static void main(String[] args)
    {
        ExpandoMetaClass.enableGlobally()
        // write code
        def ls = [] ;
        Scanner sc = new Scanner(System.in) ;
        int test  = sc.nextInt() ;
        while(test > 0){
            ls << sc.next() ;
            test-- ;
        }

        List.metaClass.rightShift << {i  ->
        delegate.remove(i)
        delegate.size()
        }
      println ls
      println ls.size()
      println  ls >> 0
      println ls
      println ls >> 0 ;
      println ls  

    Ex obj = new Ex() ;
    obj.metaClass.shift = List.&rightShift ;
    


    sc.close() ;
    }
}
