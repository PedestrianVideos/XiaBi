package come.newbula.xing.ui;


import java.util.HashMap;
import java.util.Map;

/**
 * 文 件 名:  Constants.java
 * 版    权:  cttq
 * 描    述:  <全局静态变量>
 * 版    本： <版本号>
 * 创 建 人:  姜飞
 * 创建时间:  2015年10月13日
 */
public class Constants
{

    /**
     * 1：扫码<br >
     * 2：根据环信用户名查询个人信息<br >
     */
    public static final Integer[] USER_REQTYPE = new Integer[]{1, 2};

    /**
     * APP_CODE
     */
    public static final String APP_CODE = "cim";

    /**
     * SOURCE_TYPE
     */
    public static final String SOURCE_TYPE = "android";

    /**
     * 保存是否是新用户
     */
    public static final String NEWS_USER = "newsUser";

    /**
     * sharedPreferences中保存用户的信息文件名
     */
    public static final String USER_INFO = "newUserInfo";

    /**
     * sharedPreferences中保存手机的信息文件名
     */
    public static final String MOBILE_INFO = "mobileInfo";

    /**
     * 广播接收器key
     */
    public static final class BroadcastReceiverKey
    {
        /**
         * 包名
         */
        public static final String PACKAGE_NAME = Constants.class.getPackage().getName() + ".";

        /**
         * 调查记录动态更新页面广播
         */
        public static final String WORKBENCH_SURVEY_REMEMBER_UPDATE = PACKAGE_NAME + "workbench_survey_remember_update";

        /**
         * 调查选择发送记录广播
         */
        public static final String SURVEY_SELECT_SENDREMEMBER = PACKAGE_NAME + "survey_select_sendremember";

        /**
         * 调查收藏动态更新页面广播
         */
        public static final String WORKBENCH_SURVEY_COLLECT_UPDATE = PACKAGE_NAME + "workbench_survey_collect_update";

        /**
         * 患教收藏动态更新广播
         */
        public static final String WORKBENCH_PATIENTEDU_COLLECT_UPDATE = PACKAGE_NAME + "workbench_patientedu_collect_update";

        /**
         * 患教发送成功后发送记录更新。
         */
        public static final String WORKBENCH_PATIENTEDU_SENDRECORD_ADD = PACKAGE_NAME + "workbench_patientedu_sendrecord_add";

        /**
         * 患者取消预约
         */
        public static final String PATIENT_CANCEL_ORDER_RESERVATION = PACKAGE_NAME + "PATIENTCANCELORDERRESERVATION";

        /**
         * 患者预约成功
         */
        public static final String PATIENT_ORDER_SUCCESS_RESERVATION = PACKAGE_NAME + "PATIENTORDERSUCCESSRESERVATION";

        /**
         * 取消或结束问诊
         */
        public static final String END_OR_CANCEL_OFFICE_RESERVATION = PACKAGE_NAME + "ENDORCANCELOFFICERESERVATION";

        /**
         * 同步诊室数据，医生下一个时会用到
         */
        public static final String SYNC_OFFICE_DATA_RESERVATION = PACKAGE_NAME + "SYNCOFFICEDATARESERVATION";

        /**
         * 点击下一个时,界面存在多个取消的患者信息,要移除
         */
        public static final String CANCEL_PATIENTS_RECEIVER = PACKAGE_NAME + "broadcast.CANCELPATIENTSRECEIVER";

        /**
         * 系统推送的取消预约或预约广播-诊室页面
         */
        public static final String CANCEL_PATIENT_OFFICE_RESERVATION = PACKAGE_NAME + "CANCELPATIENTOFFICERESERVATION";

        /**
         * 患者结束坐诊
         */
        public static final String END_INQUIRY_RESERVATION = PACKAGE_NAME + "ENDINQUIRYRESERVATION";

        /**
         * 开诊成功
         */
        public static final String OPEN_OFFICE_SUCCESS = PACKAGE_NAME + "OPENOFFICESUCCESS";

        /**
         * 接收患教选择
         */
        public static final String SELECT_PATINET_EDU_ACTION = PACKAGE_NAME + "SELECTPATINETEDUACTION";

