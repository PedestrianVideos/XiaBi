package come.newbula.xing.ui.login.bean.request;

/**
 * Created by mjl on 2017/9/8.
 */

public class FindPasswordReqBean {
    private String phone;
    private String passwd;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    private String access_token;
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
