@ToString
public class Points {
    @ToString(value = "NO")
    private String login;
    @ToString
    private int point;

    public Points(String login, int point) {
        this.login = login;
        this.point = point;
    }

    @Override
    public String toString() {
        return "Login = " + login + ", points = " + point;
    }
}
