package shopsport.nhom18.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomeFailureHandler extends SimpleUrlAuthenticationFailureHandler{
	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
		
		String errorMessage = "Tài khoản hoặc mật khẩu bị sai";
		if (exception instanceof UsernameNotFoundException) {
			errorMessage = "Tài khoản chưa được đăng kí";
        }
		
		if (exception instanceof LockedException) {
			errorMessage = "Tài khoản bị khoá";
        }
		
        request.setAttribute("errorMessage", errorMessage);
        System.out.println(exception.getMessage());
        System.out.println(errorMessage);
        super.setDefaultFailureUrl("/login?incorrectAccount=true");
        super.onAuthenticationFailure(request, response, exception);
    }
}
