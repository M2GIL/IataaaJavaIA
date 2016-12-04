package persistance;

import model.STATUS;

public class IA {

    STATUS status;
    String token;
    
    public IA (String t) {
        token = t;
        status = STATUS.available;
    }
    
    public STATUS getStatus() {
        return status;
    }
    public void setStatus(STATUS status) {
        this.status = status;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

}
