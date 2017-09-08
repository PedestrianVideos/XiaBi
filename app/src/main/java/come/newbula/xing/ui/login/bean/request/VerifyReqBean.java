package come.newbula.xing.ui.login.bean.request;

/**
 * Created by mjl on 2017/9/8.
 */

public class VerifyReqBean {
    private String access_token;
    private String phone;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
