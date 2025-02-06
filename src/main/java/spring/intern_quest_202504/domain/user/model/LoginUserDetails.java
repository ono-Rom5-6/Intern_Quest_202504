//ログインユーザーを取得する
package spring.intern_quest_202504.domain.user.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUserDetails implements UserDetails {
	
	private final User loginUser;
	private final Collection<? extends GrantedAuthority> authorities;
	
	public LoginUserDetails(User loginUser) {
	this.loginUser = loginUser;
	
	GrantedAuthority authority = new SimpleGrantedAuthority(loginUser.getAuthority());
	
	List<GrantedAuthority> authorities = new ArrayList<>();
	authorities.add(authority);
	this.authorities = authorities;
	}
	
	public User getLoginUser() { return loginUser; }
	
	
	@Override
	// ハッシュ化済みのパスワードを返す
	public String getPassword() { return loginUser.getPass(); }
	@Override
	// ログインで利用するユーザー名を返す
	public String getUsername() { return loginUser.getUser(); }	
	@Override 
	// ロールのコレクションを返す
	public Collection<? extends GrantedAuthority> getAuthorities() { return authorities; }
	@Override // ユーザーが期限切れでなければtrueを返す
	public boolean isAccountNonExpired() { return true; }
	@Override // ユーザーがロックされていなければtrueを返す
	public boolean isAccountNonLocked() { return true; }
	@Override // ユーザーのパスワードが期限切れでなければtrueを返す
	public boolean isCredentialsNonExpired() { return true; }
	@Override // ユーザーが有効であればtrueを返す
	public boolean isEnabled() { return true; } 

}

