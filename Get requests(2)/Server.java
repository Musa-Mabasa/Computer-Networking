import java.net.*;
import java.util.EnumSet;
import java.io.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

 
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

            socket = server.accept();
            System.out.println("Client accepted");
            
            // try{
            // PrintWriter out = new PrintWriter(socket.getOutputStream());

            // out.println("HTTP/1.1 200 OK");
            // out.println("Content-Type: text/html");
            // out.println("<!DOCTYPE html>");
            // out.println("<html>");
            // out.println("<head>");
            // out.println("<title>COntactList</title>");
            // out.println("<link rel=\"stylesheet\" href=\"index.css\">");
            // out.println("</head>");
            // out.println("\r\n");
            // out.println("<body>");
            // out.println("<style>");
            // out.println("body{");
            // out.println("border:1px solid black;");
            // // out.println("background: url(\"../img/background.jpg\") no-repeat center center fixed;");
            // out.println("-webkit-background-size: cover;");
            // out.println("-moz-background-size: cover;");
            // out.println("-o-background-size: cover;");
            // out.println("background-size: cover;");
            // out.println("background-color: green");
            // out.println(" width: 100%;");
            // out.println("}");
            // out.println(".inputer{");
            // out.println("position: absolute;");
            // out.println("width: 484px;");
            // out.println("background-color: black;");
            // out.println("padding: 5%;");
            // out.println("margin-left: 28%;");
            // out.println("margin-up: 15%;");
            // out.println("opacity: 0.8;");
            // out.println("border-radius: 2%;");
            // out.println("}");
            // out.println("#input{");
            // out.println("margin-top: 1%;");
            // out.println("margin-bottom: 1%;");
            // out.println("border: none;");
            // out.println("border-bottom: solid ;");
            // out.println("background: transparent;");
            // out.println("margin-left: 1%;");
            // out.println("width: 90%;");
            // out.println("color: white;");
            // out.println("}");
            // out.println("label{");
            // out.println("color: white;");
            // out.println("}");
            // out.println(".path{");
            // out.println("align-items: center;");
            // out.println("position: relative;");
            // out.println("color: blue;");
            // out.println("font-size: small;");
            // out.println("margin-left: 30%;");
            // out.println("}");
            // out.println("h1{");
            // out.println("color: white;");
            // out.println("margin-left: 42%;");
            // out.println("}");
            // out.println("</style>");
            // out.println("<div class=\"inputer\">");
            // out.println("<form method=\"get\" action=\"\">");
            // out.println("<div class=\"input_group\">");
            // out.println("<label>Name</label>");
            // out.println("<input type=\"text\" name=\"name\" id=\"input\" placeholder=\"Enter name\"");
            // out.println("</div>");
            // out.println("<div class=\"input_group\">");
            // out.println("<button type=\"submit\" name=\"view\" class=\"btn\">View Contact</button>");
            // out.println("</div>");
            // out.println("<div class=\"input_group\">");
            // out.println("<button type=\"submit\" name=\"Add\" class=\"btn\">Add Contact</button>");
            // out.println("</div>");
            // out.println("<div class=\"input_group\">");
            // out.println("<button type=\"submit\" name=\"Delete\" class=\"btn\">Delete Contact</button>");
            // out.println("</div>");
            // out.println("<div class=\"input_group\">");
            // out.println("<button type=\"submit\" name=\"Edit\" class=\"btn\">Edit Contact</button>");
            // out.println("</div>");
            // out.println("</form>");
            // out.println("</div>");
            // out.println("</body>");
            // out.println("</html>");

            // in = new DataInputStream(
            //     new BufferedInputStream(socket.getInputStream()));

            // firstIn = in.readLine();

            // System.out.println("Input1 "+firstIn);
            // out.flush();

            // out.close();
            // }
            // catch(IOException i)
            // {
            //     System.out.println(i);
            // }

            while(!server.isClosed())
            {
                System.out.println("hereeeee");
                socket = server.accept();

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
                    // out.println("background: url(\"../img/background.jpg\") no-repeat center center fixed;");
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
        
                    in = new DataInputStream(
                        new BufferedInputStream(socket.getInputStream()));
        
                    firstIn = in.readLine();
        
                    System.out.println("Input1 "+firstIn);
                    out.flush();
        
                    out.close();
                    }
                    catch(IOException i)
                    {
                        System.out.println(i);
                    }

                if(firstIn!=null)
                {
                    String[] split = firstIn.split(" ");
                    for(String sp : split)
                    {
                        System.out.println("First "+sp);
                    }
                    String[] que = split[1].split("\\?");
                    for(String ques : que)
                    {
                        System.out.println("Sec "+ques);
                    }
                    String[] form = que[1].split("\\=");

                    if(form[0].equals("Add"))
                    {
                        socket = server.accept();
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
                            // out.println("background: url(\"../img/background.jpg\") no-repeat center center fixed;");
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

                            in = new DataInputStream(
                                new BufferedInputStream(socket.getInputStream()));
                
                            firstIn = in.readLine();
                
                            System.out.println("Input2 "+firstIn);

                            out.flush();

                            out.close();
                        }
                        catch(IOException i)
                        {
                            System.out.println(i);
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
        Server server = new Server(5004);
    }
}