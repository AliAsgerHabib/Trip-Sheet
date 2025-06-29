package org.ashara.udaipur.transport.filters;

import jakarta.servlet.*;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class MDCFilter implements Filter{

    private static final String MDC_TOKEN = "MDC_TOKEN";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            String mdcToken = UUID.randomUUID().toString()
                    .replace("-","").substring(0,12).toUpperCase();
            MDC.put(MDC_TOKEN, mdcToken);
            filterChain.doFilter(servletRequest, servletResponse);
        }
        finally {
            MDC.clear();
        }
    }
}
