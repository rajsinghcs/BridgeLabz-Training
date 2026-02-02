class Animal {
	void makeSound() {
		System.out.println("Animal Sound");
	}
}
	
class Dog extends Animal{
	void makeSound() {
		System.out.println("Dog Sound");
	}
}
public class OverrideAnnotate{
	public static void main(String [] args) {
		Dog dog= new Dog();
		dog.makeSound();
	}
}