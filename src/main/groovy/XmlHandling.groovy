import javax.xml.parsers.DocumentBuilderFactory ;
import static org.w3c.dom.Node.* ;


def fac = DocumentBuilderFactory.newInstance() ;
def builder = fac.newDocumentBuilder();
def doc = builder.parse(new FileInputStream('data/plan.xml'));

def plan = doc.documentElement ;

assert plan != null

String info(node){

switch(node.nodeType) {
    case ELEMENT_NODE: return "element: $node.nodeName" ;
    case ATTRIBUTE_NODE: return "attribute: $node.nodeName = $node.nodeValue"
    case TEXT_NODE: return "text: $node.nodeValue"
   
}

return "some other type: $node.nodeType" ;

}

//println plan.getChildNodes()
//println plan.childNodes.item(0)
def firstTaskTitleTextNode = plan.childNodes.item(0) ;

def firstWeek = plan.childNodes.find{
    it.nodeName == 'week'
}
def firstTask = firstWeek.childNodes.item(1)
println info(firstTask) ;
println firstTask.attributes.getNamedItem('title') ;
def firstTaskText = firstTask.childNodes.item(0)


assert info(firstWeek) == 'element: week'
assert info(plan) == 'element: plan'
assert plan.childNodes.length == 5