import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        try {
            Scanner scanner = new Scanner(System.in);
            int input;
            Store store = new Store();
            do {
                System.out.println("Welcome!");
                System.out.println("Enter 1-to sign up");
                System.out.println("Enter 2-to sign in");
                System.out.println("Enter 3-to Exit");
                input = scanner.nextInt();

                switch (input) {
                    case 1:
                        store.addUser();
                        break;
                    case 2:
                        store.logIn();
                        break;
                    case 3:
                        System.out.println("Good Bye");
                        break;
                    default:
                        System.out.println("Yo entered a wrong number please  enter  again");
                }
            }
            while (input != 3);


        }
        catch (Exception e)
        {
            System.out.println("you entered  wrong input");
        }
    }
}
