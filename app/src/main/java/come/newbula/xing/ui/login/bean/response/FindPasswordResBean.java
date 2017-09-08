package come.newbula.xing.ui.login.bean.response;

/**
 * Created by mjl on 2017/9/8.
 */

public class FindPasswordResBean {


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
         * code : 0000
         * error_type : null
         * error_msg : null
         */

        private String code;
        private Object error_type;
        private Object error_msg;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Object getError_type() {
            return error_type;
        }

        public void setError_type(Object error_type) {
            this.error_type = error_type;
        }

        public Object getError_msg() {
            return error_msg;
        }

        public void setError_msg(Object error_msg) {
            this.error_msg = error_msg;
        }
    }

    public static class DataBean {
        /**
         * uid : 428567386
         * signature : 人生何其短、不行不精彩
         * phone : 18861852514
         * nickName : 手机用户1098602775
         * registerType : 0
         * locked : false
         */

        private String uid;
        private String signature;
        private String phone;
        private String nickName;
        private int registerType;
        private boolean locked;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
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

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getRegisterType() {
            return registerType;
        }

        public void setRegisterType(int registerType) {
            this.registerType = registerType;
        }

        public boolean isLocked() {
            return locked;
        }

        public void setLocked(boolean locked) {
            this.locked = locked;
        }
    }

    public static class AaaBean {
        /**
         * sandbox_tag : null
         * access_token : @T1@A[1,2,3]@U428567386
         */

        private Object sandbox_tag;
        private String access_token;

        public Object getSandbox_tag() {
            return sandbox_tag;
        }

        public void setSandbox_tag(Object sandbox_tag) {
            this.sandbox_tag = sandbox_tag;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }
    }
}
