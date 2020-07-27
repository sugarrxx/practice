//package com.example.study.utils;
//
//import com.aliyun.oss.OSSClient;
//import com.aliyuncs.DefaultAcsClient;
//import com.aliyuncs.auth.sts.AssumeRoleRequest;
//import com.aliyuncs.auth.sts.AssumeRoleResponse;
//import com.aliyuncs.exceptions.ClientException;
//import com.aliyuncs.http.MethodType;
//import com.aliyuncs.profile.DefaultProfile;
//import com.aliyuncs.profile.IClientProfile;
//
//public class StsServiceSample {
//    public static void main(String[] args) {
//        String endpoint = "sts.aliyuncs.com";
//        /*
//         * 子账号的的AK
//         * key: LTAI4Foz9Gm8WKNccUGPjgMz
//         * secret: Ay7YoEDb9JgAU6tIBO3ZRXLU38i6ek
//         */
//        String accessKeyId = "<access-key-id>";
//        String accessKeySecret = "<access-key-secret>";
//        /*
//         * acs:ram::$accountID:role/$roleName
//         * accountID: 云账号ID
//         * roleName: RAM角色名称
//         * acs:ram::1573029915585302:role/osstest
//         */
//        String roleArn = "<role-arn>";
//        // 用户自定义参数,此参数用来区分不同的令牌,支持输入2~32个字符
//        String roleSessionName = "session-name";
//        // 若policy为空,则用户将获得该角色下所有权限,灵活配置
//        String policy = "{\n" +
//                "    \"Version\": \"1\", \n" +
//                "    \"Statement\": [\n" +
//                "        {\n" +
//                "            \"Action\": [\n" +
//                "                \"oss:*\"\n" +
//                "            ], \n" +
//                "            \"Resource\": [\n" +
//                "                \"acs:oss:*:*:*\" \n" +
//                "            ], \n" +
//                "            \"Effect\": \"Allow\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";
//
//        // 过期时间,单位秒,范围900~3600秒
//        Long durationSeconds = 3600L;
//        try {
//            // 添加endpoint（直接使用STS endpoint，前两个参数留空，无需添加region ID）
//            DefaultProfile.addEndpoint("", "", "Sts", endpoint);
//            // 构造default profile（参数留空，无需添加region ID）
//            IClientProfile profile = DefaultProfile.getProfile("", accessKeyId, accessKeySecret);
//            // 用profile构造client
//            DefaultAcsClient client = new DefaultAcsClient(profile);
//            final AssumeRoleRequest request = new AssumeRoleRequest();
//            request.setMethod(MethodType.POST);
//            request.setRoleArn(roleArn);
//            request.setRoleSessionName(roleSessionName);
//            // 若policy为空，则用户将获得该角色下所有权限
//            request.setPolicy(policy);
//            // 设置凭证有效时间
//            request.setDurationSeconds(durationSeconds);
//            // 返回数据
//            final AssumeRoleResponse response = client.getAcsResponse(request);
//
//
//            System.out.println("Expiration: " + response.getCredentials().getExpiration());
//            System.out.println("Access Key Id: " + response.getCredentials().getAccessKeyId());
//            System.out.println(
//                    "Access Key Secret: " + response.getCredentials().getAccessKeySecret());
//            System.out.println("Security Token: " + response.getCredentials().getSecurityToken());
//            System.out.println("RequestId: " + response.getRequestId());
//            // 访问OSS
//            String logEndpoint = "http://oss-cn-hangzhou.aliyuncs.com";
//            OSSClient ossClient = new OSSClient(logEndpoint,
//                    response.getCredentials().getAccessKeyId(),
//                    response.getCredentials().getAccessKeySecret(),
//                    response.getCredentials().getSecurityToken());
//            ossClient.shutdown();
//        } catch (ClientException e) {
//            System.out.println("Failed：");
//            System.out.println("Error code: " + e.getErrCode());
//            System.out.println("Error message: " + e.getErrMsg());
//            System.out.println("RequestId: " + e.getRequestId());
//        }
//    }
//
//    public void loginOssClient() {
//        // Endpoint以杭州为例，其它Region请按实际情况填写。
//        String logEndpoint = "http://oss-cn-hangzhou.aliyuncs.com";
//        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
//        String logAccessKeyId = "<yourAccessKeyId>";
//        String logAccessKeySecret = "<yourAccessKeySecret>";
//        String logSecurityToken = "<yourSecurityToken>";
//
//        // 用户拿到STS临时凭证后，通过其中的安全令牌（SecurityToken）和临时访问密钥（AccessKeyId和AccessKeySecret）生成OSSClient。
//        // 创建OSSClient实例。注意，这里使用到了上一步生成的STS凭证
//        OSSClient ossClient = new OSSClient(logEndpoint, logAccessKeyId, logAccessKeySecret,
//                logSecurityToken);
//
//        // OSS操作。
//
//        // 关闭OSSClient。
//        ossClient.shutdown();
//    }
//}