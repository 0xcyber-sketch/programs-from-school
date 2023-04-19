package application.controller;

import java.util.ArrayList;

import application.model.Company;
import application.model.Employee;
import application.model.Customer;
import storage.Storage;

public class Controller {
    /**
     * Creates a new Company.<br />
     * Requires: hours >= 0.
     */
    public static Company createCompany(String name, int hours) {
        Company company = new Company(name, hours);
        Storage.addCompany(company);
        return company;
    }

    /**
     * Deletes the company.<br />
     * Requires: The company has no employees.
     */
    public static void deleteCompany(Company company) {
        Storage.removeCompany(company);
    }

    /**
     * Updates the company.<br />
     * Requires: hours >= 0.
     */
    public static void updateCompany(Company company, String name, int hours) {
        company.setName(name);
        company.setHours(hours);
    }

    /**
     * Get all the companies
     */
    public static ArrayList<Company> getCompanies() {
        return Storage.getCompanies();
    }

    // -------------------------------------------------------------------------

    /**
     * Creates a new employee.<br />
     * Requires: wage >= 0.
     */
    public static Employee createEmployee(String name, int wage, int year) {
        Employee employee = new Employee(name, wage, year);
        Storage.addEmployee(employee);
        return employee;
    }

    /**
     * Creates a new employee.<br />
     * Requires: wage >= 0, company!=null.
     */
    public static Employee createEmployee(String name, int wage, Company company, int year) {
        Employee employee = createEmployee(name, wage, year);
        company.addEmployee(employee);
        return employee;
    }

    /**
     * Deletes the employee.
     */
    public static void deleteEmployee(Employee employee) {
        Company company = employee.getCompany();
        if (company != null) {
            company.removeEmployee(employee);
        }
        Storage.removeEmployee(employee);
    }

    /**
     * Updates the employee.<br />
     * Requires: wage >= 0.
     */
    public static void updateEmployee(Employee employee, String name, int wage, int year) {
        employee.setName(name);
        employee.setWage(wage);
        employee.setYear(year);
    }
    
    /**
     * Adds the employee to the company. Removes the employee from the old company if present.
     */
    public static void addEmployeeToCompany(Employee employee, Company company) {
        company.addEmployee(employee);
    }
    
    /**
     * Removes the employee from the old company if not null.
     * @param company The old company. Can be null.
     * @param employee The employee to remove.
     */
    public static void removeEmployeeFromCompany(Employee employee, Company company) {
        if (company != null) {
            company.removeEmployee(employee);            
        }
    }

    /**
     * Get all the employees.
     */
    public static ArrayList<Employee> getEmployees() {
        return Storage.getEmployees();
    }
    
    public static ArrayList<Customer> getCustomers() {
        return Storage.getCustomers();
    }
    
    public static Customer createCustomer(String name, String adress ) {
    	Customer c = new Customer(name, adress);
    	Storage.addCustomer(c);
    	
    	return c;
    	
    }
    
    public static Customer createCustomer(String name, String adress, Company company) {
        Customer c = createCustomer(name, adress);
        company.addCustomer(c);

  
        return c;
    }
    
    public static void addCustomerToCompany( Customer customer, Company company) {
    	company.addCustomer(customer); 
    }
    public static void removeCustomerFromCompany(Customer customer, Company company) {
    	if (company != null) {
    	company.removeCustomer(customer); 
    }
    }
    
    public static void getCustomersInCompany(Company company) {
    	ArrayList<Customer> list = company.getCustomers();
    	if (list != null) {
    	for (Customer c : list) {
    	System.out.println(c);
    	}}
    }
    
//    public static void removeCustomersFromAllCompanies() {
//    	ArrayList<Company> companies = getCompanies();
//    	for 
//    }

    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {
        Company c1 = Controller.createCompany("IBM", 37);
        Company c2 = Controller.createCompany("AMD", 40);
        Controller.createCompany("SLED", 45);
        Controller.createCompany("Vector", 32);

        Controller.createEmployee("Bob Dole", 210, c2, 2010);
        Controller.createEmployee("Alice Schmidt", 250, c1, 2011);
        Controller.createEmployee("George Down", 150, c2, 1996);

        Controller.createEmployee("Rita Uphill", 300, 0);
        
        Customer cus1 = Controller.createCustomer("Lars", "Sundvej");
        Customer cus2 = Controller.createCustomer("Ulrik", "Sandvej");
        Controller.addCustomerToCompany(cus1, c2);
        Customer cus3 = Controller.createCustomer("tim", "yue");
        Controller.createCustomer("hw", "wue", c2);
        Controller.addCustomerToCompany(cus2, c2);
        Controller.addCustomerToCompany(cus3, c1);
    }

    public static void init() {

        initStorage();

    }

}
