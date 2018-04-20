package util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.mybbs.po.User;

/**
 * 发送E-mail验证码 返回一个验证码
 * 
 * @author HP5
 *
 */
public class EmailUtil {
	public static String sendEmail(String mailAddress) {
		// 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIulon7QIT4EGk",
				"KtzINaHjOCONW9mSypm5Yh8A9ro7E4");
		// 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
		// try {
		// DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com",
		// "ap-southeast-1", "Dm", "dm.ap-southeast-1.aliyuncs.com");
		// } catch (ClientException e) {
		// e.printStackTrace();
		// }
		IAcsClient client = new DefaultAcsClient(profile);
		int radomInt = (int) ((Math.random() * 9 + 1) * 100000);
		String num = String.valueOf(radomInt);
		SingleSendMailRequest request = new SingleSendMailRequest();
		try {
			// request.setVersion("2017-06-22");//
			// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
			request.setAccountName("xiaozu@innerstudent.group");
			request.setFromAlias("雷园");
			request.setAddressType(1);
			request.setTagName("AboutUserName");
			request.setReplyToAddress(true);
			request.setToAddress(mailAddress);
			request.setSubject("账号验证码");
			request.setHtmlBody("你的验证码为:" + num);
			client.getAcsResponse(request);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
		return num;
	}

	public static void sendUserInfo(User user) {

		// 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIulon7QIT4EGk",
				"KtzINaHjOCONW9mSypm5Yh8A9ro7E4");
		// 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
		// try {
		// DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com",
		// "ap-southeast-1", "Dm", "dm.ap-southeast-1.aliyuncs.com");
		// } catch (ClientException e) {
		// e.printStackTrace();
		// }
		IAcsClient client = new DefaultAcsClient(profile);
		SingleSendMailRequest request = new SingleSendMailRequest();
		try {
			// request.setVersion("2017-06-22");//
			// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
			request.setAccountName("xiaozu@innerstudent.group");
			request.setFromAlias("雷园");
			request.setAddressType(1);
			request.setTagName("AboutUserName");
			request.setReplyToAddress(true);
			request.setToAddress(user.getEmail());
			request.setSubject("账号信息");
			request.setHtmlBody("你的账号为:" + user.getEmail() + "。你的密码为:" + user.getPassword());
			client.getAcsResponse(request);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}
}
