package com.deeparishi.javaapp.corejavaconcepts.streams;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Questions {

    public static void main(String[] args) {
        peopleSkillByAge();
        transactionJoining();
        orderGrouping();
        employeeOfCompanies();
        employeeStatsOnEachCompany();
        deptStats();
        displayOrder();
        orderQuestion();
        flightBookingQue();
    }

    /**
     Filter orders placed in the year 2023.<br></br>
     Group these orders by customerName.<br></br>
     For each customer, create a Map<String, Double> where the key is the product category and the value is
     the total amount spent in that category by that customer across all their 2023 orders. The amount for an item is price * quantity.<br></br>
     Finally, produce a Map<String, Map<String, Double>> where the outer key is the customer name and the inner
     map is the category-to-total-spent mapping.<br></br>
     Sort the inner maps by total amount spent in descending order (highest spending category first).<br></br>
     **/
    private static void orderGrouping() {
        List<OrderApp.Order> orders = OrderApp.getOrders();

        Map<String, Map<String, Double>> collect = orders.stream()
                .filter(o -> o.orderDate().getYear() == 2023)
                .collect(Collectors.groupingBy(
                        OrderApp.Order::customerName,
                        Collectors.flatMapping(
                                order -> order.items().stream(),
                                Collectors.groupingBy(
                                        OrderApp.Item::category,
                                        Collectors.summingDouble(i -> i.price() * i.quantity()))
                        ))
                );
        System.out.println(collect);
    }

    /**
     * Finds all traders from the city "New York" who had transactions in the year 2020 or later.<br></br>
     * Collects their names in a single comma-separated string, sorted alphabetically, with no duplicates.<br></br>
     * If no such trader exists, return the string "No Traders Found".<br></br>
     */
    private static void transactionJoining() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("Alice", "New York", 2019, 1000),
                new Transaction("Bob", "New York", 2020, 1500),
                new Transaction("Charlie", "Boston", 2021, 700),
                new Transaction("Dave", "New York", 2022, 1200),
                new Transaction("Eve", "Chicago", 2020, 1100)
        );

        String result = transactions
                .stream()
                .filter(t -> t.city().equalsIgnoreCase("New york") && t.year() >= 2020)
                .map(Transaction::traderName)
                .collect(Collectors.collectingAndThen(
                        Collectors.joining(", "),
                        s -> s.isEmpty() ? "No trader found" : s
                ));
        System.out.println(result);
    }

    /**
     * Filters out all persons younger than 18. <br></br>
     * Groups the remaining persons by their age. <br></br>
     * For each age group, produce a sorted list of unique skills possessed by all persons in that group. <br></br>
     * The final output should be a Map<Integer, List<String>> where the key is the age and the value is the sorted list of unique skills. <br></br>
     */
    private static void peopleSkillByAge() {
        List<Person> people = Arrays.asList(
                new Person("Alice", 20, Arrays.asList("Java", "Python")),
                new Person("Bob", 17, Arrays.asList("C++", "Java")),
                new Person("Charlie", 20, Arrays.asList("Python", "JavaScript")),
                new Person("David", 22, Arrays.asList("Java", "C#")),
                new Person("Eve", 22, Arrays.asList("C#", "Python"))
        );

        Map<Integer, List<String>> skillsByAge = people.stream()
                .filter(p -> p.age() >= 18)
                .collect(Collectors.groupingBy(Person::age))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue()
                                .stream()
                                .flatMap(person -> person.skills().stream())
                                .distinct()
                                .sorted()
                                .toList()
                ));

        System.out.println(skillsByAge);
    }

    /**
     * From all employees of all companies <br></br>
     * Filter employees who are older than 25 and have "Java" as one of their skills. <br></br>
     * Flatten the list to work on individual employees. <br></br>
     * Remove duplicate employees (same name, age, department). <br></br>
     * Sort them by age (descending), then by name (ascending). <br></br>
     * Group the employees by department. <br></br>
     * For each department, collect the names of the top 2 oldest employees into a list. <br></br>
     * Collect the result into a Map<String, List<String>>, where the key is department and the value is the list of names.<br></br>
     */
    private static void employeeOfCompanies() {

        List<Company> companies = Company.companies();

        List<Employee> sortByAgeAndFlattenEmployee = companies.stream()
                .flatMap(c -> c.employees().stream())
                .filter(e -> e.age() >= 25 && new HashSet<>(e.skills()).contains("Java"))
                .toList();

        List<Employee> distinctEmployeeByAgeNameDept = sortByAgeAndFlattenEmployee
                .stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(
                                e -> e.name() + "|" + e.age() + "|" + e.department(), // key
                                e -> e, // value
                                (e1, _) -> e1
                        ),
                        map -> new ArrayList<>(map.values())
                ));

        List<Employee> sorted = distinctEmployeeByAgeNameDept
                .stream()
                .sorted(Comparator.comparingInt(Employee::age).reversed()
                        .thenComparing(Employee::name))
                .toList();

        Map<String, List<String>> collect = sorted.stream()
                .collect(Collectors.groupingBy(Employee::department,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        l -> l.stream()
                                                .limit(2)
                                                .map(Employee::name)
                                                .toList()
                                )
                        )
                );

        System.out.println(collect);
    }

    /**
     * Filter employees who know "Java" and are under age 35. <br></br>
     * Group the employees by company name and department (nested grouping). <br></br>
     * For each (Company, Department) group: <br></br>
     * Count the number of such employees <br></br>
     * Get the average age<br></br>
     * Get the set of unique skills used in that group<br></br>
     * Build and return a nested map:
     */
    public static void employeeStatsOnEachCompany() {
        List<Company> companies = Company.companies();

        Map<String, Map<String, Employee.EmployeeStats>> employeeStats = companies.stream()
                .collect(Collectors.toMap(
                        Company::name,
                        c -> c.employees().stream()
                                .filter(e -> e.age() >= 35 && e.skills().contains("Java"))
                                .collect(Collectors.groupingBy(
                                        Employee::department,
                                        Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                e -> {
                                                    long count = e.size();
                                                    double avgAge = e.stream()
                                                            .mapToInt(Employee::age)
                                                            .average()
                                                            .orElse(0);
                                                    Set<String> skills = e.stream()
                                                            .flatMap(emp -> emp.skills().stream())
                                                            .collect(Collectors.toSet());

                                                    return new Employee.EmployeeStats(count, avgAge, skills);
                                                }))
                                ))
                );

        System.out.println(employeeStats);

    }

    /**
     * Find the top 2 departments (across all companies) with the highest number of employees who know "Java" and are younger than 40.
     * For each of these departments, collect:
     * The total number of such employees
     * A list of employee names sorted by age descending
     * A set of all unique skills from those employees
     */
    private static void deptStats() {
        List<Company> companies = Company.companies();

        Map<String, Map<String, Company.DepartmentStats>> deptStats = companies.stream()
                .collect(Collectors.toMap(
                        Company::name,
                        comp -> comp.employees()
                                .stream()
                                .filter(c -> c.age() < 40 && c.skills().contains("Java"))
                                .collect(Collectors.groupingBy(
                                                Employee::department,
                                                Collectors.collectingAndThen(
                                                        Collectors.toList(),
                                                        list -> {
                                                            long count = list.size();
                                                            List<String> sortedByAge = list.stream()
                                                                    .sorted(Comparator.comparingInt(Employee::age).reversed())
                                                                    .map(Employee::name)
                                                                    .toList();
                                                            Set<String> skills = list.stream()
                                                                    .flatMap(emp -> emp.skills().stream())
                                                                    .collect(Collectors.toSet());

                                                            return new Company.DepartmentStats(count, sortedByAge, skills);
                                                        }
                                                )
                                        )
                                )
                ));

        System.out.println(deptStats);
    }

    /**
     * {
     *   North = {Fiction=37.5, Science=45.0, History=30.0},
     *   South = {Science=45.0, History=20.0},
     *   East = {Fiction=62.5}
     * }
     */
    public static void displayOrder() {
        List<BookOrder> bookOrder = BookOrder.mockOrders();
        Map<String, Map<String, Double>> map = bookOrder.stream()
                .collect(Collectors.groupingBy(BookOrder::customerRegion,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                l -> l.stream()
                                        .flatMap(j -> j.items().stream())
                                        .collect(Collectors.groupingBy(
                                                BookOrder.BookItem::category,
                                                Collectors.summingDouble(i -> i.price() * i.quantity())
                                        ))

                        ))
                );

        System.out.println(map);
    }

    private static void orderQuestion() {
        List<Order> orders = Order.orders();

        // Find the total revenue spent by each customer.
        Map<String, Double> revenueByCustomer = orders.stream()
                .collect(Collectors.groupingBy(Order::customer, Collectors.summingDouble(Order::amount)));

        // Find the top 2 most frequently ordered items across ALL orders.
        Map<String, Long> top2Orders = orders.stream()
                .flatMap(o -> o.items().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(2)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));

        // Return a list of customers sorted by number of unique items they ordered (desc).
        Map<String, Set<String>> collect = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::customer,
                        Collectors.mapping(
                                Order::items,
                                Collectors.flatMapping(
                                        Collection::stream,
                                        Collectors.toSet()
                                )
                        )
                ));

        System.out.println(revenueByCustomer);
        System.out.println(top2Orders);
        System.out.println(collect);
    }

    private static void flightBookingQue() {
        List<Booking> bookings = Booking.bookings();

        // Calculate total revenue generated per destination
        Map<String, Double> revenueByDestination = bookings.stream()
                .flatMap(b -> b.tickets().stream())
                .collect(Collectors.groupingBy(
                        t -> t.flight().destination(),
                        Collectors.summingDouble(t -> t.flight().price()))
                );

        // Find all customers who booked flights from Bangalore → Delhi route.
        Set<String> passengerNames = bookings.stream()
                .flatMap(b -> b.tickets().stream())
                .filter(t -> t.flight().source().equals("Bangalore") && t.flight().destination().equals("Delhi"))
                .map(Booking.Ticket::passengerName)
                .collect(Collectors.toSet());

        // Find the most frequently booked flightNumber.
        Map<String, Long> mostBookedFlight = bookings.stream()
                .flatMap(b -> b.tickets().stream())
                .collect(Collectors.groupingBy(t -> t.flight().flightNumber(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));


        // Get a map of customerName → list of unique destinations they travelled to
        Map<String, Set<String>> customersWithUniqueDestination = bookings.stream()
                .collect(Collectors.toMap(
                        b -> b.customer().name(),
                        b -> b.tickets().stream()
                                .map(t -> t.flight().destination())
                                .collect(Collectors.toSet()),
                        (set1, set2) -> {
                            set1.addAll(set2);
                            return set1;
                        }
                ));


        System.out.println(revenueByDestination);
        System.out.println(passengerNames);
        System.out.println(mostBookedFlight);
        System.out.println(customersWithUniqueDestination);
    }

    private static void ecommerceQue() {
        List<ECommerceOrder> eCommerceOrders = ECommerceOrder.eCommerceOrders();

        // Total revenue generated per category.
        Map<String, Double> categoryPrice = eCommerceOrders.stream()
                .flatMap(o -> o.items().stream())
                .collect(Collectors.groupingBy(i -> i.product().category(), Collectors.summingDouble(
                        p -> p.quantity() * p.product().price())
                ));

        // Find all customers who paid using UPI.
        List<String> customerPaidViaUPI = eCommerceOrders.stream()
                .filter(p -> p.payment().method().equalsIgnoreCase("upi"))
                .map(c -> c.customer().name())
                .toList();

        // Find the most sold product category (based on item quantity).
        Map<String, Long> mostSoldCategory = eCommerceOrders.stream()
                .flatMap(o -> o.items().stream())
                .collect(Collectors.groupingBy(
                        i -> i.product().category(),
                        Collectors.summingLong(ECommerceOrder.CartItem::quantity))
                ).entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> Map.of(e.getKey(), e.getValue()))
                .orElse(Map.of());

        //  For each customer, return the total number of products they purchased.
        Map<String, Integer> customerPurchasedProducts = eCommerceOrders.stream()
                .collect(Collectors.toMap(c -> c.customer().name(),
                        c -> c.items().size()
                ));


        // List of unique customers who bought products in that category.
        Map<String, Set<String>> customerBoughtCategories = eCommerceOrders.stream()
                .flatMap(o -> o.items()
                        .stream()
                        .map(c -> Map.entry(c.product().category(), o.customer().name())))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toSet())
                ));

        System.out.println(mostSoldCategory);
        System.out.println(customerPurchasedProducts);
        System.out.println(customerBoughtCategories);
    }
}

