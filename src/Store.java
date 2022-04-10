import java.util.ArrayList;

public class Store
{
    ArrayList<Client> clients;
    ArrayList<Employee> employees;
    ArrayList<Product> products=new ArrayList<>();

    public Store() {
        this.clients =new ArrayList<>();
        this.employees =new ArrayList<>();
        this.products =new ArrayList<>();
    }


    public boolean addClient(Client newClient)
    {
        boolean successes=false;
        return successes;
    }

    public boolean addEmployee(Employee newEmployee)
    {
     boolean successes=false;
        return successes;
    }

    public boolean addProduct(Product newProduct)
    {
      boolean successes=false;
        return successes;
    }

}
