class Solution{

    static main(args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        String str = br.readLine()
        int a = Integer.parseInt(br.readLine())
        int b = Integer.parseInt(br.readLine())
        def changeCase = { st -> str.toUpperCase()}
        def doSum = { num1 ,  num2 -> a+b}

        println changeCase.call(str)
        println doSum.call(a,b)


    }
}