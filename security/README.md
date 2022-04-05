# Spring Security

#### 접근 권한 설정
Spring Security 에서는 기본적으로 모든 페이지를 차단한다.
설정을 해지하고 싶다면 WebSecurityConfigurerAdapter 를 상속받는 
config 에서 configure(HttpSecurity http) 를 재정의 해주면 된다.

Controller API 에 @PreAuthorize("hasAnyAuthority('ROLE_USER')") 로
접근 권한을 설정하고 Config 에서 @EnableGlobalMethodSecurity(prePostEnabled = true)
설정을 추가 하면 된다.

#### USER 생성
application.yml 에는 한명의 유저만 생성이 가능하다. 
Security 설정을 위한 WebSecurityConfigurerAdapter 를 상속받는 config 에서
configure(AuthenticationManagerBuilder auth) 상속받아 유저를 생성할 수 있다. 
config 에서 유저 생성시 유저의 비밀번호는 인코딩하여 사용해야 한다.
config 에서 유저 생성시 yml 의 유저는 더이상 동작하지 않는다.
