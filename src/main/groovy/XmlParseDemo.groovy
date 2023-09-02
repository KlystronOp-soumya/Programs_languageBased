import org.codehaus.groovy.runtime.InvokerHelper
import groovy.xml.MarkupBuilder 
import groovy.util.*
class Example extends Script
{
    def run()
    {
        def parser = new XmlParser()
      def doc = parser.parse("movies.xml");
		
      doc.movie.each{
         bk->
         print("Movie Name:")
         println "${bk['@title']}"
			
         print("Movie Type:")
         println "${bk.type[0].text()}"
			
         print("Movie Format:")
         println "${bk.format[0].text()}"
			
         print("Movie year:")
         println "${bk.year[0].text()}"
			
         print("Movie rating:")
         println "${bk.rating[0].text()}"
			
         print("Movie stars:")
         println "${bk.stars[0].text()}"
			
         print("Movie description:")
         println "${bk.description[0].text()}"
         println("*******************************")
    }
    }
    static main(args) {
        InvokerHelper.runScript(Example , args)
    }

 
}