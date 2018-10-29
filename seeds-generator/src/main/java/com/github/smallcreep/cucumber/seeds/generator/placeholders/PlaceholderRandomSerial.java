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

import java.util.Random;

/**
 * Placeholder return random serial 4 bytes from 1 to 2147483647.
 * @since 0.2.0
 */
public final class PlaceholderRandomSerial extends PlaceholderEnvelope {

    /**
     * Random.
     */
    private static final Random RANDOM = new Random();

    /**
     * Ctor.
     */
    public PlaceholderRandomSerial() {
        this("#Random#Serial");
    }

    /**
     * Ctor.
     * @param regexp Regexp
     * @checkstyle MagicNumberCheck (10 lines)
     */
    public PlaceholderRandomSerial(final String regexp) {
        super(
            new PlaceholderRegexp(
                input -> Integer.toString(
                    PlaceholderRandomSerial.RANDOM.nextInt(2147483647) + 1
                ),
                regexp
            )
        );
    }
}
