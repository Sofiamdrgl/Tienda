package com.tienda;

public class SecurityConfig {


    import org.springframework.security.authentication.AuthenticationManager ;
    import org.springframework.security.authentication.AuthenticationProvider ;
    import org.springframework.security.authentication.dao.DaoAuthenticationProvider ;
    import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder ;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity ;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity ;
    import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter ;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder ;
    import org.springframework.security.web.authentication.AuthenticationSuccessHandler ;

    import com.tienda.tienda.service.UserService ;

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserService userDetailService;

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public UserService getUserService() {
            return new UserService();
        }

        @Bean
        DaoAuthenticationProvider daoAuthenticationProvider() {
            DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
            daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
            return daoAuthenticationProvider;
        }

        @Bean
        public AuthenticationSuccessHandler appAuthenticationSuccessHandler() {
            return new AppAuthenticationSuccessHandler();

        }

        public SecurityConfig(UserService userPincipalDetailService) {
            this.userDetailService = userPincipalDetailService;
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) {
            auth.authenticationProvider(authenticationProvider());
        }
        //el siguiente metodo funciona para hacer la autenticion del usuario

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/persona", "/login", "/personasN")
                    .hasRole("ADMIN")
                    .antMatchers("/persona", "/", "/login")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login").permitALL().defaultSuccessUrl("/persona", true);

        }
    }
