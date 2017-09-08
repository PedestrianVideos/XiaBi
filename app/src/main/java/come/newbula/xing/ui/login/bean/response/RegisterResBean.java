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
