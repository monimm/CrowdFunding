package com.cf.utils;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091400506892";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCCT47wGqmgSYtneZf1mcnWtgChtoTUsUhYEW3+vGvd1xfOrZwDyQigPasyJ4KhczQIbnV1LTbfAvtM+diKUDoY3BDwwge1KA30grNgR+JL+DYURWMGiGb3bNp43aGzwr+8tnyPZU0+VVmf9nF80kBAXpIStHuxYWJKGXS09Yld2AALsNK2QnbR+2fHsZb9wsHhrzObWq9TFQYejG667IG+f8NTHeiOFlBf3kwRwB8ds6cpMBnX80CwG++6RSWyH9+9AekABvkJOg+Fm9RFsHYYm0ALHmfvhC7EQ7D049b5prNASbJvToCIdr4ELyaR4b1ZMZGvsQt3JMagHSQjzyczAgMBAAECggEAR4sAcghharQWCkhyyo+VhgFElYRMpy1yB5ACMOIn4pLt6jXcuyNLThatgAq7KILEZYCnkh6xynyrldZyMXXcf7uKvXP5oVcNWlnLu6ebsZPjtPtnY7XNujgUNlmQJs5cUHJsLpoyb2+SlkVKh3ozdmO1lPlsE7XgrcgOEC/iLBfXMpY96kfVvvH2P5cQDFIIXN1ehYjBa7XJvtW1mEpCVncFDvjcQFZyr9szpiXHH3G5jS2qGQVj5ggIDCAHFwFJ5f4ScLM2p0rK/xXWyjOiulNhu6p7NTZaGC1h850tFZPf9JB2z6EIK7EA6fn9yWTHk4d7l6FFvMYRJh8on2sQ8QKBgQDfw10ybM+dIUpbsFQ9vQFoJt4+UqLWBIPhWFFzA22k1ExLNiQCXrJ72PgddmKjaKetzOwNxlBrof8KsxJAQCo+XyryqehCtgWkuUhq/QIimyUGa+9QN2Je0yFIZLWr89e33aTReQpIfjm+WQo+/88hSUxHiHFWYHjNiK4v9HB+eQKBgQCVFZDqyG/BVJlNtS80RjY4t6401bCtaXd/mSle9HbBMK98FVXbcocplUApAUhX0XjEe8EyF80aLE0/KHtLra3SGCK0O9q2gaPrV+KVqLbixQBCm4hSMtLvR3Z6DwX0/K4xYH4M3f3eWEeuUTomuCs0t2ouJf2QobRrPbkzBPl4CwKBgQCkdAr80mfLzfm+ZVukfFKaX2abW1R+ApeCeMxzwSNGLxlbdZEFhN+ckhvYW3enLXV/EMq0XPoiAM9W58EUI5Rofr0r15/x16FSLTKCHy0AjhGqJI2f4PSVSIp/kDTNCcuTQHyvz0u1d7+sm/gh0RREHIDJWggiOYjPVhLe/8Hl0QKBgQCJ8vSva1yNhhx83SSauEU/4ibeWMUtESQz+6Nea9LfHI+kv5E8iBMtlR9TUg6AxCF9ng28rm1oxImN4YWFF2Z5uz+Rirjsm7Tz9dSCKyVfXG7LM2PGu6SXKIcmlnQqpw0AP4sjmN5qOUHKuPqYDV5dX0JvBVRF2ns5qFmQLhAw1QKBgFkTt7MM+IYryyNYwAl1SKTwZr0YdCwnLoKx+wU6rfdHLTmlnSTODRVZc8fukSJQEQSs1nZqXbKb5qYzj4z1+b9t1j29EHuE0r0hyMx48nkgm9s02HSBd9sdNVTwAUrfNfrtqGN5PVJ12xVnA4TdB8CcKrEHVSjLTpniv8Xe6Y/w";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwJaZhYCjXvM5KGfseYcnL5EL4SRk3WgamCgKF4NCjJEjNXJ94rLQQAD47DVRzaudQWYwklmw4/Sk18Raa3asojisb81tON0niHzxxz5OQbnZGqxVXZ/BctGhy3+VOoEXzADnVWY5ARuOnit5n+GKHgp/jzx6tjZ9yEhABqkdMxtNNt/T2M7zqcInv2yRTgRASptY7sxhq7Te22YXjEHgJtQA7wedokn3C2+Hhp3zkcejTdXTXDHxCZkplfU/6qEByysonDKH2oaBu3eFvH/Z9+Uh+y6a5DmheFr2UXWoYyecalCSalbaLJXvlKjmXOFnDvbcFfVf5LQTst/+mOYglQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/pay/notify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/pay/return";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

