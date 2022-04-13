import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Store
{
    Scanner scanner=new Scanner(System.in);
    ArrayList<Client> clients;
    ArrayList<Employee> employees;
    HashMap<Integer,Product> products;

    public Store() {
        this.clients =new ArrayList<>();
        this.employees =new ArrayList<>();
        this.products =new HashMap<>();
    }


    public void addClient(String firstName,String lastName,String userName,String password)
    {
        boolean vipMember;
        System.out.println("Are you a VIP member?, enter true orr false");
        vipMember=scanner.nextBoolean();

        Client client=new Client(firstName,lastName,userName,password,vipMember);
        this.clients.add(client);
    }

    public void addEmployee(String firstName,String lastName,String userName,String password)
    {
        System.out.println("What is your Rank? type it!");
        System.out.println("regularEmployee \n manager \n managementMember");
        whichRank rank= whichRank.valueOf(scanner.nextLine());

        Employee employee=new Employee(firstName,lastName,userName,password,rank);

        this.employees.add(employee);
    }

    public void addProduct(Product newProduct)
    {

    }

    public void addUser()
    {
        System.out.println("Press 1 for Employee");
        System.out.println("Press 2 for Client");
        int choice=scanner.nextInt();
        String firstName;
        String lastName;
        String userName;
        String password;


        do {
            System.out.println("Enter your first name:");
            firstName = scanner.nextLine();
        }
        while (!checkName(firstName));
        do {
            System.out.println("Enter your last name:");
            lastName = scanner.nextLine();
        }
        while (!checkName(lastName));


        do {
            System.out.println("Enter your user name:");
            userName = scanner.nextLine();
        }
        while (!checkUserName(userName));

        do {
            System.out.println("Enter your password:");
            password = scanner.nextLine();
        }
        while (!checkPassword(password));

        switch (choice)
        {
            case 1:
                this.addEmployee(firstName,lastName,userName,password);
                break;
            case 2:
                this.addClient(firstName,lastName,userName,password);
            default:
                System.out.println("you entered a wrong number");
        }
    }

    public boolean checkName(String name)
    {
        char[] chars = name.toCharArray();
        for(char c : chars){
            if(Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    public boolean checkUserName(String userName) {
        for (Client client : this.clients) {
            if (client.getUserName().equals(userName)) {
                return false;
            }
        }

        for (Employee employee : this.employees) {
            if (employee.getUserName().equals(userName)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkPassword(String password)
    {
        if (password.length()<6)
            return false;
        return true;
    }

    public void logIn()
    {
        int whichUser;
        String userName;
        String password;
        User user=new User();
        do
        {
            System.out.println("Do you want to connect  to account of a Employee or a client\n 1-Employee\n2-client");
            whichUser=scanner.nextInt();
            System.out.println("Enter your user name");
            userName=scanner.nextLine();
            System.out.println("Enter your password");
            password=scanner.nextLine();
            user=ifUserExist(whichUser,userName,password);
        }
        while (userName==null);

        switch (whichUser)
        {
            case 1:
                employeeMenu((Employee) user);
            case 2:
                clientMenu((Client) user);
        }

    }


    public User ifUserExist(int whichUser,String userName,String password)
    {
        if (whichUser==1)
        {
            for (Employee employee:employees)
            {
                if (employee.getUserName().equals(userName)&&employee.getPassword().equals(password))
                {
                    return employee;
                }
            }
        }
        if (whichUser==2)
        {
            for (Client client:clients)
            {
                if (client.getUserName().equals(userName)&& client.getPassword().equals(password))
                {
                    return client;
                }
            }
        }
        return null;
    }

    public void employeeMenu(Employee employee)
    {

    }
    public void clientMenu(Client client)
    {
        int productNum;
        System.out.println("Hello"+client.getFirstName()+" "+client.getLastName()+(client.isVipMember()? " VIP!":""));
        for (Integer integer :products.keySet())
        {
            System.out.println(integer+"-"+products.get(integer).getProductName());
        }
        do
        {
            System.out.println("Enter the number of the product yo want:");
            productNum=scanner.nextInt();
            client.addAProductToTheShoppingCart(products.get(productNum));
        }
        while (productNum!=-1);
    }


}
