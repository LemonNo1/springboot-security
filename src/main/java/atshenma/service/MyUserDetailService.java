package atshenma.service;

import atshenma.entity.Permission;
import atshenma.entity.User;
import atshenma.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.findUserByUsername(username);
		List<Permission> listPermission = userMapper.findPermissionByUsername(username);
		if (listPermission != null && listPermission.size() > 0) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for (Permission permission : listPermission) {
				authorities.add(new SimpleGrantedAuthority(permission.getPermTag()));
			}
			user.setAuthorities(authorities);
		}
		return user;
	}
}
