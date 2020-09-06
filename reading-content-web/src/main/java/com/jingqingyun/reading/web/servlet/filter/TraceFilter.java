package com.jingqingyun.reading.web.servlet.filter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import com.jingqingyun.common.utils.UuidUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * ResponseFilter
 *
 * @author jingqingyun
 * @date 2020-09-06
 */
@Component
@WebFilter(urlPatterns = "/*")
public class TraceFilter extends HttpFilter {

    private static final long serialVersionUID = -2885183143290528396L;

    private static final String TRACE_HEADER = "x-trace";

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String xTrace = Optional.ofNullable(request.getHeader(TRACE_HEADER))
                .orElseGet(UuidUtils::nextId);
        MDC.put(TRACE_HEADER, xTrace);
        request.setAttribute(TRACE_HEADER, xTrace);
        response.setHeader(TRACE_HEADER, xTrace);
        super.doFilter(request, response, chain);
    }

}