        /**
         * 更新患教选择
         */
        public static final String UPDATE_PATIENT_EDU_ACTION = PACKAGE_NAME + "UPDATEPATIENTEDUACTION";

        /**
         * 收到好友通知，更新通知列表
         */
        public static final String UPDATE_FRIEND_NOTICES_ACTION = PACKAGE_NAME + "UPDATEFRIENDNOTICESACTION";

        /**
         * 提醒医生
         */
        public static final String REMIND_RECEIVER = PACKAGE_NAME + "broadcast.REMINDRECEIVER";

        /**
         * 好友通知
         */
        public static final String FRIEND_MSG_NOTICE_RECEIVER = PACKAGE_NAME + "broadcast.FRIENDMSGNOTICERECEIVER";

        /**
         * 消息通知
         */
        public static final String HX_MSG_NOTICE_RECEIVER = PACKAGE_NAME + "broadcast.HXMSGNOTICERECEIVER";

        /**
         * 接收到新消息，消息页面的广播
         */
        public static final String RECEIVE_NEW_MESSAGE_RECEIVER = PACKAGE_NAME + "broadcast.receivenewmessagereceiver";

        /**
         * 接收到消息之后，首页更新未读消息数
         */
        public static final String MESSAGE_UNREAD_RECEIVE = PACKAGE_NAME + "broadcast.messageunreadreceive";

        /**
         * 接收消息时消息页面的广播
         */
        public static final String MESSAGE_ACTIVITY_RECEIVE = PACKAGE_NAME + "broadcast.messageactivityreceive";

        /**
         * 添加新复查
         */
        public static final String REVIEW_NEW_ADD_RECEIVE = PACKAGE_NAME + "broadcast.reviewnewaddreceive";

        /**
         * 更新复查
         */
        public static final String REVIEW_UPDATE_RECEIVE = PACKAGE_NAME + "broadcast.reviewupdatereceive";


        /**
         * 选择患教模板库receiver
         */
        public static final String SWITCH_PATIENTEDU_TEMPLATE_RECEIVE = PACKAGE_NAME + "switch_patientedu_template_receive";

        /**
         * 帖子广播action
         */
        public static final String POSTACTION = PACKAGE_NAME + "broadcast.POSTACTION";
        public static final String LOGINSUCCESSCALLBACK = PACKAGE_NAME + "broadcast.loginsuccesscallback";

        /**
         * 帖子广播action
         */
        public static final String POSTACTIONDELECT = PACKAGE_NAME + "broadcast.POSTACTIONDELECT";

        /**
         * 没有权限广播action
         */
        public static final String NONEPERMISSIONACTION = PACKAGE_NAME + "broadcast.NONEPERMISSION";

        /**
         * 登录过期广播action
         */
        public static final String LOGINEXPIRATIONACTION = PACKAGE_NAME + "broadcast.LOGINEXPIRATION";

        /**
         * 修改病种之后的广播通知
         */
        public static final String SICK_KIND_NAME_CHANGE = PACKAGE_NAME + "broadcast.sick_kind_name_change";

        /**
         * 助手端 接收到消息之后，首页更新未读消息数
         */
        public static final String AIDE_MESSAGE_UNREAD_RECEIVE = PACKAGE_NAME + "broadcast.messageunreadreceive_aide";
        /**
         * 帖子广播action 帖子列表点赞,帖子详情回复数，阅读数
         */
        public static final String POSTACTIONRPRAISE = PACKAGE_NAME + "broadcast.POSTACTIONRPRAISE";
        /**
         * 帖子广播action 选择类型，刷新ui
         */
        public static final String POSTACTIONREFRESHUI = PACKAGE_NAME + "broadcast.POSTACTIONREFRESHUI";
        /**
         * 帖子广播action 删除帖子
         */
        public static final String POSTACTIONDELCARD = PACKAGE_NAME + "broadcast.POSTACTIONDELCARD";
        /**
         * 帖子广播action 删除回复
         */
        public static final String POSTACTIONDELREPLY = PACKAGE_NAME + "broadcast.POSTACTIONDELREPLY";
        /**
         * 帖子广播action 回复
         */
//        public static final String POSTACTIONREPLY = PACKAGE_NAME + "broadcast.POSTACTIONREPLY";
//        public static final String POSTACTIONCARD = PACKAGE_NAME + "broadcast.POSTACTIONCARD";

