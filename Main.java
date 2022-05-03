import java.util.Scanner;

class Main{
    public static void main(String[] args)
    {
        Client client = new Client();
        client.connect();

        while(true)
        {
            Scanner read = new Scanner(System.in);

            System.out.println("Choose from the following options...");
            System.out.println("(1) Display all friends: ");
            System.out.println("(2) Search for a friend: ");
            System.out.println("(3) Add a friend: ");
            System.out.println("(4) Delete a friend: ");
            System.out.println("(5) Exit ");
            System.out.print("->");
            
            String option = read.nextLine();

            System.out.println("________________________________");
            System.out.println();

            System.out.print("\033[H\033[2J");
            // System.out.flush();

            if(option.equals("1"))
            {
                System.out.println();
                client.getUsers();
                System.out.println("________________________________");
                System.out.println();
            }
            else if(option.equals("2"))
            {
                client.search();
                System.out.println("________________________________");
                System.out.println();
            }
            else if(option.equals("3"))
            {
                client.add();
                System.out.println("________________________________");
                System.out.println();
            }
            else if(option.equals("4"))
            {
                client.delete();
                System.out.println("________________________________");
                System.out.println();
            }
            else{
                break;
            }

            
        }
    }
}