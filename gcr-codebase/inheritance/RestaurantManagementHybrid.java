interface Worker {
    void performDuties();
}

class PersonBase {
    String name;
    int id;

    PersonBase(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Chef extends PersonBase implements Worker {
    Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " (Chef) is cooking food.");
    }
}

class Waiter extends PersonBase implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " (Waiter) is serving customers.");
    }
}

public class RestaurantManagementHybrid{
    public static void main(String[] args) {
        Chef c = new Chef("John", 1);
        c.performDuties();
        Waiter w = new Waiter("Jane", 2);
        w.performDuties();
    }
}