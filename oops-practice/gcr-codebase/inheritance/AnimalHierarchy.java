class Animal{
    String name;
    int age;
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    void sound(){
        System.out.println("Sound");
    }
}
class Dog extends Animal{
    public Dog(String name, int age) {
        super(name, age);
    }
    @Override
    void sound(){
        System.out.println("Bark");
    }
}

class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
    }
    @Override
    void sound(){
        System.out.println("Meow");
    }
}

class Bird extends Animal{
    public Bird(String name, int age) {
        super(name, age);
    }
    @Override
    void sound(){
        System.out.println("Chirp");
    }
}

public class AnimalHierarchy { 
    public static void main(String[] args){
        Animal animal = new Animal("Animal",12);
        animal.sound();
        System.out.println("Dog");
        Animal dog = new Dog("Bull",12);
        dog.sound();
        System.out.println("Cat");
        Cat cat = new Cat("Tom",12);
        cat.sound();
        System.out.println("Bird");
        Bird bird = new Bird("Parrot",12);
        bird.sound();
    }
}