        public static final String COVERVIEWBROADCASTVISITOR = PACKAGE_NAME + "broadcast.coverviewbroadcastvisitor";
        public static final String COVERVIEWBROADCASTHIDE = PACKAGE_NAME + "broadcast.coverviewbroadcasthide";
        /**
         * 帖子广播action 老罗删除回复
         */
        public static final String POSTACTIONLUODELREPLY = PACKAGE_NAME + "broadcast.POSTACTIONLUODELREPLY";
        public static final String ADDDETAILSREPLY = PACKAGE_NAME + "broadcast.DETAILSADDREPLY";
    }


    /**
     * 成功码
     */
    public static final int SUCESS_CODE = 100;

    /**
     * 参数异常
     */
    public static final int PARAM_EXCEPTION_CODE = 104;

    /**
     * 没有权限
     */
    public static final int UNPERMISSION_CODE = 108;

    /**
     * 系统异常
     */
    public static final int SYS_EXCEPTION_CODE = 116;

    /**
     * 未登录
     */
    public static final int UNLOGIN_CODE = 132;

    /**
     * 用户名或密码错误
     */
    public static final int USER_ERROR_CODE = 164;

    /**
     * 登陆信息过期
     */
    public static final int LOGIN_TIMEOUT_CODE = 228;

    /**
     * 错误码集合
     */
    public static final Map<String, String> RESLUTECODEMSG = new HashMap<String, String>();

    /**
     * 短信验证码发送成功
     */
    public static final String BS100 = "BS100";

    /**
     * 验证码正确
     */
    public static final String BS101 = "BS101";

    /**
     * 短信通知发送成功
     */
    public static final String BS102 = "BS102";

    /**
     * 注册成功
     */
    public static final String BS103 = "BS103";

    /**
     * 账号存在
     */
    public static final String BS104 = "BS104";

    /**
     * 重置密码成功
     */
    public static final String BS105 = "BS105";

    /**
     * 登陆成功
     */
    public static final String BS106 = "BS106";

    /**
     * 新建群组成功
     */
    public static final String BS138 = "BS138";

    /**
     * 群组信息修改成功
     */
    public static final String BS139 = "BS139";

    /**
     * 新增群组成员成功
     */
    public static final String BS140 = "BS140";

    /**
     * 添加群组成员，失败，被移除
     */
    public static final String BE071 = "BE071";

    /**
     * 删除群组成员成功
     */
    public static final String BS141 = "BS141";

    /**
     * app用户个人信息查询成功
     */
    public static final String BS142 = "BS142";

    /**
     * app 用户个人信息查询失败
     */
    public static final String BE056 = "BE056";

    /**
     * 回复已删除
     */
    public static final String BE132 = "BE132";

    /**
     * 回复已删除
     */
    public static final String BE151 = "BE151";

    /**
     * app用户通讯录查询成功
     */
    public static final String BS143 = "BS143";

    /**
     * app用户可能认识的人查询成功
     */
    public static final String BS144 = "BS144";

    /**
     * 申请好友成功
     */
    public static final String BS145 = "BS145";

    /**
     * 回应好友申请成功
     */
    public static final String BS146 = "BS146";

    /**
     * 回应好友申请成功,组ID号变更
     */
    public static final String BS154 = "BS154";

    /**
     * 回应好友申请失败
     */
    public static final String BE060 = "BE060";

    /**
     * 删除好友成功
     */
    public static final String BS147 = "BS147";

    /**
     * 添加好友分组成功
     */
    public static final String BS148 = "BS148";

    /**
     * 添加好友分组失败
     */
    public static final String BE062 = "BE062";

    /**
     * 更新好友分组成功
     */
    public static final String BS149 = "BS149";

    /**
     * 修改手机号
     */
    public static final String BS176 = "BS176";

    /**
     * 更新好友分组失败
     */
    public static final String BE063 = "BE063";

    /**
     * 删除好友分组成功
     */
    public static final String BS150 = "BS150";

