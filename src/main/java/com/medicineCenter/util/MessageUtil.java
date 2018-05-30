package com.medicineCenter.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/*
功能:		web.duanxinwang.cc HTTP接口 发送短信

说明:		http://web.duanxinwang.cc/asmx/smsservice.aspx?name=登录名&pwd=接口密码&mobile=手机号码&content=内容&sign=签名&stime=发送时间&type=pt&extno=自定义扩展码
*/
public class MessageUtil {

    public static void main(String[] args) throws Exception {


        // 电话号码字符串，中间用英文逗号间隔
          StringBuffer mobileString=new StringBuffer("13115519350");
        // 内容字符串
//        StringBuffer contextString=new StringBuffer("黑龙江省食品药品审核查验中心提醒您，请您在检查期间严格遵守以下廉政要求：\n" +
//                "    一、不准收受被认证、检查、核查单位的现金、有价证券、支付凭证及礼品。不准违反原则及认证、检查、核查标准，将不具备条件的单位通过认证、检查及核查。\n" +
//                "    二、严格遵守承诺制、公示制、组长负责制和食品药品认证、检查及核查纪律要求；严格落实食品药品认证、检查及核查方案；严格执行食品药品认证、检查及核查标准。\n" +
//                "    三、认证、检查及核查要细致；记录要详实；评价要公正；现场认证、检查及核查情况反映要客观。\n" +
//                "    四、严禁参加由地方局或行政相对人组织的宴请、娱乐健身和旅游等及其他可能影响执行公务的活动；严禁在认证、检查及核查期间饮酒；严禁向被检单位提出与工作无关的额外要求、泄露被检单位商业秘密和其他应保密的工作秘密；严禁接受超标准住宿和在被检单位报销应由个人支付的费用。严禁利用认证、检查及核查权，吃、拿、卡、要，刁难、粗暴对待被认证、检查及核查的行政相对人。\n" +
//                "\n" +
//                "中心纪委联系人：尹大志，电话：0451-51983680\n");

        StringBuffer contextString=new StringBuffer("黑龙江省食品药品审核查验中心提醒您，请您在检查期间严格遵守以下廉政要求：\n" +
                "一、不准收受被认证、检查、核查单位的现金、有价证券、支付凭证及礼品。不准违反原则及认证、检查、核查标准，将不具备条件的单位通过认证、检查及核查。\n" +
                "二、严格遵守承诺制、公示制、组长负责制和食品药品认证、检查及核查纪律要求；严格落实食品药品认证、检查及核查方案；严格执行食品药品认证、检查及核查标准。\n" +
                "三、认证、检查及核查要细致；记录要详实；评价要公正；现场认证、检查及核查情况反映要客观。\n" +
                "四、严禁参加由地方局或行政相对人组织的宴请、娱乐健身和旅游等及其他可能影响执行公务的活动；严禁在认证、检查及核查期间饮酒；严禁向被检单位提出与工作无关的额外要求、泄露被检单位商业秘密和其他应保密的工作秘密；严禁接受超标准住宿和在被检单位报销应由个人支付的费用。严禁利用认证、检查及核查权，吃、拿、卡、要，刁难、粗暴对待被认证、检查及核查的行政相对人。\n" +
                "五、文明礼貌，热情服务，谦虚谨慎，不骄不躁，仪容整洁。\n" +
                "中心纪委联系人：尹大志，电话：0451-51983680\n");
        // 签名
        String sign="";
        // 追加发送时间，可为空，为空为及时发送
        String stime="";
        // 扩展码，必须为数字 可为空
        StringBuffer extno=new StringBuffer();

        System.out.println(doPost( mobileString, contextString, sign, stime, extno));
    }

    /**
     * 发送短信T
     * @param mobileString	电话号码字符串，中间用英文逗号间隔
     * @param contextString	内容字符串
     * @param sign			签名
     * @param stime			追加发送时间，可为空，为空为及时发送
     * @param extno			扩展码，必须为数字 可为空
     * @return
     * @throws Exception
     */
    public static String doPost(
                                StringBuffer mobileString, StringBuffer contextString,
                                String sign, String stime, StringBuffer extno) throws Exception {
        // 用户名
        String name="chayanzhongxin";
        // 密码
        String pwd="9566F055E9035017A05D5B1B6C12";
        StringBuffer param = new StringBuffer();
        param.append("name="+name);
        param.append("&pwd="+pwd);
        param.append("&mobile=").append(mobileString);
        param.append("&content=").append(URLEncoder.encode(contextString.toString(),"UTF-8"));
        param.append("&stime="+stime);
        param.append("&sign=").append(URLEncoder.encode(sign,"UTF-8"));
        param.append("&type=pt");
        param.append("&extno=").append(extno);

        URL localURL = new URL("http://web.duanxinwang.cc/asmx/smsservice.aspx?");
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;

        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(param.length()));

        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        String resultBuffer = "";

        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);

            outputStreamWriter.write(param.toString());
            outputStreamWriter.flush();

            if (httpURLConnection.getResponseCode() >= 300) {
                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
            }

            inputStream = httpURLConnection.getInputStream();
            resultBuffer = convertStreamToString(inputStream);

        } finally {

            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }

            if (reader != null) {
                reader.close();
            }

            if (inputStreamReader != null) {
                inputStreamReader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }

        }
        System.out.println(resultBuffer);
        return resultBuffer;
    }


    /**
     * 转换返回值类型为UTF-8格式.
     * @param is
     * @return
     */
    public static String convertStreamToString(InputStream is) {
        StringBuilder sb1 = new StringBuilder();
        byte[] bytes = new byte[4096];
        int size = 0;
        try {
            while ((size = is.read(bytes)) > 0) {
                String str = new String(bytes, 0, size, "UTF-8");
                sb1.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb1.toString();
    }

}
