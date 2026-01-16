package DI_Task2_Pt2;

import java.util.Locale;

public class DatabaseOperations {
    private String url;
    private String username;
    private String password;

    public void databaseOperations(){
        System.out.println(String.format(Locale.ENGLISH, "Connecting to database with url = %s, username = %s, password = %s", url, username, password));
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
