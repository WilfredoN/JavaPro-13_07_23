package obstacle;

public class Member {
    String name;
    float maxRunDistance;
    float maxJumpDistance;
    public Member(String name, float maxRunDistance, float maxJumpDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpDistance = maxJumpDistance;
    }
    public boolean toRun(Barrier type) {
        if (type.getLength() < maxRunDistance) {
            System.out.println("Учасник " + name + " пройшов перешкоду " + type.getType() + " на дистанції " + maxRunDistance);
            return true;
        }
        else {
            System.out.println("Учасник " + name + " не пройшов перешкоду " + type.getType() + ". Пройдено " + maxRunDistance);
            return false;
        }

    }
    public void toJump(Barrier type) {
        if (type.getHeight() < maxJumpDistance) {
            System.out.println("Учасник " + name + " перестрибнув перешкоду " + type.getType() + " на висоті " + maxJumpDistance);
        }
        else System.out.println("Учасник " + name + " не перестрибнув перешкоду " + type.getType() + ". Пройдено " + maxJumpDistance);
    }
}
