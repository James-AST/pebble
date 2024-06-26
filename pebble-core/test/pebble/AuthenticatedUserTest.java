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
package pebble;

import junit.framework.TestCase;

/**
 * Tests for the AuthenticatedUser class.
 *
 * @author    Simon Brown
 */
public class AuthenticatedUserTest extends TestCase {

  private AuthenticatedUser user;

  public void setUp() {
    this.user = new AuthenticatedUser();
  }

  public void testConstruction() {
    assertNull(user.getName());
    assertFalse(user.isPebbleAdmin());
    assertFalse(user.isBlogOwner());
    assertFalse(user.isBlogContributor());
  }

  public void testName() {
    user.setName("simon");
    assertEquals("simon", user.getName());
  }

  public void testPebbleAdmin() {
    user.setPebbleAdmin(true);
    assertTrue(user.isPebbleAdmin());
  }

  public void testBlogOwner() {
    user.setBlogOwner(true);
    assertTrue(user.isBlogOwner());
  }

  public void testBlogContributor() {
    user.setBlogContributor(true);
    assertTrue(user.isBlogContributor());
  }

}
