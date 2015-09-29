package srm.model;

public class UserModel
{

    int u_id;
    String u_name;
    String u_pass;
    String u_level;
    
    public UserModel(int u_id, String u_name, String u_pass, String u_level)
    {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_pass = u_pass;
        this.u_level = u_level;
    }
    
    public int getU_id()
    {
    	return u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pass() {
        return u_pass;
    }

    public void setU_pass(String u_pass) {
        this.u_pass = u_pass;
    }

    public String getU_level() {
        return u_level;
    }

    public void setU_level(String u_level) {
        this.u_level = u_level;
    }

}
