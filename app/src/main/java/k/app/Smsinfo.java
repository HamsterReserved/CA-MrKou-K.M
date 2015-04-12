package k.app;

/**
 * Created by lenovo on 2015/3/24.
 */
public class Smsinfo {


    private String smsbody ;
    private String phonenum;
    private String date;
    private String name ;
    private String type ;
    public String getSmsbdy(){
        return smsbody;
    }
    public  void setSmsbody(String smsbody){
        this.smsbody = smsbody;
    }
    public String getPhoneNum() {
        return phonenum;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phonenum = phonenum;
    }
    public String getDate() {
        return date ;
    }
    public void setDate(String date){
        this.date=date ;
    }
    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name ;
    }
    public String getType(){
        return type ;
    }
    public void settype (String type){
        this.type = type ;
    }

    public String getSmsbody() {return smsbody;};
}
