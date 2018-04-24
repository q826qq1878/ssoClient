package com.jjc.ssoClient.service.serviceImpl;

import com.jjc.ssoClient.dao.kor.SsoClientTestTableMapper;
import com.jjc.ssoClient.po.SsoClientTestTable;
import com.jjc.ssoClient.service.KorCoreUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import javax.annotation.Resource;
import java.util.List;

@Service
public class KorCoreUserServiceImpl implements KorCoreUserService {
	
	@Autowired 
	private SsoClientTestTableMapper ssoClientTestTableMapper;

	@Resource(name="localeResolver")
	CookieLocaleResolver resolver;

	@Override
	public List<SsoClientTestTable> demo()  {
		return ssoClientTestTableMapper.selectAll();
	}


}