    /**
     * 好友分组列表查询失败
     */
    public static final String BS151 = "BS151";

    /**
     * 好友分组列表查询失败
     */
    public static final String BE065 = "BE065";

    /**
     * 设置公私有操作成功
     */
    public static final String BS152 = "BS152";

    /**
     * 查询自己的个人详情
     */
    public static final String BS153 = "BS153";

    /**
     * 个人信息修改成功
     */
    public static final String BS161 = "BS161";

    /**
     * 个人信息修改成功
     */
    public static final String BS169 = "BS169";

    /**
     * 查询自己的个人详情
     */
    public static final String BS163 = "BS163";

    /**
     * 查询自己的个人详情
     */
    public static final String BS166 = "BS166";

    /**
     * 删除分组成功
     */
    public static final String BE064 = "BE064";

    /**
     * 删除好友成功
     */
    public static final String BE061 = "BE061";

    /**
     * 复查记录分页查询，成功
     */
    public static final String BS193 = "BS193";

    /**
     * 复查记录分页查询，失败
     */
    public static final String BE099 = "BE099";

    /**
     * 复查列表点赞，成功
     */
    public static final String BS194 = "BS194";

    /**
     * 复查列表点赞，失败
     */
    public static final String BE100 = "BE100";

    /**
     * 复查列表评论增加，成功
     */
    public static final String BS195 = "BS195";

    /**
     * 复查列表评论增加，失败
     */
    public static final String BE101 = "BE101";

    /**
     * 患者复查列表，成功
     */
    public static final String BS196 = "BS196";

    /**
     * 患者复查列表，失败
     */
    public static final String BE102 = "BE102";

    /**
     * 复查列表评论列表，成功
     */
    public static final String BS198 = "BS198";

    /**
     * 复查列表评论列表，失败
     */
    public static final String BE103 = "BE103";

    /**
     * 复查初始化查询/复查病种查询，成功
     */
    public static final String BS191 = "BS191";

    /**
     * 复查初始化查询/复查病种查询，失败
     */
    public static final String BE097 = "BE097";

    /**
     * 复查添加/编辑，成功
     */
    public static final String BS192 = "BS192";

    /**
     * 复查添加/编辑，失败
     */
    public static final String BE098 = "BE098";

    /**
     * 模板库订阅失败
     */
    public static final String BE086 = "BE086";

    /**
     * 意见反馈成功
     */
    public static final String BS174 = "BS174";

    /**
     * 积分记录查询
     */
    public static final String BS173 = "BS173";

    /**
     * 认证申请
     */
    public static final String BS175 = "BS175";

    /**
     * 商品查询成功
     */
    public static final String BS2110 = "BS2110";

    /**
     * 非受邀医生主页统计-成功
     */
    public static final String BS203 = "BS203";

    /**
     * 非受邀医生主页统计-失败
     */
    public static final String BE107 = "BE107";

    /**
     * 非受邀医生我感兴趣记录-成功
     */
    public static final String BS204 = "BS204";

    /**
     * 非受邀医生我感兴趣记录-失败
     */
    public static final String BE108 = "BE108";

    /**
     * 受邀医生创建诊室-成功
     */
    public static final String BS205 = "BS205";

    /**
     * 受邀医生创建诊室-失败
     */
    public static final String BE109 = "BE109";

    /**
     * 受邀医生取消坐诊 -成功
     */
    public static final String BS206 = "BS206";

    /**
     * 受邀医生取消坐诊 -失败
     */
    public static final String BE110 = "BE110";

    /**
     * 受邀医生诊室列表-成功
     */
    public static final String BS207 = "BS207";

    /**
     * 受邀医生诊室列表 -失败
     */
    public static final String BE111 = "BE111";

    /**
     * 受邀医生诊室患者列表-成功
     */
    public static final String BS208 = "BS208";

    /**
     * 受邀医生诊室患者列表 -失败
     */
    public static final String BE112 = "BE112";

    /**
     * 快捷回复-成功
     */
    public static final String BS209 = "BS209";

    /**
     * 快捷回复 -失败
     */
    public static final String BE113 = "BE113";

    /**
     * 下一个 患者 -成功
     */
    public static final String BS211 = "BS211";

