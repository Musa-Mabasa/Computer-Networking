import java.security.KeyStore.Entry.Attribute;
import java.sql.Connection;
import java.util.Properties;
import java.util.Scanner;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.AttributeInUseException;
import javax.naming.directory.*;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class Client{

    private Properties pro;
    private DirContext connection;

    public void connect()
    {
        pro = new Properties();
        pro.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        pro.put(Context.PROVIDER_URL,"ldap://phone.localhost:389");
        pro.put(Context.SECURITY_PRINCIPAL,"cn=admin,dc=phone,dc=local");
        pro.put(Context.SECURITY_CREDENTIALS,"Muzero000814");
        pro.put(Context.SECURITY_AUTHENTICATION,"simple");

        try{
            connection = new InitialDirContext(pro);
            System.out.println("Connection: "+ connection);
        }
        catch(AuthenticationException e)
        {
            System.out.println(e.getMessage());
        }
        catch(NamingException e)
        {
            e.printStackTrace();
        }
       
    
    }

    public void getUsers()
    {
        String filter = "(objectClass=inetOrgPerson)";
        String [] req  = {"cn","sn","mobile"};
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(req);

        try{
             NamingEnumeration users = connection.search("dc=phone,dc=local", filter,controls);
             SearchResult res= null;
             while(users.hasMore())
             {
                 res = (SearchResult) users.next();
                 Attributes attr = res.getAttributes();
                 String checker = attr.get("cn").get(0).toString();
                 String n = checker.replace("cn: ", "");
                 String checker2 = attr.get("sn").get(0).toString();
                 String s = checker2.replace("sn: ", "");
                 String checker3 = attr.get("mobile").get(0).toString();
                 String m = checker3.replace("mobile: ", "");



                 System.out.println(n + " " + s+ ": "+ m);
             }
        }
        catch(NamingException e)
        {
            e.printStackTrace();
        }

        
    }

    public void search()
    {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter Name: ");

        String name = read.nextLine();

        System.out.print("Enter Surname: ");

        String surname = read.nextLine();

        String finalName ="cn: " + name;
        String finalSurname="sn: "+ surname;
        String fullname=finalName+finalSurname;

        String filter = "(&(cn="+name+")(sn="+surname+"))";
        String [] req  = {"cn","sn","mobile"};
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(req);

        try{
             NamingEnumeration users = connection.search("dc=phone,dc=local", filter,controls);
             SearchResult res= null;
             if(!users.hasMore())
             {
                System.out.println("Friend could not be found");
             }
             while(users.hasMore())
             {
                 res = (SearchResult) users.next();
                 Attributes attr = res.getAttributes();
                 String checker = attr.get("cn").get(0).toString();
                 String n = checker.replace("cn: ", "");
                 String checker2 = attr.get("sn").get(0).toString();
                 String s = checker2.replace("sn: ", "");
                 String checker3 = attr.get("mobile").get(0).toString();
                 String m = checker3.replace("mobile: ", "");



                 System.out.println(n + " " + s+ "'s " + "phone number is: "+ m);
                
             }
        }
        catch(NamingException e)
        {
            e.printStackTrace();
        }


    }

    public void delete()
    {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter Name: ");

        String name = read.nextLine();

        String child = "cn="+name+",ou=List,dc=Phone,dc=local";
        try{
            connection.destroySubcontext(child);
            System.out.println("Friend has been deleted.");
        }
        catch(NamingException e)
        {
            System.out.println("Friend could not be found.");
        }
    }
    public void add()
    {
        Attributes attributes = new BasicAttributes();
        BasicAttribute attribute = new BasicAttribute("ObjectClass");
        attribute.add("inetOrgPerson");

        attributes.put(attribute);

        Scanner read = new Scanner(System.in);
        System.out.print("Enter Name: ");

        String name = read.nextLine();

        System.out.print("Enter Surname: ");

        String surname = read.nextLine();

        System.out.print("Enter Number: ");

        String num = read.nextLine();

        attributes.put("cn",name);
        attributes.put("sn",surname);
        attributes.put("mobile",num);

        try{
            connection.createSubcontext("cn="+name+",ou=List,dc=phone,dc=local",attributes);
            System.out.println("Friend has been added.");
        }
        catch(NamingException e)
        {
            System.out.println("Friend already exists/invalid input");
        }




    }
}