record Person (String name, int age, List<String> skills){}

record Transaction (String traderName, String city, int year, int value){}

class OrderApp {
    record Order(String orderId,String customerName, List<Item> items, LocalDate orderDate ) {}

    record Item(String productName,String category, double price, int quantity ) {}

    public static List<Order> getOrders() {
        return Arrays.asList(
                new Order("O001", "Alice", Arrays.asList(
                        new Item("Laptop", "Electronics", 1200.0, 1),
                        new Item("Headphones", "Electronics", 150.0, 2),
                        new Item("Book A", "Books", 30.0, 3)
                ), LocalDate.of(2023, 1, 15)),

                new Order("O002", "Bob", Arrays.asList(
                        new Item("Apples", "Groceries", 2.0, 50),
                        new Item("Bananas", "Groceries", 1.5, 30),
                        new Item("USB Cable", "Electronics", 15.0, 10)
                ), LocalDate.of(2023, 3, 22)),

                new Order("O003", "Alice", Arrays.asList(
                        new Item("Book B", "Books", 25.0, 2),
                        new Item("Smartphone", "Electronics", 800.0, 1)
                ), LocalDate.of(2023, 7, 5)),

                new Order("O004", "Charlie", Arrays.asList(
                        new Item("Bananas", "Groceries", 1.5, 20),
                        new Item("Notebook", "Stationery", 5.0, 10)
                ), LocalDate.of(2022, 11, 10)),  // Not 2023, should be excluded

                new Order("O005", "Bob", Arrays.asList(
                        new Item("Monitor", "Electronics", 300.0, 1),
                        new Item("Desk Lamp", "Electronics", 45.0, 2)
                ), LocalDate.of(2023, 8, 17))
        );
    }

}

