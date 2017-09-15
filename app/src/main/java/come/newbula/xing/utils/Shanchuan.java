package come.newbula.xing.utils;

import android.content.Context;
import android.util.Log;

import com.alibaba.sdk.android.vod.upload.VODUploadCallback;
import com.alibaba.sdk.android.vod.upload.VODUploadClient;
import com.alibaba.sdk.android.vod.upload.VODUploadClientImpl;
import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import com.alibaba.sdk.android.vod.upload.model.VodInfo;

import java.util.ArrayList;
import java.util.List;

/**
 *  趣拍视频上传
 */

public class Shanchuan {

    private String uploadAuth = "eyJBY2Nlc3NLZXlJZCI6IlNUUy5NWEMxTFhHRjJYRnJ2Ukc0VlJLaTJXVUVZIiwiQWNjZXNzS2V5U2VjcmV0IjoiOVBUTno4NTNqMjVxcjJiazFjRzdCMmNaVXhqdDhEQ1ZFaDZNSlhGTVdkUUIiLCJFeHBpcmF0aW9uIjoiMjAxNy0wOS0xNFQxNTo1MToxMVoiLCJTZWN1cml0eVRva2VuIjoiQ0FJU3hRUjFxNkZ0NUIyeWZTaklySnYyZXZic3Fwa1Q3NFNaZEhUMjBGWUhSK1lldUpEdXV6ejJJSHBLZVhkdUFlQVhzL28wbW1oWjcvWVlsclVxRmM0VUhCT2VQWk1ydjg0UHJWdjVKcGZadjh1ODRZQURpNUNqUVo5Mm1JeDBuNTI4V2Y3d2FmK0FVR0RIQ1RtZDVMNFpvOWJUY1RHbFFDWThXUC90b0pWN2I5TVJjeENsWkQ1ZGZybC9MUmRqcjhsb2hSS3pVUEcyS1V6U24zYjNCa2hsc1JZZThtUms4dmFhMzhtQTZ3TFhsa0hIMHVzU3JvaVRVWisvZEp0Tk9wWmpVdDZwMGNscmNyYkF5Q2RLOXlWUzhLQi9nTTRpL2l6YzdPeUZCMTVZN3kyUEtmYTJpTnAwTjExRWZxdzlFcUo4cGVMZ3Z2cGdxNDZna0ovc21UMUtPUGxSWGpqU1laMmszTXJjRWZtMUM4NDljci8zV1FUS3ljdmRINVB5cVI4QmZIWUhOUnREWWNZY01udDNBQkJPTXpiQk1mMkk5VXp0YUFXdVFMU2czYjAvcytweTFFNjYyZHVSTzMyU1I2bVl5UzhDSnFJa2EwUWhPd1YwdUd2NmFmMGljaGRRUzFwOUc2M3ZXZWNWVmgxRnJyN3l0Z0QvVHpCcHltb3QzOGZ6ZlBUTG9Lc1NHNDJkYUp0Tnl0Z2FmNDhVOFRsb0hWWHhEdWoyMHhoTUpEWTBHT2dPaVBDOFk4L21yZStPMGJuS092N0hHNnRBcEZSV2ZEZVc4M0xjWkN0OGNRUzB2NEFPTm5UQ3BPaUJsUGFKcXMweFFVNTN1WW9QU0ZuZUlKTTM5d0ErdSsyMzkwaXhpTGF6RFN2MG9UcGxvb2VCcGRVWHRCUmVFNjM2MDdQSWpGbjNwMmVOWktRMW9zRFRWVkIwVEE2L0UzNERtNnJNMnl4Wi8wQlF6ai92WlU1T3NnVEx6eHFaZU13S3ovcTF3WDkvQzY1SW92akRjVENrODNXUnB5VlBGMTNKTWhxQUFTVU5CUThpWlZwOFVRWTVkL0JDQ2pQZlNMMHp1OFB4ZHZyRjFsSmtXeEY1VWNSRVlNZnpTWDVyRXY4UkprdE9oNUZiUlJqVG1RZXh5Um9sQk5waGU2cFZncHhCQkFoa2ZNeEg4cGNRUWxHMXk0ZmJTdnFKNVB5OWcyK2ZORTdyeXBKaXlZdXIyMGhDeC9MbzhFamdyZHJ3MEdyazRUTCtFaHFiTkhLMHdNUGIifQ==";

