import java.util.HashMap;
import java.util.Map;

public class AuthManager {
    private static AuthManager instance;
    private Map<String, String> users; // Simulating user storage

    private AuthManager() {
        users = new HashMap<>();
        // Initialize with some example users
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public static AuthManager getInstance() {
        if (instance == null) {
            instance = new AuthManager();
        }
        return instance;
    }

    public boolean authenticate(String username, String password) {
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}