    /**
     * 下一个 患者 -失败
     */
    public static final String BE115 = "BE115";

    /**
     * 开诊 -成功
     */
    public static final String BS212 = "BS212";

    /**
     * 开诊无患者
     */
    public static final String BE217 = "BE217";

    /**
     * 开诊 -失败
     */
    public static final String BE116 = "BE116";

    /**
     * 提醒-成功
     */
    public static final String BS210 = "BS210";

    /**
     * 提醒-失败
     */
    public static final String BE114 = "BE114";

    /**
     * 初始化接口
     */
    public static final String BS227 = "BS227";

    /**
     * 悬浮框，数据获取成功
     */
    public static final String BS223 = "BS223";

    /**
     * 悬浮框，数据获取失败
     */
    public static final String BE127 = "BE127";

    /**
     * 擅长病种查询-成功
     */
    public static final String BS268 = "BS268";

    /**
     * 擅长病种查询-失败
     */
    public static final String BE174 = "BE174";

    /**
     * 擅长领域查询-成功
     */
    public static final String BS269 = "BS269";

    /**
     * 擅长领域查询-失败
     */
    public static final String BE175 = "BE175";

    /**
     *
     */
    public static final String BE131 = "BE131";

    /**
     * 帖子鼓励成功
     */
    public static final String BS237 = "BS237";

    /**
     * 帖子列表   //我的帖子
     */
    public static final String BS229 = "BS229";

    /**
     * 删除帖子
     */
    public static final String BS232 = "BS232";

    /**
     * 获取消息成功
     */
    public static final String BS248 = "BS248";

    /**
     * 获取消息失败
     */
    public static final String BE148 = "BE148";

    /**
     * 角色1，医生
     */
    public static final Integer DOCTOR = 1;

    /**
     * 角色2，患者
     */
    public static final Integer PATIENT = 2;

    /**
     * 角色3：助手
     */
    public static final Integer ACCOUNTTYPE = 3;

    public static final Integer KEFU = 10;

    /**
     * 用户没有登录的账号信息
     */
    public static final String NONEACCOUNT = "000000000";

    /**
     * 消息列表每页请求条数
     */
    public static final int MSGPAGENUM = 10;

    /**
     * 密钥
     */
    public static final String DIGESTROLE = "aabbcc112233";

    /**
     * 环信单聊对方id
     */
    public static final String HX_TO_CHAT_SINGLE_ID = "hxToChatSingleId";

    /**
     * 环信群组id
     */
    public static final String HX_TO_CHAT_GROUP_ID = "hxToChatGroupId";

    /**
     * 环信群组名称
     */
    public static final String HX_TO_CHAT_GROUP_NAME = "hxToChatGroupName";

    /**
     * app用户登录id
     */
    public static final String APP_USER_LOGIN_ID = "appUserLoginId";

    /**
     * app用户账户名称
     */
    public static final String APP_USER_LOGIN_NAME = "appUserLoginName";

    /**
     * app用户CID
     */
    public static final String APP_USER_LOGIN_CID = "appUserLoginCid";

    /**
     * app用户信息
     */
    public static final String APP_USER_INFO = "appUserInfo";

    /**
     * app用户账号类型
     */
    public static final String APP_ACCOUNT_TYPE = "appAccountType";

    /**
     * 复查缩率图的获取大小，使用顽兔自带功能（90w*90h）
     */
    public static final String REVIEW_IMG_COMPRESSION = "@90w_90h_0e.png";

    /**
     * 病程明细信息查询成功
     */
    public static final String BS241 = "BS241";

    /**
     * 个人病程明细信息更新成功
     */
    public static final String BS242 = "BS242";

    /**
     * 病程首页信息查询成功
     */
    public static final String BS324 = "BS324";

    /**
     * 是否关注
     */
    public static final String BS320 = "BS320";

    /**
     * 新增或修改用药记录成功
     */
    public static final String BS247 = "BS247";

    /**
     * 病种
     */
    public static final String BS167 = "BS167";

    /**
     * 阶段
     */
    public static final String BS168 = "BS168";

    /**
     * 收藏成功
     */
    public static final String BS156 = "BS156";

