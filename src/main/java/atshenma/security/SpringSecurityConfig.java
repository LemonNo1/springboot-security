package atshenma.security;

import atshenma.entity.Permission;
import atshenma.mapper.PermissionMapper;
import atshenma.service.MyUserDetailService;
import atshenma.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Autowired
    MyUserDetailService myUserDetailService;
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String) rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return MD5Util.encode((String) rawPassword).equals(encodedPassword);
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.authorizeRequests()
                .antMatchers("/login", "/webjars/**").permitAll()
                .antMatchers("/updateOrder").hasAuthority("ROLE_ADD_PRODUCT")
                .antMatchers("/addOrder").hasAuthority("ROLE_DELETE_PRODUCT")
                .antMatchers("/deleteOrder").hasAuthority("ROLE_LIST_PRODUCT")
                .antMatchers("/showOrder").hasAuthority("ROLE_UPDATE_PRODUCT")
                .antMatchers("/**").fullyAuthenticated()
                .and().formLogin().loginProcessingUrl("/securityLogin").loginPage("/login")
                .successHandler(myAuthenticationSuccessHandler)
                .and().logout().logoutSuccessUrl("/login")
                .and().csrf().disable();*/
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
        registry.antMatchers("/login", "/webjars/**").permitAll();
        List<Permission> allPermission = permissionMapper.findAllPermission();
        for (Permission permission : allPermission) {
            registry.antMatchers(permission.getUrl()).hasAuthority(permission.getPermTag());
        }
        registry.antMatchers("/**").fullyAuthenticated().and()
                .formLogin().loginProcessingUrl("/securityLogin").loginPage("/login")
                .successHandler(myAuthenticationSuccessHandler)
                .and().logout().logoutSuccessUrl("/login")
                .and().csrf().disable();
        ;
    }
}
