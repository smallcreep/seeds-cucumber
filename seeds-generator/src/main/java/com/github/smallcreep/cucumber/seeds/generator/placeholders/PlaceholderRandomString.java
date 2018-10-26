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

package com.github.smallcreep.cucumber.seeds.generator.placeholders;

import com.github.smallcreep.cucumber.seeds.generator.Placeholder;
import org.cactoos.text.RandomText;

/**
 * Placeholder return random string.
 * @since 0.2.0
 */
public final class PlaceholderRandomString extends PlaceholderEnvelope {

    /**
     * Ctor.
     */
    public PlaceholderRandomString() {
        this("#Random#String");
    }

    /**
     * Ctor.
     * @param regexp Regexp
     */
    public PlaceholderRandomString(final String regexp) {
        this(
            new PlaceholderRegexp(
                input -> new RandomText().asString(),
                regexp
            )
        );
    }

    /**
     * Ctor.
     * @param placeholder Placeholder
     */
    private PlaceholderRandomString(final Placeholder placeholder) {
        super(placeholder);
    }
}