    private String uploadAddress = "eyJFbmRwb2ludCI6Imh0dHBzOi8vb3NzLWNuLXNoYW5naGFpLmFsaXl1bmNzLmNvbSIsIkJ1Y2tldCI6ImluLTIwMTcwODI5MTYwMDE5MjgxLThjeTQxM3hpeTMiLCJGaWxlTmFtZSI6InZpZGVvLzQwOUUwRDRBLTE1RTdGMjdEODAyLTE2OTktMTcyOC0wMzktMjA0MDAubXA0In0=";

    private String accessKeyId = "STS.HtS2RoNbimPzt6k9pBaN61mV6";

    private String accessKeySecret = "7AA1nwJWsdJTrNzU5YHb8DL6aPdNt8Ta8HSmcCpinXyR";

    private VODUploadClient uploader;

     private  static Shanchuan shanchuan;

     private Shanchuan(Context context){
         uploader = new VODUploadClientImpl(context);
     };

     public  static  Shanchuan getShanchuan(Context context){

         if(null == shanchuan){
             shanchuan = new Shanchuan(context);
         }
         return shanchuan;
     }


    public void ShanChuanShiPin(String patch){

        uploader.addFile(patch,getVodInfo());
        uploader.init(accessKeyId, accessKeySecret, callback);
        uploader.start();
    }


    private VodInfo getVodInfo() {
        VodInfo vodInfo = new VodInfo();
        vodInfo.setTitle("标题" + 0);
        vodInfo.setDesc("描述." + 0);
        vodInfo.setCateId(0);
        vodInfo.setIsProcess(true);
        vodInfo.setCoverUrl("https://www.baidu.com/index.php?tn=monline_3_dg");
        List<String> tags = new ArrayList<>();
        tags.add("标签" + 0);
        vodInfo.setTags(tags);
        vodInfo.setIsShowWaterMark(false);
        vodInfo.setPriority(7);
        return vodInfo;
    }


    VODUploadCallback callback = new VODUploadCallback() {
        /**
         * 上传成功回调
         */
        public void onUploadSucceed(UploadFileInfo info) {
            Log.d("dou","上传成功");
            }
        /**
         * 上传失败
         */
        public  void onUploadFailed(UploadFileInfo info, String code, String message) {
            Log.d("dou","上传失败");
        }
        /**
         * 回调上传进度
         * @param uploadedSize 已上传字节数
         * @param totalSize 总共需要上传字节数
         */
        public void onUploadProgress(UploadFileInfo info, long uploadedSize, long totalSize) {
            Log.d("dou","上传中");
        }
        /**
         * 上传凭证过期后，会回调这个接口
         * 可在这个回调中获取新的上传，然后调用resumeUploadWithAuth继续上传
         */
        public void onUploadTokenExpired() {
            Log.d("dou","凭证失败");
        }
        /**
         * 上传过程中，状态由正常切换为异常时触发
         */
        public   void onUploadRetry(String code, String message) {
            Log.d("dou","上传异常");
        }
        /**
         * 上传过程中，从异常中恢复时触发
         */
        public  void onUploadRetryResume() {
            Log.d("dou","上传异常消失");
        }
        /**
         * 开始上传
         */
        @Override
        public void onUploadStarted(UploadFileInfo uploadFileInfo) {
            Log.d("dou","开始上传");
            uploader.setUploadAuthAndAddress(uploadFileInfo, uploadAuth, uploadAddress);
        }
    };


}
