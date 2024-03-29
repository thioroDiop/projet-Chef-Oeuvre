package com.example.wedding.security;

import com.example.wedding.models.Roles;
import com.example.wedding.security.jwt.JWTConfigurer;
import com.example.wedding.security.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;

    public SecurityConfigurations(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }


    /**
     * je mets à disposition de mon API un objet BCryptPasswordEncoder qui me permettra de cripter le mot de passe
     *
     * @return
     */
    @Bean //rendre disponible l'objet renvoyé dans l'API
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * permeT de definir la hiérarchie des roles.
     * Ici, le role Admin a au moins les droits du rôle Guest
     *
     * @return
     */
    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        //si on est admin on peut accerder au meme fonctionalité  que guest
        String hierarchy = "ROLE_ADMIN > ROLE_GUEST";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }

    /**
     * configure du Cross Origin pour que le front puisse faire des appels à l'API via des
     * lien url
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**").allowedOrigins("http://localhost:4200").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
                registry.addMapping("/admin/**").allowedOrigins("http://localhost:4200").allowedMethods("GET", "OPTIONS");
                registry.addMapping("/authentication/**").allowedOrigins("http://localhost:4200").allowedMethods("POST", "OPTIONS");
            }
        };
    }

    /**
     * Ici c'est open bar pour les requêtes http avec methode OPTIONS
     * et aussi pour acceder à h2-console , et swagger
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers("/*.{js,html}")
                .antMatchers("/h2-console/**")
                .antMatchers("/swagger-ui/index.html");
    }


    /**
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//on desactive la protection csrf acr c'est déja pris en compte
                .cors()
                .and()
                .headers()
                .contentSecurityPolicy("default-src 'self'; frame-src 'self' data:; script-src 'self' 'unsafe-inline' 'unsafe-eval' https://storage.googleapis.com; style-src 'self' 'unsafe-inline'; img-src 'self' data:; font-src 'self' data:")
                .and()
                .referrerPolicy(ReferrerPolicyHeaderWriter.ReferrerPolicy.STRICT_ORIGIN_WHEN_CROSS_ORIGIN)
                .and()
                .frameOptions()
                .deny()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //propre a mon API
                .antMatchers("/authentication").permitAll() //tout le monde a acceder à: /authentication
                //.antMatchers(HttpMethod.GET, "/api/**").authenticated()// tu peux faire des get si tu es authentifier
               // .antMatchers(HttpMethod.POST, "/api/**").hasAuthority(Roles.ROLE_GUEST.getAuthority())// tu peux faire des post si tu es createur
                .antMatchers(HttpMethod.GET, "/api/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/**").hasAuthority(Roles.ROLE_ADMIN.getAuthority())
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAuthority(Roles.ROLE_ADMIN.getAuthority())
                .antMatchers("/admin/**").hasAuthority(Roles.ROLE_ADMIN.getAuthority())
                .and()
                .apply(securityConfigurerAdapter());//j'applique la configuration JWT
    }

    private JWTConfigurer securityConfigurerAdapter() {

        return new JWTConfigurer(tokenProvider);
    }

}
