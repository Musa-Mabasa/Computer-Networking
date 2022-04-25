import java.net.*;
import java.io.*;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.FileWriter;

 
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
    private Boolean val;
 
    // constructor with port
    public Server(int port) throws ScriptException
    {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");
 
            System.out.println("Waiting for a client ...");
 
            socket = server.accept();
            System.out.println("Client accepted");
            
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
                out.println("<form method=\"get\" action=\"\">");
                out.println("<div class=\"input_group\">");
                out.println("<button type=\"submit\" name=\"view\" class=\"btn\">View Contact</button>");
                out.println("</div>");
                out.println("<div class=\"input_group\">");
                out.println("<button type=\"submit\" name=\"Add\" class=\"btn\">Add Contact</button>");
                out.println("</div>");
                out.println("<div class=\"input_group\">");
                out.println("<button type=\"submit\" name=\"Delete\" class=\"btn\">Delete Contact</button>");
                out.println("</div>");
                out.println("<div class=\"input_group\">");
                out.println("<button type=\"submit\" name=\"Edit\" class=\"btn\">Edit Contact</button>");
                out.println("</div>");
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

            while(!server.isClosed())
            {
                System.out.println("hereeeee");
                socket = server.accept();
                System.out.println("Client accepted");

                    in = new DataInputStream(
                        new BufferedInputStream(socket.getInputStream()));
        
                    firstIn = in.readLine();
        
                    System.out.println("Input1 "+firstIn);

                if(firstIn!=null)
                {
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
                                System.out.println("In addd");
                                //socket = server.accept();
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
                                    out.println("<button type=\"submit\" name=\"view\" class=\"btn\">View Contact</button>");
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
                                                try
                                                {
                                                    FileWriter writer = new FileWriter("Contacts.txt");
                                                    System.out.println("Name "+name[1]);
                                                    writer.write(name[1]+",");
                                                    writer.write(surname[1]+",");
                                                    writer.write(num[1]);
                                                    writer.close();
                                                    
                                                }
                                                catch(IOException e)
                                                {
                                                    System.out.println(e);
                                                }
                                               

                                            }
                                        }
                                        
                                    }
                                    
                                }
                                catch(IOException i)
                                {
                                    System.out.println(i);
                                }
                            }
                        }
                    }
                    
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