    /**
     * 收藏失败
     */
    public static final String BE163 = "BE163";

    /**
     * 取消收藏成功
     */
    public static final String BS155 = "BS155";

    /**
     * 取消收藏失败
     */
    public static final String BE164 = "BE164";

    /**
     * 医生的患者列表集合获取成功
     */
    public static final String BS321 = "BS321";

    /**
     * 慢病管理集合获取成功
     */
    public static final String BS318 = "BS318";

    /**
     * 患者--我的关注集合获取成功
     */
    public static final String BS319 = "BS319";

    /**
     * 搜索患者列表成功
     */
    public static final String BS388 = "BS388";

    /**
     * 医生接受患者的报到成功
     */
    public static final String BS280 = "BS280";

    /**
     * 患者信息集合获取失败
     */
    public static final String BE193 = "BE193";
    /**
     * 活动二维码相关地址获取成功
     */
    public static final String BS380 = "BS380";

    /**
     * S11 豆朋坤 搜索未注册医生
     */
    public static final String BS391 = "BS391";

    /**
     * S11 豆朋坤 某医生的患者查询成功
     */
    public static final String BS392 = "BS392";

    /**
     * 文 件 名:  Constants.java
     * 版    权:  cttq
     * 描    述:  <手机信息常用变量>
     * 版    本： <版本号>
     * 创 建 人:  姜飞
     * 创建时间:  2015年11月2日
     */
    public static class MobileInfo
    {
        /**
         * 手机型号
         */
        public static String MODEL = "";

        /**
         * 手机操作系统版本
         */
        public static String VERSIONRELEASE = "";

        /**
         * 软件当前版本号
         */
        public static String VERSIONCODE = "";

        /**
         * 软件当前版本名称
         */
        public static String VERSIONNAME = "";

        /**
         * IMEI
         */
        public static String MOBILEIMEI = "";

    }

    public static class BroadcastCode
    {
        /**
         * 患者取消预约推送消息
         */
        public static final String EBS192 = "EBS192";

        /**
         * 到就诊时间推送消息
         */
        public static final String EBS195 = "EBS195";

        /**
         * 开诊前15分钟推送消息
         */
        public static final String EBS196 = "EBS196";

        /**
         * 提前一小时查看诊室是否存在患者
         */
        public static final String EBS197 = "EBS197";

        /**
         * 患者结束问诊推送消息
         */
        public static final String EBS199 = "EBS199";

        /**
         * 提醒医生, 推送消息
         */
        public static final String EBS202 = "EBS202";

        /**
         * 预约成功推送医生消息
         */
        public static final String EBS203 = "EBS203";

        /**
         * 患者关注通知
         */
        public static final String EBS2000 = "2000";

        /**
         * 好友申请通知
         */
        public static final String EBS1000 = "1000";

    }

    public static boolean isShowLoginRemind = false;

    /**
     * 发帖子
     */
    public static final String BS228 = "BS228";

    /**
     * 既可以对帖子进行回复，又可以对他人回复进行回复
     */
    public static final String BS233 = "BS233";

    /**
     * 删除回复成功
     */
    public static final String BS234 = "BS234";

    /**
     * 帖子详情
     */
    public static final String BS230 = "BS230";

    /**
     * 加载首页数据成功
     */
    public static final String BS264 = "BS264";

    /**
     * 加载首页数据失败
     */
    public static final String BE170 = "BE170";

    /**
     * 服务项列表类型 1.所有服务项 2.已开通服务项3.未开通服务项
     */
    public static final Integer ALL_SERVICE_ITEM = 1;

    /**
     * 2.已开通服务项
     */
    public static final Integer OPENED_SERVICE_ITEM = 2;

    /**
     * 2.未开通服务项
     */
    public static final Integer NERVER_OPENED_SERVICE_ITEM = 3;

    /**
     * 回复已删除
     */
    public static final String BE133 = "BE133";

    /**
     * 帖子不存在，提交举报失败
     */
    public static final String BE137 = "BE137";

    /**
     * 回复不存在，提交举报失败
     */
    public static final String BE138 = "BE138";

    /**
     * 举报成功
     */
    public static final String BS239 = "BS239";

