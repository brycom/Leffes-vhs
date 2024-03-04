package LeffesVHS;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/api/*" })
public class ApiFilter implements Filter {

    String apiKey = "Leffes_api_nyckel";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String cliantKey = httpRequest.getHeader("api_key");
        if (cliantKey.equals(apiKey)) {
            chain.doFilter(request, response);

        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }
}
