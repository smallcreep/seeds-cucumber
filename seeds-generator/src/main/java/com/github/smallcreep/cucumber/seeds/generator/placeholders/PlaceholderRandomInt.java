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
import java.util.Random;

/**
 * Placeholder return random integer.
 * @since 0.2.0
 */
public final class PlaceholderRandomInt implements Placeholder {

    /**
     * Random.
     */
    private static final Random RANDOM = new Random();

    /**
     * Placeholder.
     */
    private final Placeholder placeholder;

    /**
     * Ctor.
     */
    public PlaceholderRandomInt() {
        this("#Random#Integer");
    }

    /**
     * Ctor.
     * @param regexp Regexp
     */
    public PlaceholderRandomInt(final String regexp) {
        this(
            new PlaceholderRegexp(
                input -> Integer.toString(
                    PlaceholderRandomInt.RANDOM.nextInt()
                ),
                regexp
            )
        );
    }

    /**
     * Ctor.
     * @param placeholder Placeholder
     */
    private PlaceholderRandomInt(final Placeholder placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public String apply(final String input) throws Exception {
        return this.placeholder.apply(input);
    }
}
