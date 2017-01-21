# Weblogic issue - JSF 2.2.12 - Application with webservice context will get - Multiple JSF Applications found on same ClassLoader.

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
