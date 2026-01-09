import java.util.ArrayList;

public class SocialMediaFriends {

    static User head = null;

    // Singly Linked List Node
    static class User {
        int userId;
        String name;
        int age;
        ArrayList<Integer> friends;
        User next;

        User(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friends = new ArrayList<>();
            this.next = null;
        }
    }

    // Add user
    public static void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);

        if (head == null) {
            head = newUser;
            return;
        }

        User temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newUser;
    }

    // Find user by ID
    public static User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search user by Name
    public static void searchUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: " + temp.userId + ", " + temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    // Add friend connection (bidirectional)
    public static void addFriend(int id1, int id2) {
        User u1 = findUserById(id1);
        User u2 = findUserById(id2);

        if (u1 != null && u2 != null) {
            if (!u1.friends.contains(id2))
                u1.friends.add(id2);
            if (!u2.friends.contains(id1))
                u2.friends.add(id1);
        }
    }

    // Remove friend connection
    public static void removeFriend(int id1, int id2) {
        User u1 = findUserById(id1);
        User u2 = findUserById(id2);

        if (u1 != null && u2 != null) {
            u1.friends.remove(Integer.valueOf(id2));
            u2.friends.remove(Integer.valueOf(id1));
        }
    }

    // Display friends of a user
    public static void displayFriends(int userId) {
        User user = findUserById(userId);

        if (user == null) return;

        System.out.println("Friends of " + user.name + ":");
        for (int id : user.friends) {
            User friend = findUserById(id);
            if (friend != null)
                System.out.println(friend.userId + " - " + friend.name);
        }
    }

    // Find mutual friends
    public static void mutualFriends(int id1, int id2) {
        User u1 = findUserById(id1);
        User u2 = findUserById(id2);

        if (u1 == null || u2 == null) return;

        System.out.println("Mutual Friends:");
        for (int id : u1.friends) {
            if (u2.friends.contains(id)) {
                User mutual = findUserById(id);
                if (mutual != null)
                    System.out.println(mutual.userId + " - " + mutual.name);
            }
        }
    }

    // Count friends for each user
    public static void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(
                    temp.name + " has " + temp.friends.size() + " friends"
            );
            temp = temp.next;
        }
    }

    // Main method 
    public static void main(String[] args) {

        addUser(1, "Ravi", 21);
        addUser(2, "Amit", 22);
        addUser(3, "Neha", 20);
        addUser(4, "Priya", 23);

        addFriend(1, 2);
        addFriend(1, 3);
        addFriend(2, 3);
        addFriend(3, 4);

        displayFriends(1);
        mutualFriends(1, 2);

        removeFriend(1, 3);
        displayFriends(1);

        searchUserByName("Neha");
        countFriends();
    }
}
