# JSF verified Weblogic 12.2.1.2 using JSF 2.2.12 - A page that uses composite components may go to error fn:replace not found if parent page does not itself declare the fn namespace

JSF 2.2-12 returns:

```
javax.el.ELException: Function 'fn:replace' not found
	at com.sun.el.lang.ExpressionBuilder.visit(ExpressionBuilder.java:275)
	at com.sun.el.parser.SimpleNode.accept(SimpleNode.java:172)
	at com.sun.el.lang.ExpressionBuilder.prepare(ExpressionBuilder.java:227)
	at com.sun.el.lang.ExpressionBuilder.build(ExpressionBuilder.java:238)
	at com.sun.el.lang.ExpressionBuilder.createValueExpression(ExpressionBuilder.java:295)
	at com.sun.el.ExpressionFactoryImpl.createVal
```

When page uses a composite component that needs JSTL functions.
This happens whenever whenever the parent page needing the composite component does not include itself the 
xmlns:fn="http://java.sun.com/jsp/jstl/functions" 

Despite the fact that the composite component .xhtml itself is including the xmlns:fn="http://java.sun.com/jsp/jstl/functions" .

In this sample applicaiton we have two pages. One that works and one that doesnt.
The one that works is the index.xhtml and it uses the fn:replace function of the composite component.
The page works because it itself declares: xmlns:fn="http://java.sun.com/jsp/jstl/functions" 
The page offers a button to travel to a : index-fn-replace-not-found.xhtml that blows up with the above stack trace.
This page does not work because have cut out the 	xmlns:fn="http://java.sun.com/jsp/jstl/functions" .



NOTE:
This issue bares resembaled to the reported bug, but it is not the same issue. 
https://java.net/jira/browse/JAVASERVERFACES-3469

This issue is now open on:
https://java.net/jira/browse/JAVASERVERFACES-4222