record Company (String name, List<Employee> employees){
    record DepartmentStats(long employeeCount, List<String> employeeNamesSortedByAge,
                           Set<String> allSkills) {}
    public static List<Company> companies() {
        return List.of(
                new Company("TechSoft", List.of(
                        new Employee("Alice", 30, "Engineering", List.of("Java", "Python")),
                        new Employee("Bob", 28, "Engineering", List.of("JavaScript", "Java")),
                        new Employee("Charlie", 22, "Support", List.of("Java"))
                )),
                new Company("InnovateX", List.of(
                        new Employee("David", 35, "Engineering", List.of("Java", "Go")),
                        new Employee("Eve", 29, "Support", List.of("Python", "Java")),
                        new Employee("Frank", 26, "Engineering", List.of("Java"))
                )),
                new Company("AlphaTech", List.of(
                        new Employee("Grace", 40, "Management", List.of("Leadership", "Java")),
                        new Employee("Heidi", 33, "Engineering", List.of("Java", "C++")),
                        new Employee("Ivan", 27, "Support", List.of("Java", "HTML"))
                ))
        );
    }
}

record Employee(String name, int age,String department,  List<String> skills){
    record EmployeeStats(long employeeCount, double avgAge, Set<String> skills){}
}

record BookOrder(String orderId, String customerRegion, List<BookItem> items, LocalDate orderDate) {

