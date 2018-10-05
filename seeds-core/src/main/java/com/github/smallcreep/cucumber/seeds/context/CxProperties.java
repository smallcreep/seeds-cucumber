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
import java.util.Properties;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;

/**
 * Context from properties.
 * @since 0.1.1
 */
public final class CxProperties implements Context {

    /**
     * Origin context.
     */
    private final Context origin;

    /**
     * Ctor.
     * @param properties Properties
     */
    CxProperties(final Properties properties) {
        this(
            new CxSimple(
                new MapOf<String, Object>(
                    (name) -> new MapEntry<>(
                        name,
                        properties.getProperty(name)
                    ),
                    properties.stringPropertyNames()
                )
            )
        );
    }

    /**
     * Ctor.
     * @param origin Origin context
     */
    private CxProperties(final Context origin) {
        this.origin = origin;
    }

    @Override
    public Object value(final String key) {
        return this.origin.value(key);
    }

    @Override
    public void add(final String key, final Object value) {
        throw new UnsupportedOperationException(
            "Can not add value to properties context"
        );
    }

    @Override
    public boolean contains(final String key) {
        return this.origin.contains(key);
    }
}
