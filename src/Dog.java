public class Dog extends Animal {

    private String nick;

    public Dog(String name, String color, String nick) {
        super(name, color);
        this.nick = nick;
    }

    public void bark() {
        System.out.println("AV AV AV");
    }
}
