package com.jftshop.permission.shiro.credentials;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;


public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

	private static final Logger LOG = LoggerFactory.getLogger(RetryLimitHashedCredentialsMatcher.class);

/*	@Autowired
	private PmsOperatorService pmsOperatorService;*/

	private Cache<String, AtomicInteger> passwordRetryCache;

	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	@Override
	/**
	 * 做认证匹配
	 */
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

		String username = (String) token.getPrincipal();
        //UsernamePasswordToken token2 = new UsernamePasswordToken("admin", "123456");

        LOG.debug("username={}",username);

		// retry count + 1
		AtomicInteger retryCount = passwordRetryCache.get(username);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		if (retryCount.incrementAndGet() > 5) {
			// if retry count > 5 throw
			throw new ExcessiveAttemptsException();
		}

		boolean matches = super.doCredentialsMatch(token, info);

		LOG.debug("matches={}",matches);

		if (matches) {
			// clear retry count
			passwordRetryCache.remove(username);

			// 根据登录名查询操作员
			//PmsOperator operator = pmsOperatorService.findOperatorByLoginName(username);
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			session.setAttribute("PmsOperator", "admin");
			LOG.debug("operator={}","admin");
		}

		return matches;
	}
}
