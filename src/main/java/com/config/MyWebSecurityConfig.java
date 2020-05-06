//package com.config;
//
//import com.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableMBeanExport;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import sun.plugin2.applet.context.NoopExecutionContext;
//import sun.security.util.ManifestDigester;
//
//@Configuration
//public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    UserService userService;
//
////    @Bean
////    PasswordEncoder passwordEncoder(){
////        return NoOpPasswordEncoder.getInstance();
////    }
//
//
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//    protected  void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("sang").password("123").roles("USER")
//                .and()
//                .withUser("root").password("123").roles("DBA","ADMIN")
//                .and()
//                .withUser("admin").password("123").roles("ADMIN","USER");
////        auth.userDetailsService(userService);
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/user/**").access("hasAnyRole('USER','ADMIN')")
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/db/**").access("hasRole('ADMIN') AND hasRole('DBA')")
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/login").permitAll().and().csrf().disable();
//
//    }
//
//
//
//
//
//
//
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .withUser("sang").password("123").roles("USER")
////                .and()
////                .withUser("ADMIN").password("123").roles("ADMIN","USER")
////                .and()
////                .withUser("root").password("123").roles("ADMIN","DBA");
//////                auth.userDetailsService(userService);
////    }
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .antMatchers("/admin/**").hasRole("ADMIN")
////                .antMatchers("/user/**").access("hasAnyRole('ADMIN','USER')")
////                .antMatchers("/db/**").access("hasRole('ADMIN') AND hasRole('DBA')")
////                .and()
////                .formLogin().loginProcessingUrl("/login").permitAll().and().csrf().disable();
//////                .and()
//////                .formLogin()
//////                .loginProcessingUrl("/login").permitAll()
//////                .and()
//////                .csrf().disable();
////    }
//
//}
