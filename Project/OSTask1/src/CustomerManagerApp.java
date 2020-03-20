import java.util.Scanner;

public class CustomerManagerApp {


    public static void main(String[] args) {
        // display a welcome message
        System.out.println("Welcome to the Customer Manager\n");

       int action;
        Scanner scanner=new Scanner(System.in);
        System.out.println("1 for list , 2 for add , 3 for delet , 4 for help , 5 for exit ");
        System.out.print("Enter a command : ");
        action=scanner.nextInt();
        
        while (action!=5) {
            

            if (action==1) {
                displayAllCustomers();
                System.out.print("Enter a command : ");
                 action=scanner.nextInt();
            } else if (action==2) {
                addCustomer();
                System.out.print("Enter a command : ");
                 action=scanner.nextInt();
            } else if (action==3) {
                deleteCustomer();
                System.out.print("Enter a command : ");
                 action=scanner.nextInt();
            } else if (action==4) {
                displayMenu();
                System.out.print("Enter a command : ");
                 action=scanner.nextInt();
            } else if (action==5) {
                System.out.println("Bye.\n");
                break;
            } else {
                System.out.println("Error! Not a valid command.\n");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("COMMAND MENU");
        System.out.println("list    - List all customers");
        System.out.println("add     - Add a customer");
        System.out.println("del     - Delete a customer");
        System.out.println("help    - Show this menu");
        System.out.println("exit    - Exit this application\n");
    }

    public static void displayAllCustomers() {
        System.out.println("CUSTOMER LIST");

        List<Customer> customers = customerDAO.getAll();
        Customer c;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customers.size(); i++) {
            c = customers.get(i);
            sb.append(StringUtils.padWithSpaces(
                    c.getName(), 27));
            sb.append(c.getEmail());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void addCustomer() {
        String firstName = Console.getLine("Enter first name: ");
        String lastName = Console.getString("Enter last name: ");
        String email = Console.getString("Enter customer email: ");

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customerDAO.add(customer);

        System.out.println();
        System.out.println(firstName + " " + lastName
                + " has been added.\n");
    }

    public static void deleteCustomer() {
        String email = Console.getString("Enter email to delete: ");

        Customer c = customerDAO.get(email);

        System.out.println();
        if (c != null) {
            customerDAO.delete(c);
            System.out.println(c.getName()
                    + " has been deleted.\n");
        } else {
            System.out.println("No customer matches that email.\n");
        }
    }
}
