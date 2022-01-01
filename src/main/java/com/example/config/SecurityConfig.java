package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
    public PasswordEncoder passwordEncoder() {

    	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	//これはハッシュ化済みの値をDBに登録する確認用に出力させるコード//
	    String password = "1234";
        String digest = bCryptPasswordEncoder.encode(password);
        System.out.println("ハッシュ値 = " + digest);
	///////////////////////////////////////////////////////////////

        return new BCryptPasswordEncoder();
    }

	
	/** セキュリティの対象外を設定 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		//セキュリティを適用しない
		web
			.ignoring()
				.antMatchers("/webjars/**")
				.antMatchers("/css/**")
				.antMatchers("/js/**");
	}
	
	/** セキュリティの各種設定 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//ログイン不要ページの設定
	/**http
			.authorizeRequests()
				.antMatchers("/login").permitAll() //直リンクOK
				.antMatchers("/user/signup").permitAll() //直リンクOK
				.anyRequest().authenticated(); //それ以外は直リンクNG
			*/
		
		http.formLogin()
        //ログイン画面は常にアクセス可能とする
        .loginPage("/login").permitAll()
        //ログインに成功したら検索画面に遷移する
        .defaultSuccessUrl("/user/signup", true)
        .and()
        .authorizeRequests().antMatchers("/user/signup").permitAll()
        //ログイン画面のcssファイルとしても共通のdemo.cssを利用するため、
        //src/main/resources/static/cssフォルダ下は常にアクセス可能とする
        .and()
        .authorizeRequests().antMatchers("/css/**").permitAll()
        .and()    //かつ
        //それ以外の画面は全て認証を有効にする
        .authorizeRequests().anyRequest().authenticated()
        .and()    //かつ
        //ログアウト時はログイン画面に遷移する
        .logout().logoutSuccessUrl("/login").permitAll();
	
		
	}

}
