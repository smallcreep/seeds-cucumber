/*
 * MIT License
 *
 * Copyright (c) 2018 Ilia Rogozhin (@smallcreep) <ilia.rogozhin@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.smallcreep.cucumber.seeds.context;

import com.github.smallcreep.cucumber.seeds.Context;

/**
 * Joined context.
 * @since 0.1.1
 * @todo #28:15m/DEV Need implement this class.
 *  This class must search properties in all context.
 *  And have storage for new values.
 */
public final class CxJoined implements Context {

    /**
     * Ctor.
     * @param ctx Context
     */
    @SuppressWarnings("PMD.UnusedFormalParameter")
    public CxJoined(final Context... ctx) {
        // Nothing
    }

    @Override
    public Object value(final String key) {
        return null;
    }

    @Override
    public void add(final String key, final Object value) {
        // Nothing
    }

    @Override
    public boolean contains(final String key) {
        return false;
    }
}
