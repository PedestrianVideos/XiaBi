package come.newbula.xing.ui.login.bean.response;

/**
 * Created by mjl on 2017/9/8.
 */

public class RegisterResBean {


    private MetaBean meta;
    private DataBean data;
    private String s_time;
    private AaaBean aaa;
    private boolean succeed;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getS_time() {
        return s_time;
    }

    public void setS_time(String s_time) {
        this.s_time = s_time;
    }

    public AaaBean getAaa() {
        return aaa;
    }

    public void setAaa(AaaBean aaa) {
        this.aaa = aaa;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public static class MetaBean {
        /**
         * code : 001001
         * error_type : 001
         * error_msg : 注册失败
         */

        private String code;
        private String error_type;
        private String error_msg;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getError_type() {
            return error_type;
        }

        public void setError_type(String error_type) {
            this.error_type = error_type;
        }

        public String getError_msg() {
            return error_msg;
        }

        public void setError_msg(String error_msg) {
            this.error_msg = error_msg;
        }
    }

    public static class DataBean {

        private String uid;
        private boolean hasRegistered ;
        private String sandboxTag ;
        private  int registerType;
        private String passwd;
        private String nickName;
        private String signature;
        private  String phone;
        private  String locked;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public boolean isHasRegistered() {
            return hasRegistered;
        }

        public void setHasRegistered(boolean hasRegistered) {
            this.hasRegistered = hasRegistered;
        }

        public String getSandboxTag() {
            return sandboxTag;
        }

        public void setSandboxTag(String sandboxTag) {
            this.sandboxTag = sandboxTag;
        }

        public int getRegisterType() {
            return registerType;
        }

        public void setRegisterType(int registerType) {
            this.registerType = registerType;
        }

        public String getPasswd() {
            return passwd;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getLocked() {
            return locked;
        }

        public void setLocked(String locked) {
            this.locked = locked;
        }
    }

    public static class AaaBean {
        /**
         * sandbox_tag : null
         * access_token : null
         */

        private Object sandbox_tag;
        private Object access_token;

        public Object getSandbox_tag() {
            return sandbox_tag;
        }

        public void setSandbox_tag(Object sandbox_tag) {
            this.sandbox_tag = sandbox_tag;
        }

        public Object getAccess_token() {
            return access_token;
        }

        public void setAccess_token(Object access_token) {
            this.access_token = access_token;
        }
    }
}
