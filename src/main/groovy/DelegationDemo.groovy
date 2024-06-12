class Event {
     @Delegate(deprecated = true) Date when
     String title, url , year
/*
       public boolean before(Date otherDate) {
         return when.before(otherDate);
     } */
 }

 def gr8conf = new Event(title: "GR8 Conference",
                           url: "http://www.gr8conf.org",
                          when: Date.parse("yyyy/MM/dd", "2009/05/18"))

 def javaOne = new Event(title: "JavaOne",
                           url: "http://java.sun.com/javaone/",
                          when: Date.parse("yyyy/MM/dd", "2009/06/02"))

 assert gr8conf.before(javaOne.when)
  assert gr8conf.year + 1900 == 2009
 assert gr8conf.toGMTString().contains(" 2009 ")
