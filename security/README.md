# Spring Security

#### 접근 권한 설정
Spring Security 에서는 기본적으로 모든 페이지를 차단한다.
설정을 해지하고 싶다면 WebSecurityConfigurerAdapter 를 상속받는 
config 에서 configure(HttpSecurity http) 를 재정의 해주면 된다.

Controller API 에 @PreAuthorize("hasAnyAuthority('ROLE_USER')") 로
접근 권한을 설정하고 Config 에서 @EnableGlobalMethodSecurity(prePostEnabled = true)
설정을 추가 하면 된다.

Url 의 접근 권한을 허용해도 css 와 같은 static resources 의 접근은 제한된다.
configure(WebSecurity web) 을 상속받아 ignore 시켜줘야 한다.

#### USER 생성
application.yml 에는 한명의 유저만 생성이 가능하다. 
Security 설정을 위한 WebSecurityConfigurerAdapter 를 상속받는 config 에서
configure(AuthenticationManagerBuilder auth) 상속받아 유저를 생성할 수 있다. 
config 에서 유저 생성시 유저의 비밀번호는 인코딩하여 사용해야 한다.
config 에서 유저 생성시 yml 의 유저는 더이상 동작하지 않는다.

#### 관리자 권한
권리자는 일반적으로 유저의 접근 권한을 포함해야 한다.
RoleHierarchy bean 을 만들어 관리자 > 유저 설정.

#### SPA 페이지 (react, angular, vue ...)
기본적으로 로그인 페이지를 사용할 수 엇는 상황에서 사용.  
Config 의 configure(HttpSecurity http) 에서 http.httpBasic() 으로 enable 시켜줘야함
최초 로그인시에만 인증을 처리, 이후에는 session 에 의존. 또 RememberMe 를 설정한 경우,
remember-me 쿠키가 브라우저에 저장되기 때문에 세션이 만료된 이후라도브라우저 기반의 앱에서는 장시간 서비스를 로그인 페이지를 거치지 않고 이용.
