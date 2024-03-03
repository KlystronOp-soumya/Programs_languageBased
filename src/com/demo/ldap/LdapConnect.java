package com.demo.ldap;

import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.NamingException;
import javax.naming.* ;

public class LdapConnect {
	String url = "ldap://localhost:10389";
	Hashtable env = new Hashtable();
	env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, url);
	env.put(Context.SECURITY_AUTHENTICATION, "simple");
	env.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
	env.put(Context.SECURITY_CREDENTIALS, "secret");
	 
	try {
	    DirContext ctx = new InitialDirContext(env);
	    System.out.println("connected");
	    System.out.println(ctx.getEnvironment());
	     
	    // do something useful with the context...
	 
	    ctx.close();
	 
	} catch (AuthenticationNotSupportedException ex) {
	    System.out.println("The authentication is not supported by the server");
	} catch (AuthenticationException ex1) {
	    System.out.println("incorrect password or username");
	} catch (NamingException ex2) {
	    System.out.println("error when trying to create the context");
	}
}
