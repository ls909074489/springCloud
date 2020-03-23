package com.king;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * spring cloud eureka客户端工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class EurekaClientUtil {

	private static final Log logger = LogFactory.getLog(EurekaClientUtil.class);
	
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 发送get请求
	 * 
	 * @param url
	 *            请求地址
	 * @return
	 */
	public String get(String url) {
		return restTemplate.getForEntity(url, String.class).getBody();
	}

	/**
	 * 发送post请求
	 * 
	 * @param url
	 *            请求地址
	 * @param values
	 *            值对象
	 * @return
	 */
//	public String post(String url, Map<String, String> values) {
//		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>(values.size());
//		values.forEach((key, value) -> {
//			map.add(key, value);
//		});
//		Locale locale = LocaleContextHolder.getLocale();
//		HttpHeaders headers = new HttpHeaders();
//		logger.info("EurekaClientUtil post ACCEPT_LANGUAGE>>>>"+url+">>"+locale.toLanguageTag());
//		headers.add(HttpHeaders.ACCEPT_LANGUAGE, locale.toLanguageTag());
//		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, headers);
//		return restTemplate.postForObject(url, entity, String.class);
//	}
}