    record BookItem(String category, double price, int quantity) {}

    public static List<BookOrder> mockOrders() {

        return Arrays.asList(
                new BookOrder("O1", "North", Arrays.asList(
                        new BookItem("Fiction", 12.5, 2),
                        new BookItem("Science", 15.0, 1)), LocalDate.of(2025, 10, 20)),

                new BookOrder("O2", "South", Arrays.asList(
                        new BookItem("Science", 15.0, 3),
                        new BookItem("History", 10.0, 2)), LocalDate.of(2025, 10, 21)),

                new BookOrder("O3", "North", Arrays.asList(
                        new BookItem("Fiction", 12.5, 1),
                        new BookItem("Science", 15.0, 2),
                        new BookItem("History", 10.0, 3)), LocalDate.of(2025, 10, 22)),

                new BookOrder("O4", "East", Arrays.asList(
                        new BookItem("Fiction", 12.5, 5)), LocalDate.of(2025, 10, 23))
        );
    }
}

record Order (int orderId, String customer,
              List<String> items, double amount) {

    public static List<Order> orders() {
        return Arrays.asList(
                new Order(1, "Arun", Arrays.asList("Pizza", "Coke"), 300),
                new Order(2, "Priya", Arrays.asList("Burger"), 150),
                new Order(3, "Arun", Arrays.asList("Fries", "Coke", "Pizza"), 240),
                new Order(4, "Karan", Arrays.asList("Coke"), 60)
        );
    }
}

