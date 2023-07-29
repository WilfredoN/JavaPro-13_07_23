package Polymorphism.obstacle;

public class Main {
    public static void main(String[] args) {
        Member []Members = new Member[] {
                new Member("Людина", 300, 100),
                new Member("Кішка", 500, 120),
                new Member("Робот", 1000, 50)
        };
        Barrier []Obstacles = new Barrier[] {
                new Barrier("Бігова доріжка", 330, 0),
                new Barrier("Стіна", 0, 100)
        };
        System.out.println("Довжина бігової доріжки - " + Obstacles[0].getLength() + "\nВисота стіни - " + Obstacles[1].getHeight());
        for (Member member : Members) {
            if (member.toRun(Obstacles[0])) {
                member.toJump(Obstacles[1]);
            }
        }
    }
}
