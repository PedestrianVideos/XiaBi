package come.newbula.xing.ui.personinfo.bean.request;

/**
 * Created by mjl on 2017/9/8.
 */

public class ChangePasswordReqBean {
    private String oldPasswd;
    private String phone;
    private String newPasswd;

    public String getOldPasswd() {
        return oldPasswd;
    }

    public void setOldPasswd(String oldPasswd) {
        this.oldPasswd = oldPasswd;
    }

    public String getNewPasswd() {
        return newPasswd;
    }

    public void setNewPasswd(String newPasswd) {
        this.newPasswd = newPasswd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
