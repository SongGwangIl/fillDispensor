package timepill.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class UserVO implements UserDetails {

	// users테이블
	private String userId; // 유저아이디
	private String nickname; // 유저이름
	private String role; // 유저권한
	private String password; // 유저비밀번호
	private String email; // 유저이메일
	private String userStatus; // 유저사용상태 가입시 Y, 탈퇴시 N
	
	private String tokenUseAt; 		// 카카오 토큰 사용 여부
	private String refreshToken; 	// 카카오 리프레시 토큰
	private String oldRefreshToken; // 기존 리프레시 토큰

	// 스프링 시큐리티 메소드
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + this.role));
		return authorities;
	}
	@Override
	public String getUsername() {
		return this.userId;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return this.userStatus.equals("Y");
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return this.userStatus.equals("Y");
	}

}