    /**
     * 重复举报
     */
    public static final String BE140 = "BE140";

    /**
     * 帖子已删除
     */
    public static final String BE128 = "BE128";

    /**
     * 定位失败
     */
    public static final String BE212 = "BE212";

    /**
     * 定位成功
     */
    public static final String BS301 = "BS301";

    /**
     * 绑定医生成功
     */
    public static final String BS317 = "BS317";

    /**
     * 绑定医生失败
     */
    public static final String BE231 = "BE231";

    /**
     * 上传复查结果成功
     */
    public static final String BS190 = "BS190";

    /**
     * 更新医嘱已读状态成功
     */
    public static final String BS199 = "BS199";

    /**
     * 获取我的医生成功
     */
    public static final String BS315 = "BS315";

    /**
     * 获取我的医生失败
     */
    public static final String BE229 = "BE229";

    /**
     * 2.3.4全部医生列表页加载成功
     */
    public static final String BS316 = "BS316";

    /**
     * 全部医生列表页加载失败
     */
    public static final String BE230 = "BE230";

    /**
     * 患者全部求助加载成功
     */
    public static final String BS344 = "BS344";

    /**
     * 帮助患者提交成功
     */
    public static final String BS345 = "BS345";

    /**
     * 医生动态加载成功
     */

    public static final String BS370 = "BS370";
    /**
     * 某医生动态加载成功
     */

    public static final String BS368 = "BS368";
    /**
     * 患者动态加载成功
     */
    public static final String BS369 = "BS369";

    /**
     * 用户钱包信息
     */
    public static final String BS349 = "BS349";

    /**
     * 钱包收支流水
     */
    public static final String BS351 = "BS351";

    /**
     * 补充个人信息
     */
    public static final String BS341 = "BS341";
    /**
     * 钱包账户列表
     */
    public static final String BS350 = "BS350";
    /**
     * 钱包新建、修改账号
     */
    public static final String BS342 = "BS342";
    /**
     * 首页广告
     */
    public static final String BS347 = "BS347";
    /**
     * 选择公司
     */
    public static final String BS340 = "BS340";
    /**
     * 钱包提现
     */
    public static final String BS352 = "BS352";
    /**
     * 达人榜
     */
    public static final String BS348 = "BS348";
    /**
     * 服务介绍
     */
    public static final String BS375 = "BS375";
    /**
     * 助手查询认证信息
     */
    public static final String BS377 = "BS377";

    /**
     * 删除病程条目成功
     */
    public static final String BS365 = "BS365";
    /**
     * 删除病程条目成功
     */
    public static final String BS366 = "BS366";

    /**
     * 删除病程条目失败
     */
    public static final String BE282 = "BE282";

    /**
     * 查询病程首页个人信息和曲线图表
     */
    public static final String BS286 = "BS286";

    /**
     * 查询病程列表
     */
    public static final String BS356 = "BS356";

    /**
     * 病程首页信息查询成功
     */
    public static final String BS245 = "BS245";
    /**
     * 诊疗记录
     */
    public static final String BS357 = "BS357";
    /**
     * 查看更多趋势
     */
    public static final String BS353 = "BS353";
    /**
     * 检查记录
     */
    public static final String BS361 = "BS361";
    /**
     * 处方用药
     */
    public static final String BS359 = "BS359";
    /**
     * 新增病例
     */
    public static final String BS363 = "BS363";
    /**
     * 助手信息
     */
    public static final String BS346 = "BS346";

    /**
     * 钱包提现验证码有误
     */
    public static final String BE003 = "BE003";

    /**
     * 服务器返回 内容缺失
     */
    public static final String BE290 = "BE290";
    /**
     * 服务器返回 内容缺失
     */
    public static final String BS384 = "BS384";

    /**
     *
     */
    public static final String BE104 = "BE104";

    /**
     * 该手机号已绑定其他微信号：BE303,
     */
    public static final String BE303 = "BE303";

    /**
     * 微信绑定成功：BS394，
     */
    public static final String BS394 = "BS394";

    /**
     * 微信绑定失败：BE301，
     */
    public static final String BE301 = "BE301";

    /**
     * 尚未绑定：BS393
     */
    public static final String BS393 = "BS393";

