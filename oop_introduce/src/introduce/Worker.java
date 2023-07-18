package introduce;
public class Worker {
    private final String fullName;
    private final String workerPosition;
    private final String email;
    private final String mobileNumber;
    private final int age;

    public Worker(String full_name, String worker_position, String email, String mobile_number, int age) {
        this.fullName = full_name;
        this.workerPosition = worker_position;
        this.email = email;
        this.mobileNumber = mobile_number;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getWorkerPosition() {
        return workerPosition;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public int getAge() {
        return age;
    }
}
