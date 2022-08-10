package com.zero.serverApi.utils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class WafRequestWrapper extends HttpServletRequestWrapper {

    private boolean filterXSS = true;
    private boolean filterSQL = true;

    public WafRequestWrapper(HttpServletRequest request, boolean filterXSS, boolean filterSQL) {
        super(request);
        this.filterXSS = filterXSS;
        this.filterSQL = filterSQL;
    }

    public WafRequestWrapper(HttpServletRequest request) {
        this(request, true, true);
    }


}
