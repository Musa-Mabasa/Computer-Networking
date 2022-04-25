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
            try{
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculator</title>");
            out.println("<link rel=\"stylesheet\" href=\"index.css\">");
            out.println("</head>");
            out.println("\r\n");
            out.println("<body>");
            out.println("<style>");
            out.println("table,th{");
            out.println("border:1px solid black;");
            out.println("}");
            out.println("th{");
            out.println("background-color: #ddd");
            out.println("}");
            out.println("table{");
            out.println("background-color: green");
            out.println("}");
            out.println("a{");
            out.println("text-decoration: none");
            out.println("}");
            out.println("a:visited{");
            out.println("color:inherit");
            out.println("}");
            out.println(".answerBox{");
            out.println("background-color: #ddd");
            out.println("width:45%");
            out.println("height:60px");
            out.println("}");
            out.println("</style>");
            out.println("<table style=\"width: 45%\"  style=\"border:1px solid black]\">");
            out.println("<div id=\"calculator\">");
            out.println("<div class=\"answerBox\">");
            out.println("<p id=\"answer\">Answer: </p>");
            out.println("</div>");
            out.println("<div id=\"Numbers\">");
            out.println("<tr>");
            out.println("<th><div class=\"num\" id=\"One\"><a href=\"0\">0</a></div></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th><div class=\"num\" id=\"Two\"><a href=\"1\">1</a></div></th>");
            out.println("<th><div class=\"num\" id=\"Four\"><a href=\"2\">2</a></div></th>");
            out.println("<th><div class=\"num\" id=\"Three\"><a href=\"3\">3</a></div></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th><div class=\"num\" id=\"Four\"><a href=\"4\">4</a></div></th>");
            out.println("<th><div class=\"num\" id=\"Five\"><a href=\"5\">5</a></div></th>");
            out.println("<th><div class=\"num\" id=\"Six\"><a href=\"6\">6</a></div></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th><div class=\"num\" id=\"Seven\"><a href=\"7\">7</a></div></th>");
            out.println("<th><div class=\"num\" id=\"Eight\"><a href=\"8\">8</a></div></th>");
            out.println("<th><div class=\"num\" id=\"Nine\"><a href=\"9\">9</a></div></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th><div class=\"operation\" id=\"add\"><a href=\"+\">+</a></div></th>");
            out.println("<th><div class=\"operation\" id=\"subtract\"><a href=\"-\">-</a></div></th>");
            out.println("<th><div class=\"operation\" id=\"multiply\"><a href=\"*\">x</a></div></th>");
            out.println("<th><div class=\"operation\" id=\"divide\"><a href=\"/\">/</a></div></th>");
            out.println("<th><div class=\"operation\" id=\"equals\"><a href=\"=\">=</a></div></th>");
            out.println("</tr>");
            out.println("</div>");
            out.println("</div>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

            out.flush();

            out.close();
            }
            catch(IOException i)
            {
                System.out.println(i);
            }

            while(!server.isClosed())
            {
                socket = server.accept();

                in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));

            String inputBuf = in.readLine();

            // System.out.println(inputBuf);

            if(inputBuf!=null)
            {
                    String[] splits = inputBuf.split(" ");
                    
                        //    if(splits[0]=="GET")
                        //    {
                        //     out.println("<h3>gettttt</h3>");
                        //        if(splits[1].charAt(0)=='/')
                        //        {
                        //            out.println("<h3>Whyyyyyyyy</h3>");

                        //        }
                        //    }
                    
                        
                    if(splits[1].length()>1)
                    {
                        
                        if(Character.isDigit(splits[1].charAt(1)))
                        {
                            input+=splits[1].charAt(1);
                            
                            show+= splits[1].charAt(1);  

                            try{
                                PrintWriter out = new PrintWriter(socket.getOutputStream());
    
                                out.println("HTTP/1.1 200 OK");
                                out.println("Content-Type: text/html");
                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>Calculator</title>");
                                out.println("<link rel=\"stylesheet\" href=\"index.css\">");
                                out.println("</head>");
                                out.println("\r\n");
                                out.println("<body>");
                                out.println("<style>");
                                out.println("table,th{");
                                out.println("border:1px solid black;");
                                out.println("}");
                                out.println("th{");
                                out.println("background-color: #ddd");
                                out.println("}");
                                out.println("table{");
                                out.println("background-color: green");
                                out.println("}");
                                out.println("a{");
                                out.println("text-decoration: none");
                                out.println("}");
                                out.println("a:visited{");
                                out.println("color:inherit");
                                out.println("}");
                                out.println(".answerBox{");
                                out.println("background-color: #ddd");
                                out.println("width:45%");
                                out.println("height:60px");
                                out.println("}");
                                out.println("</style>");
                                out.println("<table style=\"width: 45%\"  style=\"border:1px solid black]\">");
                                out.println("<div id=\"calculator\">");
                                out.println("<div class=\"answerBox\">");
                                out.println("<p id=\"answer\">Answer:"+ show +" </p>");
                                out.println("</div>");
                                out.println("<div id=\"Numbers\">");
                                out.println("<tr>");
                                out.println("<th><div class=\"num\" id=\"One\"><a href=\"0\">0</a></div></th>");
                                out.println("</tr>");
                                out.println("<tr>");
                                out.println("<th><div class=\"num\" id=\"Two\"><a href=\"1\">1</a></div></th>");
                                out.println("<th><div class=\"num\" id=\"Four\"><a href=\"2\">2</a></div></th>");
                                out.println("<th><div class=\"num\" id=\"Three\"><a href=\"3\">3</a></div></th>");
                                out.println("</tr>");
                                out.println("<tr>");
                                out.println("<th><div class=\"num\" id=\"Four\"><a href=\"4\">4</a></div></th>");
                                out.println("<th><div class=\"num\" id=\"Five\"><a href=\"5\">5</a></div></th>");
                                out.println("<th><div class=\"num\" id=\"Six\"><a href=\"6\">6</a></div></th>");
                                out.println("</tr>");
                                out.println("<tr>");
                                out.println("<th><div class=\"num\" id=\"Seven\"><a href=\"7\">7</a></div></th>");
                                out.println("<th><div class=\"num\" id=\"Eight\"><a href=\"8\">8</a></div></th>");
                                out.println("<th><div class=\"num\" id=\"Nine\"><a href=\"9\">9</a></div></th>");
                                out.println("</tr>");
                                out.println("<tr>");
                                out.println("<th><div class=\"operation\" id=\"add\"><a href=\"+\">+</a></div></th>");
                                out.println("<th><div class=\"operation\" id=\"subtract\"><a href=\"-\">-</a></div></th>");
                                out.println("<th><div class=\"operation\" id=\"multiply\"><a href=\"*\">x</a></div></th>");
                                out.println("<th><div class=\"operation\" id=\"divide\"><a href=\"/\">/</a></div></th>");
                                out.println("<th><div class=\"operation\" id=\"equals\"><a href=\"=\">=</a></div></th>");
                                out.println("</tr>");
                                out.println("</div>");
                                out.println("</div>");
                                out.println("</table>");
                                out.println("</body>");
                                out.println("</html>");
    
                            
                    
                    
                                out.flush();
    
                                out.close();
                            }
                            catch(IOException i)
                            {
                                System.out.println(i);
                            }
                        }
                        else if(splits[1].charAt(1) == '/' || splits[1].charAt(1) == '*' || splits[1].charAt(1) == '+' || splits[1].charAt(1) == '-')
                        {
                            show="";
                            input+=splits[1].charAt(1);

                            try{
                                PrintWriter out = new PrintWriter(socket.getOutputStream());
                            out.println("HTTP/1.1 200 OK");
                            out.println("Content-Type: text/html");
                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>Calculator</title>");
                            out.println("<link rel=\"stylesheet\" href=\"index.css\">");
                            out.println("</head>");
                            out.println("\r\n");
                            out.println("<body>");
                            out.println("<style>");
                            out.println("table,th{");
                            out.println("border:1px solid black;");
                            out.println("}");
                            out.println("th{");
                            out.println("background-color: #ddd");
                            out.println("}");
                            out.println("table{");
                            out.println("background-color: green");
                            out.println("}");
                            out.println("a{");
                            out.println("text-decoration: none");
                            out.println("}");
                            out.println("a:visited{");
                            out.println("color:inherit");
                            out.println("}");
                            out.println(".answerBox{");
                            out.println("background-color: #ddd");
                            out.println("width:45%");
                            out.println("height:60px");
                            out.println("}");
                            out.println("</style>");
                            out.println("<table style=\"width: 45%\"  style=\"border:1px solid black]\">");
                            out.println("<div id=\"calculator\">");
                            out.println("<div class=\"answerBox\">");
                            out.println("<p id=\"answer\">Answer: </p>");
                            out.println("</div>");
                            out.println("<div id=\"Numbers\">");
                            out.println("<tr>");
                            out.println("<th><div class=\"num\" id=\"One\"><a href=\"0\">0</a></div></th>");
                            out.println("</tr>");
                            out.println("<tr>");
                            out.println("<th><div class=\"num\" id=\"Two\"><a href=\"1\">1</a></div></th>");
                            out.println("<th><div class=\"num\" id=\"Four\"><a href=\"2\">2</a></div></th>");
                            out.println("<th><div class=\"num\" id=\"Three\"><a href=\"3\">3</a></div></th>");
                            out.println("</tr>");
                            out.println("<tr>");
                            out.println("<th><div class=\"num\" id=\"Four\"><a href=\"4\">4</a></div></th>");
                            out.println("<th><div class=\"num\" id=\"Five\"><a href=\"5\">5</a></div></th>");
                            out.println("<th><div class=\"num\" id=\"Six\"><a href=\"6\">6</a></div></th>");
                            out.println("</tr>");
                            out.println("<tr>");
                            out.println("<th><div class=\"num\" id=\"Seven\"><a href=\"7\">7</a></div></th>");
                            out.println("<th><div class=\"num\" id=\"Eight\"><a href=\"8\">8</a></div></th>");
                            out.println("<th><div class=\"num\" id=\"Nine\"><a href=\"9\">9</a></div></th>");
                            out.println("</tr>");
                            out.println("<tr>");
                            out.println("<th><div class=\"operation\" id=\"add\"><a href=\"+\">+</a></div></th>");
                            out.println("<th><div class=\"operation\" id=\"subtract\"><a href=\"-\">-</a></div></th>");
                            out.println("<th><div class=\"operation\" id=\"multiply\"><a href=\"*\">x</a></div></th>");
                            out.println("<th><div class=\"operation\" id=\"divide\"><a href=\"/\">/</a></div></th>");
                            out.println("<th><div class=\"operation\" id=\"equals\"><a href=\"=\">=</a></div></th>");
                            out.println("</tr>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</table>");
                            out.println("</body>");
                            out.println("</html>");

                            out.flush();

                            out.close();
                            }
                            catch(IOException i)
                            {
                                System.out.println(i);
                            }
                                //input = "";
                                     
                        }
                        else if(splits[1].charAt(1) == '=')
                        {
                            @SuppressWarnings("removal")
                            ScriptEngineManager mgr = new ScriptEngineManager();
                            @SuppressWarnings("removal")
                            ScriptEngine engine = mgr.getEngineByName("JavaScript"); 

                            try{
                                PrintWriter out = new PrintWriter(socket.getOutputStream());
    
                                // System.out.println("Anser "+engine.eval(input));
                                out.println("HTTP/1.1 200 OK");
                                out.println("Content-Type: text/html");
                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>Calculator</title>");
                                out.println("<link rel=\"stylesheet\" href=\"index.css\">");
                                out.println("</head>");
                                out.println("\r\n");
                                out.println("<body>");
                                out.println("<style>");
                                out.println("table,th{");
                                out.println("border:1px solid black;");
                                out.println("}");
                                out.println("th{");
                                out.println("background-color: #ddd");
                                out.println("}");
                                out.println("table{");
                                out.println("background-color: green");
                                out.println("}");
                                out.println("a{");
                                out.println("text-decoration: none");
                                out.println("}");
                                out.println("a:visited{");
                                out.println("color:inherit");
                                out.println("}");
                                out.println(".answerBox{");
                                out.println("background-color: #ddd");
                                out.println("width:45%");
                                out.println("height:60px");
                                out.println("}");
                                out.println("</style>");
                                out.println("<table style=\"width: 45%\"  style=\"border:1px solid black]\">");
                                out.println("<div id=\"calculator\">");
                                out.println("<div class=\"answerBox\">");
                                out.println("<p id=\"answer\">Answer: " +engine.eval(input)+ " </p>");
                                out.println("</div>");
                                out.println("<div id=\"Numbers\">");
                                out.println("<tr>");
                                out.println("<th><div class=\"num\" id=\"One\"><a href=\"0\">0</a></div></th>");
                                out.println("</tr>");
                                out.println("<tr>");
                                out.println("<th><div class=\"num\" id=\"Two\"><a href=\"1\">1</a></div></th>");
                                out.println("<th><div class=\"num\" id=\"Four\"><a href=\"2\">2</a></div></th>");
                                out.println("<th><div class=\"num\" id=\"Three\"><a href=\"3\">3</a></div></th>");
                                out.println("</tr>");
                                out.println("<tr>");
                                out.println("<th><div class=\"num\" id=\"Four\"><a href=\"4\">4</a></div></th>");
                                out.println("<th><div class=\"num\" id=\"Five\"><a href=\"5\">5</a></div></th>");
                                out.println("<th><div class=\"num\" id=\"Six\"><a href=\"6\">6</a></div></th>");
                                out.println("</tr>");
                                out.println("<tr>");
                                out.println("<th><div class=\"num\" id=\"Seven\"><a href=\"7\">7</a></div></th>");
                                out.println("<th><div class=\"num\" id=\"Eight\"><a href=\"8\">8</a></div></th>");
                                out.println("<th><div class=\"num\" id=\"Nine\"><a href=\"9\">9</a></div></th>");
                                out.println("</tr>");
                                out.println("<tr>");
                                out.println("<th><div class=\"operation\" id=\"add\"><a href=\"+\">+</a></div></th>");
                                out.println("<th><div class=\"operation\" id=\"subtract\"><a href=\"-\">-</a></div></th>");
                                out.println("<th><div class=\"operation\" id=\"multiply\"><a href=\"*\">x</a></div></th>");
                                out.println("<th><div class=\"operation\" id=\"divide\"><a href=\"/\">/</a></div></th>");
                                out.println("<th><div class=\"operation\" id=\"equals\"><a href=\"=\">=</a></div></th>");
                                out.println("</tr>");
                                out.println("</div>");
                                out.println("</div>");
                                out.println("</table>");
                                out.println("</body>");
                                out.println("</html>");
    
                            
                                input = "";
                                show ="";
                    
                                out.flush();
    
                                out.close();
                            }
                            catch(IOException i)
                            {
                                System.out.println(i);
                            }
                        }
                        
                        
                    }
                    else{
                        input+="/";
                        show="";

                                    try{
                                        PrintWriter out = new PrintWriter(socket.getOutputStream());
            
                                        out.println("HTTP/1.1 200 OK");
                                        out.println("Content-Type: text/html");
                                        out.println("<!DOCTYPE html>");
                                        out.println("<html>");
                                        out.println("<head>");
                                        out.println("<title>Calculator</title>");
                                        out.println("<link rel=\"stylesheet\" href=\"index.css\">");
                                        out.println("</head>");
                                        out.println("\r\n");
                                        out.println("<body>");
                                        out.println("<style>");
                                        out.println("table,th{");
                                        out.println("border:1px solid black;");
                                        out.println("}");
                                        out.println("th{");
                                        out.println("background-color: #ddd");
                                        out.println("}");
                                        out.println("table{");
                                        out.println("background-color: green");
                                        out.println("}");
                                        out.println("a{");
                                        out.println("text-decoration: none");
                                        out.println("}");
                                        out.println("a:visited{");
                                        out.println("color:inherit");
                                        out.println("}");
                                        out.println(".answerBox{");
                                        out.println("background-color: #ddd");
                                        out.println("width:45%");
                                        out.println("height:60px");
                                        out.println("}");
                                        out.println("</style>");
                                        out.println("<table style=\"width: 45%\"  style=\"border:1px solid black]\">");
                                        out.println("<div id=\"calculator\">");
                                        out.println("<div class=\"answerBox\">");
                                        out.println("<p id=\"answer\">Answer: </p>");
                                        out.println("</div>");
                                        out.println("<div id=\"Numbers\">");
                                        out.println("<tr>");
                                        out.println("<th><div class=\"num\" id=\"One\"><a href=\"0\">0</a></div></th>");
                                        out.println("</tr>");
                                        out.println("<tr>");
                                        out.println("<th><div class=\"num\" id=\"Two\"><a href=\"1\">1</a></div></th>");
                                        out.println("<th><div class=\"num\" id=\"Four\"><a href=\"2\">2</a></div></th>");
                                        out.println("<th><div class=\"num\" id=\"Three\"><a href=\"3\">3</a></div></th>");
                                        out.println("</tr>");
                                        out.println("<tr>");
                                        out.println("<th><div class=\"num\" id=\"Four\"><a href=\"4\">4</a></div></th>");
                                        out.println("<th><div class=\"num\" id=\"Five\"><a href=\"5\">5</a></div></th>");
                                        out.println("<th><div class=\"num\" id=\"Six\"><a href=\"6\">6</a></div></th>");
                                        out.println("</tr>");
                                        out.println("<tr>");
                                        out.println("<th><div class=\"num\" id=\"Seven\"><a href=\"7\">7</a></div></th>");
                                        out.println("<th><div class=\"num\" id=\"Eight\"><a href=\"8\">8</a></div></th>");
                                        out.println("<th><div class=\"num\" id=\"Nine\"><a href=\"9\">9</a></div></th>");
                                        out.println("</tr>");
                                        out.println("<tr>");
                                        out.println("<th><div class=\"operation\" id=\"add\"><a href=\"+\">+</a></div></th>");
                                        out.println("<th><div class=\"operation\" id=\"subtract\"><a href=\"-\">-</a></div></th>");
                                        out.println("<th><div class=\"operation\" id=\"multiply\"><a href=\"*\">x</a></div></th>");
                                        out.println("<th><div class=\"operation\" id=\"divide\"><a href=\"/\">/</a></div></th>");
                                        out.println("<th><div class=\"operation\" id=\"equals\"><a href=\"=\">=</a></div></th>");
                                        out.println("</tr>");
                                        out.println("</div>");
                                        out.println("</div>");
                                        out.println("</table>");
                                        out.println("</body>");
                                        out.println("</html>");
            
                                    
                            
                            
                                        out.flush();
            
                                        out.close();
                                    }
                                    catch(IOException i)
                                    {
                                        System.out.println(i);
                                    }

                    }
                    
                    // socket.close();
                    // in.close();
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