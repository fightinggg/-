package observer;

public class Main {
    public static void main(String[] args) {
        softwareSubject software = new softwareSubject();
        softwareObserver a = new softwareObserver("A");
        softwareObserver b = new softwareObserver("B");
        softwareObserver c = new softwareObserver("C");
        software.addObserver(a);
        software.addObserver(b);
        software.addObserver(c);
        software.publish();
    }
}
