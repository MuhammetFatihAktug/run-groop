# RunGroop Web Application Clone

## Description:
RunGroop web application clone is an example of backend architecture usage in Java. This clone repository was created by Teddy Smith and the development process was shown online in video format on YouTube. This application was built using Spring, Spring-Security, Thymeleaf, Hibernate, and MVC architectures. Necessary package and code updates have been made to comply with today's standards.

### Changes Made in the Project:
The updates made in the security chain of the project are as follows:
```java
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/login",
                    "/register",
                    "/register/save",
                    "/clubs",
                    "/css/**",
                    "/js/**").permitAll()
                    .anyRequest().authenticated())
            .formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/clubs")
                    .loginProcessingUrl("/login")
                    .failureUrl("/login?error=true")
                    .permitAll())
            .logout(logout -> logout
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .permitAll());
    return http.build();
}
```
## Usage:
1. Clone or Download the Project: Follow these steps to clone or download the project:
```
   git clone https://github.com/MuhammetFatihAktug/run-groop.git
```
3. Resolve Dependencies: To run the project, resolve the necessary dependencies by running:
```
   mvn install
```
5. Run the Application:
```
   mvn spring-boot:run
```
7. Access URL: You can access the application at http://localhost:8080.

Screenshots:
Screenshot 0: ![Link](https://github.com/MuhammetFatihAktug/run-groop/blob/master/src/main/resources/static/assets/img1.PNG)

Screenshot 1: ![Link](https://github.com/MuhammetFatihAktug/run-groop/blob/master/src/main/resources/static/assets/img2.PNG)

Screenshot 2: ![Link](https://github.com/MuhammetFatihAktug/run-groop/blob/master/src/main/resources/static/assets/img3.PNG)

Screenshot 3: ![Link](https://github.com/MuhammetFatihAktug/run-groop/blob/master/src/main/resources/static/assets/img4.PNG)

Screenshot 4: ![Link](https://github.com/MuhammetFatihAktug/run-groop/blob/master/src/main/resources/static/assets/img5.PNG)
