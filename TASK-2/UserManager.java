import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public void addUser(String userId, String pin) {
        users.put(userId, new User(userId, pin));
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public boolean validateUser(String userId, String pin) {
        User user = users.get(userId);
        return user != null && user.getPin().equals(pin);
    }
}
