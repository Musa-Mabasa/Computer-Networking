import java.net.*;
import java.io.*;
import javax.script.ScriptException;
import java.util.Scanner;
import java.io.FileNotFoundException;


 
public class Server
{
    //initialize socket and input stream
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       =  null;
    private String input="";
    String show ="";
    private Integer sum=0;
    private String firstIn;
    private Boolean val = false;
 
    // constructor with port
    public Server(int port) throws ScriptException
    {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");
 
            System.out.println("Waiting for a client ...");

            
            // takes input from the client socket
            // in = new DataInputStream(
            //     new BufferedInputStream(socket.getInputStream()));
 
            // String line = "";
 
            // reads message from client until "Over" is sent
            // while (!line.equals("Over"))
            // {
            //     try
            //     {
            //         line = in.readUTF();
            //         System.out.println(line);
 
            //     }
            //     catch(IOException i)
            //     {
            //         System.out.println(i);
            //     }
            // }
            //System.out.println("Closing connection");
 
            // close connection

            //socket = server.accept();
            //System.out.println("Client accepted");
            
           

            while(!server.isClosed())
            { 
                System.out.println("Close please3");
                if(socket==null ||socket.isClosed())
                {
                    socket = server.accept();
                }
                System.out.println("Client accepted");
                if(!val)
                {
                System.out.println("Goooo");
                
                    try{
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
            
                        out.println("HTTP/1.1 200 OK");
                        out.println("Content-Type: text/html");
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>COntactList</title>");
                        out.println("<link rel=\"stylesheet\" href=\"index.css\">");
                        out.println("</head>");
                        out.println("\r\n");
                        out.println("<body>");
                        out.println("<style>");
                        out.println("body{");
                        out.println("background: url(\"https://png.pngtree.com/thumb_back/fw800/background/20190223/ourmid/pngtree-smart-tech-blue-phone-background-backgroundmobile-phonenew-erauniverseintelligentstereoscopicilluminatetechnologydynamicgridbackgroundadvertising-image_72371.jpg\") no-repeat center center fixed;");
                        out.println("-webkit-background-size: cover;");
                        out.println("-moz-background-size: cover;");
                        out.println("-o-background-size: cover;");
                        out.println("background-size: cover;");
                        out.println("background-color: green");
                        out.println(" width: 100%;");
                        out.println(" height: 100%;");
                        out.println("}");
                        out.println("form{");
                        out.println("margin-left:150px");
                        out.println("}");
                        out.println(".inputer{");
                        out.println("position: absolute;");
                        out.println("width: 484px;");
                        out.println("background-color: black;");
                        out.println("padding: 5%;");
                        out.println("margin-left: 28%;");
                        out.println("margin-top: 10%;");
                        out.println("opacity: 0.8;");
                        out.println("border-radius: 2%;");
                        out.println("}");
                        out.println("#input{");
                        out.println("margin-top: 1%;");
                        out.println("margin-bottom: 1%;");
                        out.println("border: none;");
                        out.println("border-bottom: solid ;");
                        out.println("background: transparent;");
                        out.println("margin-left: 1%;");
                        out.println("width: 90%;");
                        out.println("color: white;");
                        out.println("}");
                        out.println("label{");
                        out.println("color: white;");
                        out.println("}");
                        out.println(".path{");
                        out.println("align-items: center;");
                        out.println("position: relative;");
                        out.println("color: blue;");
                        out.println("font-size: small;");
                        out.println("margin-left: 30%;");
                        out.println("}");
                        out.println("h1{");
                        out.println("color: white;");
                        out.println("margin-left: 42%;");
                        out.println("}");
                        out.println("</style>");
                        out.println("<div class=\"inputer\">");
                        out.println("<form method=\"get\" action=\"\">");
                        out.println("<div class=\"input_group\">");
                        out.println("<button type=\"submit\" name=\"view\" class=\"btn\">View Contact</button>");
                        out.println("</div><br>");
                        out.println("<div class=\"input_group\">");
                        out.println("<button type=\"submit\" name=\"Add\" class=\"btn\">Add Contact</button>");
                        out.println("</div><br>");
                        out.println("<div class=\"input_group\">");
                        out.println("<button type=\"submit\" name=\"Delete\" class=\"btn\">Delete Contact</button>");
                        out.println("</div><br>");
                        out.println("<div class=\"input_group\">");
                        out.println("<button type=\"submit\" name=\"Edit\" class=\"btn\">Edit Contact</button>");
                        out.println("</div><br>");
                        out.println("</form>");
                        out.println("</div>");
                        out.println("</body>");
                        out.println("</html>");
            
                        // in = new DataInputStream(
                        //     new BufferedInputStream(socket.getInputStream()));
            
                        // firstIn = in.readLine();
            
                        // System.out.println("Input1 "+firstIn);
                        out.flush();
            
                        out.close();
                        }
                        catch(IOException i)
                        {
                            System.out.println(i);
                        }

                    }
                    if(socket.isOutputShutdown())
                    {
                        System.out.println("connected");

                    }
                    if(socket.isClosed())
                    {
                        socket = server.accept();
                    }
                    System.out.println("after first");
                    in = new DataInputStream(
                        new BufferedInputStream(socket.getInputStream()));
        
                    firstIn = in.readLine();
        
                    System.out.println("Input1 "+firstIn);

                if(firstIn!=null)
                {
                    val = true;
                    String[] split = firstIn.split(" ");
                    for(String sp : split)
                    {
                        System.out.println("First "+sp);
                    }
                    String[] form = null;;
                    if(split.length > 1)
                    {
                        String[] que = split[1].split("\\?");

                        for(String ques : que)
                        {
                            System.out.println("Sec "+ques);
                        }
                        if(que.length>1)
                        {
                            form = que[1].split("\\=");
                        }
                        
                    }
                    
                    System.out.println("Form "+form[0]);
                    if(form != null)
                    {
                        if(form[0].equals("Add"))
                            {
                                Boolean addStatus = null;
                                while(!server.isClosed() && val)
                                {
                                    System.out.println("In addd");
                                    // socket = server.accept();
                                    try
                                    {
                                        System.out.println("whyyyyyyy");
                                        PrintWriter out = new PrintWriter(socket.getOutputStream());

                                        out.println("HTTP/1.1 200 OK");
                                        out.println("Content-Type: text/html");
                                        out.println("<!DOCTYPE html>");
                                        out.println("<html>");
                                        out.println("<head>");
                                        out.println("<title>COntactList</title>");
                                        out.println("<link rel=\"stylesheet\" href=\"index.css\">");
                                        out.println("</head>");
                                        out.println("\r\n");
                                        out.println("<body>");
                                        out.println("<style>");
                                        out.println("body{");
                                        out.println("border:1px solid black;");
                                        out.println("background: url(\"https://png.pngtree.com/thumb_back/fw800/background/20190223/ourmid/pngtree-smart-tech-blue-phone-background-backgroundmobile-phonenew-erauniverseintelligentstereoscopicilluminatetechnologydynamicgridbackgroundadvertising-image_72371.jpg\") no-repeat center center fixed;");
                                        out.println("-webkit-background-size: cover;");
                                        out.println("-moz-background-size: cover;");
                                        out.println("-o-background-size: cover;");
                                        out.println("background-size: cover;");
                                        out.println("background-color: green");
                                        out.println(" width: 100%;");
                                        out.println("}");
                                        out.println(".inputer{");
                                        out.println("position: absolute;");
                                        out.println("width: 484px;");
                                        out.println("background-color: black;");
                                        out.println("padding: 5%;");
                                        out.println("margin-left: 28%;");
                                        out.println("margin-up: 15%;");
                                        out.println("opacity: 0.8;");
                                        out.println("border-radius: 2%;");
                                        out.println("}");
                                        out.println("#input{");
                                        out.println("margin-top: 1%;");
                                        out.println("margin-bottom: 1%;");
                                        out.println("border: none;");
                                        out.println("border-bottom: solid ;");
                                        out.println("background: transparent;");
                                        out.println("margin-left: 1%;");
                                        out.println("width: 90%;");
                                        out.println("color: white;");
                                        out.println("}");
                                        out.println("label{");
                                        out.println("color: white;");
                                        out.println("}");
                                        out.println(".path{");
                                        out.println("align-items: center;");
                                        out.println("position: relative;");
                                        out.println("color: blue;");
                                        out.println("font-size: small;");
                                        out.println("margin-left: 30%;");
                                        out.println("}");
                                        out.println("h1{");
                                        out.println("color: white;");
                                        out.println("margin-left: 42%;");
                                        out.println("}");
                                        out.println("</style>");
                                        out.println("<div class=\"inputer\">");
                                        if(addStatus != null && addStatus)
                                        {
                                            out.println("<p style=\"color:green\">Contact has been added successfully</p>");
                                        }
                                        else if(addStatus != null && !addStatus)
                                        {
                                            out.println("<p style=\"color:red\">Contact has not been added successfully, add all fields</p>");
                                        }
                                        out.println("<form method=\"get\" action=\"\">");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<label>Name</label>");
                                        out.println("<input type=\"text\" name=\"name\" id=\"input\" placeholder=\"Enter name\"");
                                        out.println("</div>");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<label>Surname</label>");
                                        out.println("<input type=\"text\" name=\"surname\" id=\"input\" placeholder=\"Enter surname\"");
                                        out.println("</div>");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<label>Phone number</label>");
                                        out.println("<input type=\"text\" name=\"phone number\" id=\"input\" placeholder=\"Enter surname\"");
                                        out.println("</div>");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<button type=\"submit\" name=\"login\" class=\"btn\">Submit</button>");
                                        out.println("</div>");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<button type=\"submit\" name=\"menu\" class=\"btn\">Menu</button>");
                                        out.println("</div>");
                                        out.println("</form>");
                                        out.println("</div>");

                                        out.flush();

                                        out.close();

                                        socket = server.accept();

                                        in = new DataInputStream(
                                            new BufferedInputStream(socket.getInputStream()));
                            
                                        firstIn = in.readLine();
                            
                                        System.out.println("Input2 "+firstIn);

                                        String[] split2 = firstIn.split(" ");
                                        
                                        for(String sp : split)
                                        {
                                            System.out.println("First "+sp);
                                        }
                                        String[] form2 = null;
                                        if(split.length > 1)
                                        {
                                            String[] que2 = split2[1].split("\\?");

                                            for(String ques : que2)
                                            {
                                                System.out.println("Sec "+ques);
                                            }
                                            if(que2.length>1)
                                            {
                                                form2 = que2[1].split("\\&");
                                                for(String fo : form2)
                                                {
                                                    System.out.println("Third "+fo);
                                                }
                                                if(form2.length>1)
                                                {
                                                    String [] name = form2[0].split("\\=");
                                                    String [] surname = form2[1].split("\\=");
                                                    String [] num = form2[2].split("\\=");
                                                    try(FileWriter writer = new FileWriter("Contacts.txt",true);
                                                    BufferedWriter buf = new BufferedWriter(writer);
                                                    PrintWriter pri = new PrintWriter(buf))
                                                    {
                                                        if(name.length > 1 && surname.length > 1 && num.length >1)
                                                        {
                                                            pri.print(name[1]+",");
                                                            pri.print(surname[1]+",");
                                                            pri.println(num[1]);
                                                            addStatus = true;
                                                        }
                                                        else
                                                        {
                                                            addStatus = false;
                                                        }
                                                        
                                                        
                                                    }
                                                    catch(IOException e)
                                                    {
                                                        System.out.println(e);
                                                    }
                                                    String [] decide = form2[3].split("\\=");

                                                    System.out.println("Menu "+decide[0]);


                                                    if(decide[0].equals("menu"))
                                                    {
                                                        val = false;
                                                        PrintWriter out2 = new PrintWriter(socket.getOutputStream());

                                                        out2.flush();
                                                        // out2.close();
                                                    }
                                                


                                                }
                                            }
                                            
                                        }
                                        
                                    }
                                    catch(IOException i)
                                    {
                                        System.out.println(i);
                                    }
                                    System.out.println("Musaaa: "+Boolean.toString(val));
                                }
                                
                            }
                            else if(form[0].equals("Delete"))
                            {
                                Boolean delStatus = null;
                                while(!server.isClosed() && val)
                                {

                                    System.out.println("In del");
                                    // socket = server.accept();
                                    try
                                    {
                                        System.out.println("whyyyyyyy");
                                        PrintWriter out = new PrintWriter(socket.getOutputStream());

                                        out.println("HTTP/1.1 200 OK");
                                        out.println("Content-Type: text/html");
                                        out.println("<!DOCTYPE html>");
                                        out.println("<html>");
                                        out.println("<head>");
                                        out.println("<title>COntactList</title>");
                                        out.println("<link rel=\"stylesheet\" href=\"index.css\">");
                                        out.println("</head>");
                                        out.println("\r\n");
                                        out.println("<body>");
                                        out.println("<style>");
                                        out.println("body{");
                                        out.println("border:1px solid black;");
                                        out.println("background: url(\"https://png.pngtree.com/thumb_back/fw800/background/20190223/ourmid/pngtree-smart-tech-blue-phone-background-backgroundmobile-phonenew-erauniverseintelligentstereoscopicilluminatetechnologydynamicgridbackgroundadvertising-image_72371.jpg\") no-repeat center center fixed;");
                                        out.println("-webkit-background-size: cover;");
                                        out.println("-moz-background-size: cover;");
                                        out.println("-o-background-size: cover;");
                                        out.println("background-size: cover;");
                                        out.println("background-color: green");
                                        out.println(" width: 100%;");
                                        out.println("}");
                                        out.println(".inputer{");
                                        out.println("position: absolute;");
                                        out.println("width: 484px;");
                                        out.println("background-color: black;");
                                        out.println("padding: 5%;");
                                        out.println("margin-left: 28%;");
                                        out.println("margin-up: 15%;");
                                        out.println("opacity: 0.8;");
                                        out.println("border-radius: 2%;");
                                        out.println("}");
                                        out.println("#input{");
                                        out.println("margin-top: 1%;");
                                        out.println("margin-bottom: 1%;");
                                        out.println("border: none;");
                                        out.println("border-bottom: solid ;");
                                        out.println("background: transparent;");
                                        out.println("margin-left: 1%;");
                                        out.println("width: 90%;");
                                        out.println("color: white;");
                                        out.println("}");
                                        out.println("label{");
                                        out.println("color: white;");
                                        out.println("}");
                                        out.println(".path{");
                                        out.println("align-items: center;");
                                        out.println("position: relative;");
                                        out.println("color: blue;");
                                        out.println("font-size: small;");
                                        out.println("margin-left: 30%;");
                                        out.println("}");
                                        out.println("h1{");
                                        out.println("color: white;");
                                        out.println("margin-left: 42%;");
                                        out.println("}");
                                        out.println("</style>");
                                        out.println("<div class=\"inputer\">");
                                        if(delStatus != null && !delStatus)
                                        {
                                            out.println("<p style=\"color:red\">Couldn't delete non existent contact.</p>");
                                        }
                                        else if(delStatus != null && delStatus)
                                        {
                                            out.println("<p style=\"color:green\">Contact has been deleted.</p>");
                                            delStatus = false;

                                        }
                                        out.println("<form method=\"get\" action=\"\">");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<label>Name</label>");
                                        out.println("<input type=\"text\" name=\"name\" id=\"input\" placeholder=\"Enter name\"");
                                        out.println("</div>");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<label>Surname</label>");
                                        out.println("<input type=\"text\" name=\"surname\" id=\"input\" placeholder=\"Enter surname\"");
                                        out.println("</div>");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<button type=\"submit\" name=\"login\" class=\"btn\">Submit</button>");
                                        out.println("</div>");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<button type=\"submit\" name=\"menu\" class=\"btn\">Menu</button>");
                                        out.println("</div>");
                                        out.println("</form>");
                                        out.println("</div>");

                                        out.flush();

                                        out.close();

                                        socket = server.accept();

                                        in = new DataInputStream(
                                            new BufferedInputStream(socket.getInputStream()));
                            
                                        firstIn = in.readLine();
                            
                                        System.out.println("Input2 "+firstIn);

                                        String[] split2 = firstIn.split(" ");
                                        
                                        for(String sp : split)
                                        {
                                            System.out.println("First "+sp);
                                        }
                                        String[] form2 = null;
                                        if(split.length > 1)
                                        {
                                            String[] que2 = split2[1].split("\\?");

                                            for(String ques : que2)
                                            {
                                                System.out.println("Sec "+ques);
                                            }
                                            if(que2.length>1)
                                            {
                                                form2 = que2[1].split("\\&");
                                                for(String fo : form2)
                                                {
                                                    System.out.println("Third "+fo);
                                                }
                                                if(form2.length>1)
                                                {
                                                    File oldFile = new  File("Contacts.txt");
                                                    File newFIle = new  File("temp.txt");
                                                    int count =0;
                                                    String [] name = form2[0].split("\\=");
                                                    String [] surname = form2[1].split("\\=");
                                                    if(name.length > 1 && surname.length > 1)
                                                    {
                                                        String num="";
                                                        
                                                        String toRemove ="";
                                                        
                                                        toRemove += name[1]+ "," + surname[1]+ "," + num;
                                                        System.out.println("Remove: "+ toRemove);

                                                        String current;
                                                        String data[];

                                                        try  
                                                        {
                                                            FileWriter fw = new FileWriter("temp.txt",true);
                                                            BufferedWriter bw = new BufferedWriter(fw);
                                                            PrintWriter pw = new PrintWriter(bw);

                                                            FileReader fr = new FileReader("Contacts.txt");
                                                            BufferedReader br = new BufferedReader(fr);
                                                            delStatus = false;
                                                            while((current = br.readLine()) != null)
                                                            {
                                                                data = current.split(",");
                                                                String oriName = name[1]+surname[1];
                                                                String secName = data[0]+data[1]; 
                                                                if(!oriName.equals(secName))
                                                                {
                                                                    pw.println(current);
                                                                }
                                                                else
                                                                {
                                                                    delStatus = true;
                                                                }
                                                            }

                                                            pw.flush();
                                                            pw.close();
                                                            fr.close();
                                                            br.close();
                                                            bw.close();
                                                            fw.close();

                                                            oldFile.delete();
                                                            File dump = new File("Contacts.txt");
                                                            newFIle.renameTo(dump);
                                                        }
                                                        catch(IOException i)
                                                        {

                                                        }
                                                    }
                                                    else{
                                                        delStatus = false;
                                                    }
                                                    

                                                    String [] decide = form2[2].split("\\=");

                                                    System.out.println("Menu "+decide[0]);


                                                    if(decide[0].equals("menu"))
                                                    {
                                                        val = false;
                                                        PrintWriter out2 = new PrintWriter(socket.getOutputStream());

                                                        out2.flush();
                                                        // out2.close();
                                                    }
                                                


                                                }
                                            }
                                            
                                        }
                                        
                                    }
                                    catch(IOException i)
                                    {
                                        System.out.println(i);
                                    }
                                    System.out.println("Musaaa: "+Boolean.toString(val));
                                }
                                
                            }
                            else if(form[0].equals("Edit"))
                            {
                                Boolean delStatus = null;
                                Boolean outOFHere = false;
                                while(!server.isClosed())
                                {

                                    System.out.println("In del");
                                    // socket = server.accept();
                                    try
                                    {
                                        System.out.println("whyyyyyyy");
                                        PrintWriter out = new PrintWriter(socket.getOutputStream());

                                        out.println("HTTP/1.1 200 OK");
                                        out.println("Content-Type: text/html");
                                        out.println("<!DOCTYPE html>");
                                        out.println("<html>");
                                        out.println("<head>");
                                        out.println("<title>COntactList</title>");
                                        out.println("<link rel=\"stylesheet\" href=\"index.css\">");
                                        out.println("</head>");
                                        out.println("\r\n");
                                        out.println("<body>");
                                        out.println("<style>");
                                        out.println("body{");
                                        out.println("border:1px solid black;");
                                        out.println("background: url(\"https://png.pngtree.com/thumb_back/fw800/background/20190223/ourmid/pngtree-smart-tech-blue-phone-background-backgroundmobile-phonenew-erauniverseintelligentstereoscopicilluminatetechnologydynamicgridbackgroundadvertising-image_72371.jpg\") no-repeat center center fixed;");
                                        out.println("-webkit-background-size: cover;");
                                        out.println("-moz-background-size: cover;");
                                        out.println("-o-background-size: cover;");
                                        out.println("background-size: cover;");
                                        out.println("background-color: green");
                                        out.println(" width: 100%;");
                                        out.println("}");
                                        out.println(".inputer{");
                                        out.println("position: absolute;");
                                        out.println("width: 484px;");
                                        out.println("background-color: black;");
                                        out.println("padding: 5%;");
                                        out.println("margin-left: 28%;");
                                        out.println("margin-up: 15%;");
                                        out.println("opacity: 0.8;");
                                        out.println("border-radius: 2%;");
                                        out.println("}");
                                        out.println("#input{");
                                        out.println("margin-top: 1%;");
                                        out.println("margin-bottom: 1%;");
                                        out.println("border: none;");
                                        out.println("border-bottom: solid ;");
                                        out.println("background: transparent;");
                                        out.println("margin-left: 1%;");
                                        out.println("width: 90%;");
                                        out.println("color: white;");
                                        out.println("}");
                                        out.println("label{");
                                        out.println("color: white;");
                                        out.println("}");
                                        out.println(".path{");
                                        out.println("align-items: center;");
                                        out.println("position: relative;");
                                        out.println("color: blue;");
                                        out.println("font-size: small;");
                                        out.println("margin-left: 30%;");
                                        out.println("}");
                                        out.println("h1{");
                                        out.println("color: white;");
                                        out.println("margin-left: 42%;");
                                        out.println("}");
                                        out.println("</style>");
                                        out.println("<div class=\"inputer\">");
                                        if(delStatus != null && !delStatus)
                                        {
                                            out.println("<p style=\"color:red\">Couldn't edit non existent contact.</p>");
                                        }
                                        else if(delStatus != null && delStatus)
                                        {
                                            out.println("<p style=\"color:green\">Contact has been edited.</p>");
                                            delStatus = false;

                                        }
                                        out.println("<form method=\"get\" action=\"\">");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<label>Name</label>");
                                        out.println("<input type=\"text\" name=\"name\" id=\"input\" placeholder=\"Enter name to edit\"");
                                        out.println("</div>");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<label>Surname</label>");
                                        out.println("<input type=\"text\" name=\"surname\" id=\"input\" placeholder=\"Enter surname to edit\"");
                                        out.println("</div>");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<button type=\"submit\" name=\"login\" class=\"btn\">Edit</button>");
                                        out.println("</div>");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<button type=\"submit\" name=\"menu\" class=\"btn\">Menu</button>");
                                        out.println("</div>");
                                        out.println("</form>");
                                        out.println("</div>");

                                        out.flush();

                                        out.close();

                                        socket = server.accept();

                                        in = new DataInputStream(
                                            new BufferedInputStream(socket.getInputStream()));
                            
                                        firstIn = in.readLine();
                            
                                        System.out.println("Input2 "+firstIn);

                                        String[] split2 = firstIn.split(" ");
                                        
                                        for(String sp : split)
                                        {
                                            System.out.println("First "+sp);
                                        }
                                        String[] form2 = null;
                                        if(split.length > 1)
                                        {
                                            String[] que2 = split2[1].split("\\?");

                                            for(String ques : que2)
                                            {
                                                System.out.println("Sec "+ques);
                                            }
                                            if(que2.length>1)
                                            {
                                                form2 = que2[1].split("\\&");
                                                for(String fo : form2)
                                                {
                                                    System.out.println("Third "+fo);
                                                }
                                                if(form2.length>1)
                                                {
                                                    File oldFile = new  File("Contacts.txt");
                                                    File newFIle = new  File("temp.txt");

                                                    String [] name = form2[0].split("\\=");
                                                    String [] surname = form2[1].split("\\=");
                                                    if(name.length > 1 && surname.length > 1)
                                                    {
                                                        String num="";
                                                        
                                                        String toRemove ="";
                                                        
                                                        toRemove += name[1]+ "," + surname[1]+ "," + num;
                                                        System.out.println("Remove: "+ toRemove);

                                                        String current;
                                                        String data[];

                                                        try  
                                                        {
                                                            FileWriter fw = new FileWriter("temp.txt",true);
                                                            BufferedWriter bw = new BufferedWriter(fw);
                                                            PrintWriter pw = new PrintWriter(bw);

                                                            FileReader fr = new FileReader("Contacts.txt");
                                                            BufferedReader br = new BufferedReader(fr);
                                                            delStatus = false;
                                                            while((current = br.readLine()) != null)
                                                            {
                                                                data = current.split(",");
                                                                String oriName = name[1]+surname[1];
                                                                String secName = data[0]+data[1]; 
                                                                if(!oriName.equals(secName))
                                                                {
                                                                    pw.println(current);
                                                                }
                                                                else
                                                                {
                                                                    delStatus = true;
                                                                    outOFHere = true;
                                                                }
                                                            }

                                                            pw.flush();
                                                            pw.close();
                                                            fr.close();
                                                            br.close();
                                                            bw.close();
                                                            fw.close();

                                                            oldFile.delete();
                                                            File dump = new File("Contacts.txt");
                                                            newFIle.renameTo(dump);
                                                        }
                                                        catch(IOException i)
                                                        {

                                                        }
                                                    }
                                                    else{
                                                        delStatus = false;
                                                    }
                                                    

                                                    String [] decide = form2[2].split("\\=");

                                                    System.out.println("Menu "+decide[0]);


                                                    if(decide[0].equals("menu"))
                                                    {
                                                        val = false;
                                                        PrintWriter out2 = new PrintWriter(socket.getOutputStream());

                                                        out2.flush();
                                                        // out2.close();
                                                    }
                                                


                                                }
                                            }
                                            
                                        }
                                        
                                    }
                                    catch(IOException i)
                                    {
                                        System.out.println(i);
                                    }
                                    System.out.println("Musaaa: "+Boolean.toString(val));
                                    if(outOFHere)
                                    {
                                        break;
                                    }
                                }
                                
                                Boolean addStatus = null;
                                Boolean outOfHere2 = null;
                                while(!server.isClosed())
                                {
                                    System.out.println("In addd");
                                    // socket = server.accept();
                                    try
                                    {
                                        System.out.println("whyyyyyyy");
                                        PrintWriter out = new PrintWriter(socket.getOutputStream());

                                        out.println("HTTP/1.1 200 OK");
                                        out.println("Content-Type: text/html");
                                        out.println("<!DOCTYPE html>");
                                        out.println("<html>");
                                        out.println("<head>");
                                        out.println("<title>COntactList</title>");
                                        out.println("<link rel=\"stylesheet\" href=\"index.css\">");
                                        out.println("</head>");
                                        out.println("\r\n");
                                        out.println("<body>");
                                        out.println("<style>");
                                        out.println("body{");
                                        out.println("border:1px solid black;");
                                        out.println("background: url(\"https://png.pngtree.com/thumb_back/fw800/background/20190223/ourmid/pngtree-smart-tech-blue-phone-background-backgroundmobile-phonenew-erauniverseintelligentstereoscopicilluminatetechnologydynamicgridbackgroundadvertising-image_72371.jpg\") no-repeat center center fixed;");
                                        out.println("-webkit-background-size: cover;");
                                        out.println("-moz-background-size: cover;");
                                        out.println("-o-background-size: cover;");
                                        out.println("background-size: cover;");
                                        out.println("background-color: green");
                                        out.println(" width: 100%;");
                                        out.println("}");
                                        out.println(".inputer{");
                                        out.println("position: absolute;");
                                        out.println("width: 484px;");
                                        out.println("background-color: black;");
                                        out.println("padding: 5%;");
                                        out.println("margin-left: 28%;");
                                        out.println("margin-up: 15%;");
                                        out.println("opacity: 0.8;");
                                        out.println("border-radius: 2%;");
                                        out.println("}");
                                        out.println("#input{");
                                        out.println("margin-top: 1%;");
                                        out.println("margin-bottom: 1%;");
                                        out.println("border: none;");
                                        out.println("border-bottom: solid ;");
                                        out.println("background: transparent;");
                                        out.println("margin-left: 1%;");
                                        out.println("width: 90%;");
                                        out.println("color: white;");
                                        out.println("}");
                                        out.println("label{");
                                        out.println("color: white;");
                                        out.println("}");
                                        out.println(".path{");
                                        out.println("align-items: center;");
                                        out.println("position: relative;");
                                        out.println("color: blue;");
                                        out.println("font-size: small;");
                                        out.println("margin-left: 30%;");
                                        out.println("}");
                                        out.println("h1{");
                                        out.println("color: white;");
                                        out.println("margin-left: 42%;");
                                        out.println("}");
                                        out.println("</style>");
                                        out.println("<div class=\"inputer\">");
                                        if(addStatus != null && addStatus)
                                        {
                                            out.println("<p style=\"color:green\">Contact has been edited successfully</p>");
                                        }
                                        else if(addStatus != null && !addStatus)
                                        {
                                            out.println("<p style=\"color:red\">Contact has not been edited successfully, add all fields</p>");
                                        }
                                        out.println("<form method=\"get\" action=\"\">");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<label>Name</label>");
                                        out.println("<input type=\"text\" name=\"name\" id=\"input\" placeholder=\"Enter name\"");
                                        out.println("</div>");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<label>Surname</label>");
                                        out.println("<input type=\"text\" name=\"surname\" id=\"input\" placeholder=\"Enter surname\"");
                                        out.println("</div>");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<label>Phone number</label>");
                                        out.println("<input type=\"text\" name=\"phone number\" id=\"input\" placeholder=\"Enter surname\"");
                                        out.println("</div>");
                                        out.println("<div class=\"input_group\">");
                                        out.println("<button type=\"submit\" name=\"menu\" class=\"btn\">Submit</button>");
                                        out.println("</div>");
                                        // out.println("<div class=\"input_group\">");
                                        // out.println("<button type=\"submit\" name=\"menu\" class=\"btn\">Menu</button>");
                                        // out.println("</div>");
                                        out.println("</form>");
                                        out.println("</div>");

                                        out.flush();

                                        out.close();

                                        socket = server.accept();

                                        in = new DataInputStream(
                                            new BufferedInputStream(socket.getInputStream()));
                            
                                        firstIn = in.readLine();
                            
                                        System.out.println("Input2 "+firstIn);

                                        String[] split2 = firstIn.split(" ");
                                        
                                        for(String sp : split)
                                        {
                                            System.out.println("First "+sp);
                                        }
                                        String[] form2 = null;
                                        if(split.length > 1)
                                        {
                                            String[] que2 = split2[1].split("\\?");

                                            for(String ques : que2)
                                            {
                                                System.out.println("Sec "+ques);
                                            }
                                            if(que2.length>1)
                                            {
                                                form2 = que2[1].split("\\&");
                                                for(String fo : form2)
                                                {
                                                    System.out.println("Third "+fo);
                                                }
                                                if(form2.length>1)
                                                {
                                                    String [] name = form2[0].split("\\=");
                                                    String [] surname = form2[1].split("\\=");
                                                    String [] num = form2[2].split("\\=");
                                                    try(FileWriter writer = new FileWriter("Contacts.txt",true);
                                                    BufferedWriter buf = new BufferedWriter(writer);
                                                    PrintWriter pri = new PrintWriter(buf))
                                                    {
                                                        if(name.length > 1 && surname.length > 1 && num.length >1)
                                                        {
                                                            pri.print(name[1]+",");
                                                            pri.print(surname[1]+",");
                                                            pri.println(num[1]);
                                                            outOfHere2 = true;
                                                        }
                                                        else
                                                        {
                                                            addStatus = false;
                                                        }
                                                        
                                                        
                                                    }
                                                    catch(IOException e)
                                                    {
                                                        System.out.println(e);
                                                    }
                                                    String [] decide = form2[3].split("\\=");

                                                    System.out.println("Menu "+decide[0]);


                                                    if(decide[0].equals("menu"))
                                                    {
                                                        val = false;
                                                        PrintWriter out2 = new PrintWriter(socket.getOutputStream());

                                                        out2.flush();
                                                        // out2.close();
                                                    }
                                                


                                                }
                                            }
                                            
                                        }
                                        
                                    }
                                    catch(IOException i)
                                    {
                                        System.out.println(i);
                                    }
                                    System.out.println("Musaaa: "+Boolean.toString(val));
                                    if(outOfHere2)
                                    {
                                        break;
                                    }
                                }

                            }

                        }
                    }
                    System.out.println("Close please");
                    
                }
                        
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        
    }
    
 
    public static void main(String args[]) throws ScriptException
    {
        Server server = new Server(5005);
    }
}