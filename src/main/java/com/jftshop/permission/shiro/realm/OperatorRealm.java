package com.jftshop.permission.shiro.realm;

/*import com.jftpay.common.constant.PublicConstant;
import com.jftpay.permission.entity.PmsOperator;
import com.jftpay.permission.service.PmsOperatorService;*/


import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;

public class OperatorRealm extends AuthorizingRealm {

	private static final Logger LOG = LoggerFactory.getLogger(OperatorRealm.class);

/*	@Autowired
	private PmsOperatorService pmsOperatorService;*/
	/*@Autowired
	private PmsOperatorRoleService pmsOperatorRoleService;
	@Autowired
	private PmsRolePermissionService pmsRolePermissionService;*/

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		String loginName = (String)principals.getPrimaryPrincipal();

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();

		String operator = (String) session.getAttribute("PmsOperator");

/*		LOG.debug("operator1={}",operator.toString());
		if (operator == null) {
			operator = pmsOperatorService.findOperatorByLoginName(loginName);
			session.setAttribute("PmsOperator", operator);

			LOG.debug("operator2={}",operator);
		}
		// 根据登录名查询操作员
		Long operatorId = operator.getId();

		Set<String> roles = (Set<String>) session.getAttribute("ROLES");
		if (roles == null || roles.isEmpty()) {
			roles = pmsOperatorService.getRoleIdsByOperatorId(operatorId);
			session.setAttribute("ROLES", roles);
		}
		// 查询角色信息
		authorizationInfo.setRoles(roles);

		Set<String> permisstions = (Set<String>) session.getAttribute("PERMISSIONS");
		if (permisstions == null || permisstions.isEmpty()) {
			permisstions = pmsOperatorService.getPermissionIdsByOperatorId(operatorId);
			session.setAttribute("PERMISSIONS", permisstions);
		}*/

		HashSet permisstions = new HashSet();
		permisstions.add("admin");
		// 根据用户名查询权限
		authorizationInfo.setStringPermissions(permisstions);
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken token) throws AuthenticationException {

		String loginName = (String) token.getPrincipal();

		UsernamePasswordToken token1 = (UsernamePasswordToken)token;
		char[] kkk = token1.getPassword();

		LOG.debug("loginName={}",loginName);
		LOG.debug("Password={}",kkk);

		if (StringUtils.isEmpty(loginName.trim())) {
			throw new UnknownAccountException();// 没找到帐号
		}

/*		// 根据登录名查询操作员
		PmsOperator operator = pmsOperatorService.findOperatorByLoginName(loginName);

		LOG.debug("operator={}",operator);
		LOG.debug("getLogin_name={}",operator.getLogin_name());
		LOG.debug("getLogin_pwd={}",operator.getLogin_pwd());
		LOG.debug("getSalt={}",operator.getCredentialsSalt());

		if (operator == null) {
			throw new UnknownAccountException();// 没找到帐号
		}*/

/*		if (PublicConstant.UNACTIVE.equals(operator.getStatus())) {
			throw new LockedAccountException(); // 帐号锁定
		}*/

		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
/*		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(operator.getLogin_name(), // 登录名
				operator.getLogin_pwd(), // 密码
				ByteSource.Util.bytes(operator.getCredentialsSalt()), // salt=username+salt
				getName() // realm name
		);*/

		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("admin", // 登录名
				"0ec82a496db653ee3585bbc5ce61d604", // 密码
				ByteSource.Util.bytes("admin100319a431619710704fb054beff402b"), // salt=username+salt
				getName() // realm name
		);

		return authenticationInfo;
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}
