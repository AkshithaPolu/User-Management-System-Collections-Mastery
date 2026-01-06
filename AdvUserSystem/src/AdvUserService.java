package AdvUserSystem.src;

import java.util.*;
public class AdvUserService {
    // private User[] users; 
    // private int count = 0;

    // public UserService(int size) {
    //     users = new User[size];
    // }
    private Map<String, AdvUser> userMap = new HashMap<>();
    private Map<String, List<String>> loginHistory = new HashMap<>();

    public void addUser(AdvUser user) throws AdvDuplicateUser {

        if (user == null || user.getEmail() == null) {
            System.out.println("Invalid User Data");
            return;
        }
        if (userMap.containsKey(user.getEmail())) {
            throw new AdvDuplicateUser("Email already exists");
        }

        // if (count >= users.length) {
        //     System.out.println("User storage full");
        //     return;
        // }

        userMap.put(user.getEmail(), user);
        System.out.println("User added successfully");
    }

    public AdvUser getUserByEmail(String email) {
        return userMap.get(email);
    }

    public List<AdvUser> getUsersByRole(AdvRole role) {
        List<AdvUser> result = new ArrayList<>();

        for (AdvUser user : userMap.values()) {
            if (user.getRole() == role) {
                result.add(user);
            }
        }
        return Collections.unmodifiableList(result);
    }

    public List<AdvUser> getActiveUsersSortedByName() {
        List<AdvUser> activUsers = new ArrayList<>();

        for (AdvUser user : userMap.values()) {
            if (user.isActive()) {
                activUsers.add(user);
            }
        }

        activUsers.sort(Comparator.comparing(AdvUser::getName));
        return Collections.unmodifiableList(activUsers);
    }

    public void recordLogin(String email, String dateTime) {
        loginHistory
            .computeIfAbsent(email, k -> new ArrayList<>())
            .add(dateTime);
    }

    public List<String> getLoginHistory(String email) {
        return loginHistory.containsKey(email)
                ? Collections.unmodifiableList(loginHistory.get(email))
                : Collections.emptyList();
    }

    public void displayUsers() {
        System.out.println("\n--- Users List ---");
        for (AdvUser user : userMap.values()) {
            System.out.println(user);
        }
    }

}
