/*
This groovy script reads data from a RSS feed and shows top 3 headlines as of today
*/
import groovy.xml.XmlParser ;

def base = "https://feeds.bbci.co.uk/news/world" ;

def url = base + "/europe/rss.xml" ;

println "The top 3 news articles today" ;
// the parse method by default calls the end point and grabs the response content
def items = new XmlParser().parse(url).channel[0].item ;

for (item in items[0..2] ) {
    
    println item.title.text() ;
    println item.link.text() ;
    println item.description.text() ;
}