    /**
     * 拨打电话操作成功
     */
    public static final String BS270 = "BS270";

    /**
     * 首页 动态和求助数量查询成功
     */
    public static final String BS398 = "BS398";

    /**
     * 医生动态钉住/取消钉住
     */
    public static final String BS400 = "BS400";
    /**
     * 我的药品
     */
    public static final String BS423 = "BS423";
    /**
     * 选择药品添加
     */
    public static final String BS424 = "BS424";
    /**
     * 选择药品
     */
    public static final String BS425 = "BS425";
    /**
     * 选择药品
     */
    public static final String BS428 = "BS428";

    /**
     * 首页动态模块
     */
    public static final String BS422 = "BS422";
    /**
     * 药品详情
     */
    public static final String BS415 = "BS415";
    /**
     * 已发送医生
     */
    public static final String BS401 = "BS401";
    /**
     * 新增药品
     */
    public static final String BS426 = "BS426";
    /**
     * 新增药品（重复）
     */
    public static final String BE331 = "BE331";
    /**
     * 药品的所有药店
     */
    public static final String BS404 = "BS404";
    /**
     * 保存药品药店信息
     */
    public static final String BS405 = "BS405";
    /**
     * 申请处方二维码 医生列表
     */
    public static final String BS407 = "BS407";
    /**
     * 发送给医生列表
     */
    public static final String BS402 = "BS402";
    /**
     * 发送药品给医生
     */
    public static final String BS413 = "BS413";
    /**
     * 患者信息集合获取成功
     */
    public static final String BS281 = "BS281";
    /**
     * 提交申请处方二维码
     */
    public static final String BS408 = "BS408";
    /**
     * 申请记录
     */
    public static final String BS414 = "BS414";
    /**
     * 地址列表
     */
    public static final String BS2120 = "BS2120";
    /**
     * 查询地址
     */
    public static final String BS2121 = "BS2121";
    /**
     * 医生药箱
     */
    public static final String BS431 = "BS431";

    /**
     * 添加药店成功
     */
    public static final String BS427 = "BS427";

    /**
     * 药店重复
     */
    public static final String BE337 = "BE337";

    /**
     * 删除医生药品   huo   向我比心列表
     */
    public static final String BS432 = "BS432";
    /**
     * 添加地址
     */
    public static final String BS2122 = "BS2122";
    /**
     * 删除地址
     */
    public static final String BS2123 = "BS2123";
    /**
     * 编辑地址
     */
    public static final String BS2124 = "BS2124";
    public static final String BS403 = "BS403";
    /**
     * 医生药箱 选择推荐药品
     */
    public static final String BS429 = "BS429";
    /**
     * 发送药品到医生药箱
     */
    public static final String BS430 = "BS430";
    /**
     * 直播列表
     */
    public static final String BS438 = "BS438";
    /**
     * 直播提示
     */
    public static final String BS439 = "BS439";
    /**
     * 直播身份赋予
     */
    public static final String BS440 = "BS440";
    /**
     * 分享文章给医生
     */
    public static final String BS416 = "BS416";
    /**
     * 分享视频给医生
     */
    public static final String BS442 = "BS442";

    /**
     * 最新回复数
     */
    public static final String BS417 = "BS417";
    /**
     * 2.2.5全部回复-我收到的回复(最新和历史收到回复)-新增(田海光)-成功
     */
    public static final String BS294 = "BS294";
    /**
     * 2.2.6全部回复-我回复的-新增(田海光)-成功
     */
    public static final String BS443 = "BS443";
    /**
     * 随访计划返回码
     * */
    public static  final String BS447="BS447";

    /**
     * 终止随访计划返回码
     * */
    public static  final String BS448="BS448";

    /**
     *   复查/其他 提醒详情
     * */
    public static  final String BS449="BS449";

    /**
     * 我的模板
     * */
    public static  final String BS418="BS418";
    /**
     * 删除模板
     * */
    public static  final String BS419="BS419";
    /**
     * 用药提醒
     * */
    public static  final String BS450="BS450";

    /**
     * 复查/其他  提醒模板详情
     * */
    public static  final String BS451="BS451";

}