record Booking(String bookingId, Customer customer, List<Ticket> tickets) {
    public static List<Booking> bookings() {
        return Arrays.asList(
                new Booking(
                        "B001",
                        new Customer("Arun", "arun@mail.com"),
                        Arrays.asList(
                                new Ticket("Arun", new Flight("AI-101", "Bangalore", "Delhi", 6500)),
                                new Ticket("Arun", new Flight("AI-105", "Delhi", "Mumbai", 5200))
                        )
                ),

                new Booking(
                        "B002",
                        new Customer("Priya", "priya@mail.com"),
                        Arrays.asList(
                                new Ticket("Priya", new Flight("AI-101", "Bangalore", "Delhi", 6500))
                        )
                ),

                new Booking(
                        "B003",
                        new Customer("Karan", "karan@mail.com"),
                        Arrays.asList(
                                new Ticket("Karan", new Flight("SG-220", "Chennai", "Singapore", 12000)),
                                new Ticket("Karan", new Flight("SG-210", "Singapore", "Chennai", 11000))
                        )
                ),

                new Booking(
                        "B004",
                        new Customer("Sneha", "sneha@mail.com"),
                        Arrays.asList(
                                new Ticket("Sneha", new Flight("AI-302", "Bangalore", "Delhi", 7000)),
                                new Ticket("Sneha", new Flight("AI-105", "Delhi", "Mumbai", 5200))
                        )
                ),

                new Booking(
                        "B005",
                        new Customer("Rahul", "rahul@mail.com"),
                        Arrays.asList(
                                new Ticket("Rahul", new Flight("AI-302", "Bangalore", "Delhi", 7000)),
                                new Ticket("Rahul", new Flight("AI-302", "Bangalore", "Delhi", 7000))
                        )
                )

        );

    }

    record Customer (String name, String email){}

    record Ticket (String passengerName, Flight flight){}

    record Flight(String flightNumber, String source, String destination, double price) {}
}


record ECommerceOrder(String orderId,  Customer customer, List<CartItem> items, Payment payment) {

    public static List<ECommerceOrder> eCommerceOrders() {
        return Arrays.asList(

                new ECommerceOrder(
                        "O001",
                        new Customer("Arun", "arun@mail.com"),
                        Arrays.asList(
                                new CartItem(new Product("P101", "Electronics", 55000), 1),
                                new CartItem(new Product("P201", "Fashion", 1500), 2)
                        ),
                        new Payment("UPI", 58000)
                ),

                new ECommerceOrder(
                        "O002",
                        new Customer("Priya", "priya@mail.com"),
                        Arrays.asList(
                                new CartItem(new Product("P102", "Electronics", 30000), 1),
                                new CartItem(new Product("P301", "Home", 2000), 3)
                        ),
                        new Payment("Card", 36000)
                ),

                new ECommerceOrder(
                        "O003",
                        new Customer("Karan", "karan@mail.com"),
                        Arrays.asList(
                                new CartItem(new Product("P401", "Sports", 5000), 1),
                                new CartItem(new Product("P201", "Fashion", 1500), 1)
                        ),
                        new Payment("UPI", 6500)
                ),

                new ECommerceOrder(
                        "O004",
                        new Customer("Sneha", "sneha@mail.com"),
                        Arrays.asList(
                                new CartItem(new Product("P101", "Electronics", 55000), 1)
                        ),
                        new Payment("Card", 55000)
                )

        );
    }

    record Customer(String name,  String email) {}

    record CartItem(Product product, int quantity) {}

    record Product(String productId, String category, double price) {}

    record Payment(String method, double totalAmount) {}
}


