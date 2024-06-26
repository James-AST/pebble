﻿/*
 * Copyright (c) 2003-2004, Simon Brown
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in
 *     the documentation and/or other materials provided with the
 *     distribution.
 *
 *   - Neither the name of Pebble nor the names of its contributors may
 *     be used to endorse or promote products derived from this software
 *     without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package pebble.mock;

import java.io.*;
import java.security.Principal;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.*;

/**
 * A mock HttpServletRequest implementation.
 *
 * @author    Simon Brown
 */
public class MockHttpServletRequest implements HttpServletRequest {

  private Properties headers = new Properties();
  private Properties parameters = new Properties();
  private HashMap attributes = new HashMap();

  private HttpSession session = new MockHttpSession();

  private String contextPath;
  private String requestUri = "";
  private StringBuffer requestUrl = new StringBuffer();
  private RequestDispatcher requestDispatcher;

  private MockPrincipal userPrincipal;

  public String getAuthType() {
    return null;
  }

  public Cookie[] getCookies() {
    return new Cookie[0];
  }

  public long getDateHeader(String name) {
    String value = getHeader(name);
    if (value != null) {
      return Long.parseLong(getHeader(name));
    } else {
      return -1;
    }
  }

  public String getHeader(String s) {
    return headers.getProperty(s);
  }

  public Enumeration getHeaders(String s) {
    return null;
  }

  public Enumeration getHeaderNames() {
    return headers.keys();
  }

  public void setHeader(String name, String value) {
    headers.put(name, value);
  }

  public void setDateHeader(String name, long value) {
    setHeader(name, "" + value);
  }

  public int getIntHeader(String s) {
    return 0;
  }

  public String getMethod() {
    return null;
  }

  public String getPathInfo() {
    return null;
  }

  public String getPathTranslated() {
    return null;
  }

  public String getContextPath() {
    return this.contextPath;
  }

  public void setContextPath(String contextPath) {
    this.contextPath = contextPath;
  }

  public String getQueryString() {
    return null;
  }

  public String getRemoteUser() {
    return null;
  }

  public boolean isUserInRole(String s) {
    if (this.userPrincipal != null) {
      return userPrincipal.isUserInRole(s);
    } else {
      return false;
    }
  }

  public Principal getUserPrincipal() {
    return this.userPrincipal;
  }

  public void setUserPrincipal(Principal p) {
    this.userPrincipal = (MockPrincipal)p;
  }

  public String getRequestedSessionId() {
    return null;
  }

  public String getRequestURI() {
    return this.requestUri;
  }

  public void setRequestUri(String requestUri) {
    this.requestUri = requestUri;
  }

  public StringBuffer getRequestURL() {
    return this.requestUrl;
  }

  public void setRequestUrl(String requestUrl) {
    this.requestUrl = new StringBuffer(requestUrl);
  }

  public String getServletPath() {
    return null;
  }

  public HttpSession getSession(boolean b) {
    return session;
  }

  public HttpSession getSession() {
    return session;
  }

  public boolean isRequestedSessionIdValid() {
    return false;
  }

  public boolean isRequestedSessionIdFromCookie() {
    return false;
  }

  public boolean isRequestedSessionIdFromURL() {
    return false;
  }

  public boolean isRequestedSessionIdFromUrl() {
    return false;
  }

  public Object getAttribute(String s) {
    return attributes.get(s);
  }

  public Enumeration getAttributeNames() {
    return null;
  }

  public String getCharacterEncoding() {
    return null;
  }

  public void setCharacterEncoding(String s) throws UnsupportedEncodingException {
  }

  public int getContentLength() {
    return 0;
  }

  public String getContentType() {
    return null;
  }

  public ServletInputStream getInputStream() throws IOException {
    return null;
  }

  public void setParameter(String name, String value) {
    parameters.setProperty(name, value);
  }

  public String getParameter(String s) {
    return parameters.getProperty(s);
  }

  public Enumeration getParameterNames() {
    return parameters.keys();
  }

  public String[] getParameterValues(String s) {
    return new String[0];
  }

  public Map getParameterMap() {
    return null;
  }

  public String getProtocol() {
    return null;
  }

  public String getScheme() {
    return null;
  }

  public String getServerName() {
    return null;
  }

  public int getServerPort() {
    return 0;
  }

  public BufferedReader getReader() throws IOException {
    return null;
  }

  public String getRemoteAddr() {
    return null;
  }

  public String getRemoteHost() {
    return null;
  }

  public void setAttribute(String s, Object o) {
    attributes.put(s, o);
  }

  public void removeAttribute(String s) {
    attributes.remove(s);
  }

  public Locale getLocale() {
    return null;
  }

  public Enumeration getLocales() {
    return null;
  }

  public boolean isSecure() {
    return false;
  }

  public RequestDispatcher getRequestDispatcher(String s) {
    this.requestDispatcher = new MockRequestDispatcher(s);

    return this.requestDispatcher;
  }

  public RequestDispatcher getRequestDispatcher() {
    return this.requestDispatcher;
  }

  public String getRealPath(String s) {
    return null;
  }

}
