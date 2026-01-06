package AdvUserSystem.src;

import AdvUserSystem.src.AdvDuplicateUser;
import AdvUserSystem.src.AdvUserService;

public class AdvMainApp {

    public static void main(String[] args) {

        AdvUserService service = new AdvUserService();

        try {
            AdvUser u1 = new AdvUser("Akshitha", "akshi@gmail.com", AdvRole.ADMIN, true);
            AdvUser u2 = new AdvUser("Snehitha", "snehitha@gmail.com", AdvRole.USER, true);
            AdvUser u3 = new AdvUser("Akshaya", "akshaya@gmail.com", AdvRole.USER, false); 

            service.addUser(u1);
            service.addUser(u2);
            service.addUser(u3); 

            service.recordLogin("akshi@gmail.com", "2026-01-04 10:00");
            service.recordLogin("akshi@gmail.com", "akshi@gmail.com");

        }
        catch (AdvDuplicateUser e) {
            System.out.println("Error: " + e.getMessage());
        }

        service.displayUsers();

        System.out.println("\nAdmins:");
        System.out.println(service.getUsersByRole(AdvRole.ADMIN));

        System.out.println("\nActive Users Sorted By Name:");
        System.out.println(service.getActiveUsersSortedByName());

        System.out.println("\nLogin History:");
        System.out.println(service.getLoginHistory("akshi@gmail.com"));
    } 
}