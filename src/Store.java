import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Store
{
    Scanner scanner=new Scanner(System.in);
    private ArrayList<Client> clients;
    private ArrayList<Employee> employees;
    private HashMap<Integer,Product> products;
    static int mapIndex;

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
        int employeeChoice;
        System.out.println("Hello "+employee.getFirstName()+" "+employee.getLastName()+" "+"("+employee.getRank()+")");
        System.out.println("1- Print all the clients");
        System.out.println("2- Print all the vip clients");
        System.out.println("3- Print the clients that had bought once or more products");
        System.out.println("4- Print the client that his sum of products is the most");
        System.out.println("5- Add another product to the store");
        System.out.println("6- Change a status for a product");
        System.out.println("7- Make a purchase");
        System.out.println("8- Log out");
        employeeChoice=scanner.nextInt();

        switch (employeeChoice)
        {
            case 1:
                printClients();
                break;
            case 2:
                printVIPClients();
                break;
            case 3:
                printClientsThatBought();
                break;
            case 4:
                printMaxSpenderClient();
                break;
            case 5:
                addProduct();
                break;
            case 6:
                changeProductStatus();
                break;
            case 7:
                makeAPurchase(employee);
                break;
            case 8:
                System.out.println("Bye Bye");
                break;
            default:
                System.out.println("you entered a wrong input");

        }

    }
    public void clientMenu(Client client)
    {
        int productNum;
        System.out.println("Hello "+client.getFirstName()+" "+client.getLastName()+(client.isVipMember()? " VIP!":""));
        for (Integer integer :products.keySet())
        {
            if (products.get(integer).getIsInStock())    //if the product is in stock
            {
                System.out.println(integer + "-" + products.get(integer).getProductName());
            }
        }
        do
        {
            System.out.println("Enter the number of the product you want: (-1 to stop)");
            productNum=scanner.nextInt();
            client.addAProductToTheShoppingCart(products.get(productNum));
        }
        while (productNum!=-1);
    }



    public void printClients()
    {
        for(int i = 0; i < clients.size(); i++)
        {
            System.out.print("1- "+clients.get(i).toString());
        }
    }

    public void printVIPClients()
    {
        for(int i = 0; i < clients.size(); i++)
        {
            if (clients.get(i).isVipMember())
            {
                System.out.print("1- " + clients.get(i).toString());
            }
        }
    }

    public void printClientsThatBought()
    {
        for(int i = 0; i < clients.size(); i++)
        {
            if (!clients.get(i).isShoppingCartEmpty())
            {
                System.out.print("1- " + clients.get(i).toString());
            }
        }
    }

    public void printMaxSpenderClient()
    {
        double max=0,ClientProductSum=0;
        int index=0;

        for(int i = 0; i < clients.size(); i++)
        {
            ClientProductSum=clients.get(i).getSumOfProductsByPrice();
            if (ClientProductSum>max)
            {
               max=ClientProductSum;
               index=i;
            }
        }
        System.out.println("this is the client that spend the most money: "+clients.get(index).toString());
    }

    public void addProduct()
    {
        String productName;
        double price,discount;
        System.out.println("Please enter the product name:");
        productName=scanner.nextLine();
        System.out.println("Please enter the price of the product: ");
        price=scanner.nextDouble();
        System.out.println("Please enter the discount for the VIP members (as 0.2..)");
        discount=scanner.nextDouble();
        products.put(mapIndex,new Product(productName,price,discount,true));
        mapIndex++;
    }

    public void changeProductStatus()
    {
        int productNum;
        String isTrueOrFalse;
        System.out.println("Here is the list of products:");
        for (Integer integer :products.keySet())
        {
            System.out.println(integer+"-"+products.get(integer).getProductName());
        }
        System.out.println("please enter the number of product that you want to change his status:");
        productNum=scanner.nextInt();
        System.out.println("Enter true if it in stock, or false if it not in stock");
        isTrueOrFalse=scanner.nextLine();
        if ((productNum<=mapIndex&&productNum>=0)&&(isTrueOrFalse=="true"||isTrueOrFalse=="false"))      //checks if the input is valid
        {
            if (isTrueOrFalse=="true")
            {
                products.get(productNum).setInStock(true);
            }
            else
            {
                products.get(productNum).setInStock(false);
            }
        }
    }

    public void makeAPurchase(Employee employee)
    {
        int productNum;
        for (Integer integer :products.keySet())
        {
            if (products.get(integer).getIsInStock())    //if the product is in stock
            {
                System.out.println(integer + "-" + products.get(integer).getProductName());
            }
        }
        do
        {
            System.out.println("Enter the number of the product you want: (-1 to stop)");
            productNum=scanner.nextInt();
            employee.addAProductToTheShoppingCart(products.get(productNum));
        }
        while (productNum!=-1);
    }

}
