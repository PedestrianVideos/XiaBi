package come.newbula.xing.ui.personinfo.bean.response;

import java.util.List;

/**
 * Created by mjl on 2017/9/8.
 */

public class UserInfoResBean {



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


        private String uid;
        private String nickName;
        private int gender;
        private String birthday;
        private String constellation;
        private String signature;
        private LocationInfoBean location_info;
        private String verify_info;
        private AvatarInfoBean avatar_info;
        private String stats_info;
        private ShareInfoBean share_info;

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getConstellation() {
            return constellation;
        }

        public void setConstellation(String constellation) {
            this.constellation = constellation;
        }

        public String getVerify_info() {
            return verify_info;
        }

        public void setVerify_info(String verify_info) {
            this.verify_info = verify_info;
        }

        public String getStats_info() {
            return stats_info;
        }

        public void setStats_info(String stats_info) {
            this.stats_info = stats_info;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
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

        public LocationInfoBean getLocation_info() {
            return location_info;
        }

        public void setLocation_info(LocationInfoBean location_info) {
            this.location_info = location_info;
        }


        public AvatarInfoBean getAvatar_info() {
            return avatar_info;
        }

        public void setAvatar_info(AvatarInfoBean avatar_info) {
            this.avatar_info = avatar_info;
        }



        public ShareInfoBean getShare_info() {
            return share_info;
        }

        public void setShare_info(ShareInfoBean share_info) {
            this.share_info = share_info;
        }

        public static class LocationInfoBean {
            /**
             * hide_location : false
             * location : null
             * location_geo : null
             */

            private boolean hide_location;
            private Object location;
            private Object location_geo;

            public boolean isHide_location() {
                return hide_location;
            }

            public void setHide_location(boolean hide_location) {
                this.hide_location = hide_location;
            }

            public Object getLocation() {
                return location;
            }

            public void setLocation(Object location) {
                this.location = location;
            }

            public Object getLocation_geo() {
                return location_geo;
            }

            public void setLocation_geo(Object location_geo) {
                this.location_geo = location_geo;
            }
        }

        public static class AvatarInfoBean {
            /**
             * avatar_lar : {"url_list":[],"uri":null}
             * avatar_med : {"url_list":[],"uri":null}
             * avatar_thu : {"url_list":[],"uri":null}
             * avatarUri : null
             */

            private AvatarLarBean avatar_lar;
            private AvatarMedBean avatar_med;
            private AvatarThuBean avatar_thu;
            private Object avatarUri;

            public AvatarLarBean getAvatar_lar() {
                return avatar_lar;
            }

            public void setAvatar_lar(AvatarLarBean avatar_lar) {
                this.avatar_lar = avatar_lar;
            }

            public AvatarMedBean getAvatar_med() {
                return avatar_med;
            }

            public void setAvatar_med(AvatarMedBean avatar_med) {
                this.avatar_med = avatar_med;
            }

            public AvatarThuBean getAvatar_thu() {
                return avatar_thu;
            }

            public void setAvatar_thu(AvatarThuBean avatar_thu) {
                this.avatar_thu = avatar_thu;
            }

            public Object getAvatarUri() {
                return avatarUri;
            }

            public void setAvatarUri(Object avatarUri) {
                this.avatarUri = avatarUri;
            }

            public static class AvatarLarBean {
                /**
                 * url_list : []
                 * uri : null
                 */

                private Object uri;
                private List<?> url_list;

                public Object getUri() {
                    return uri;
                }

                public void setUri(Object uri) {
                    this.uri = uri;
                }

                public List<?> getUrl_list() {
                    return url_list;
                }

                public void setUrl_list(List<?> url_list) {
                    this.url_list = url_list;
                }
            }

            public static class AvatarMedBean {
                /**
                 * url_list : []
                 * uri : null
                 */

                private Object uri;
                private List<?> url_list;

                public Object getUri() {
                    return uri;
                }

                public void setUri(Object uri) {
                    this.uri = uri;
                }

                public List<?> getUrl_list() {
                    return url_list;
                }

                public void setUrl_list(List<?> url_list) {
                    this.url_list = url_list;
                }
            }

            public static class AvatarThuBean {
                /**
                 * url_list : []
                 * uri : null
                 */

                private Object uri;
                private List<?> url_list;

                public Object getUri() {
                    return uri;
                }

                public void setUri(Object uri) {
                    this.uri = uri;
                }

                public List<?> getUrl_list() {
                    return url_list;
                }

                public void setUrl_list(List<?> url_list) {
                    this.url_list = url_list;
                }
            }
        }

        public static class ShareInfoBean {
            /**
             * share_title : 快来挑战，让你发现更精彩的自己
             * share_url : null
             * share_desc : X-ing行啊--人生何其短，不行不精彩!
             */

            private String share_title;
            private Object share_url;
            private String share_desc;

            public String getShare_title() {
                return share_title;
            }

            public void setShare_title(String share_title) {
                this.share_title = share_title;
            }

            public Object getShare_url() {
                return share_url;
            }

            public void setShare_url(Object share_url) {
                this.share_url = share_url;
            }

            public String getShare_desc() {
                return share_desc;
            }

            public void setShare_desc(String share_desc) {
                this.share_desc = share_desc;
            }
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
