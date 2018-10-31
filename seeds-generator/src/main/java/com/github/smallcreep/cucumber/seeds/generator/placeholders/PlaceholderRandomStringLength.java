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
 * Placeholder return random string with fixed length.
 * @since 0.2.0
 */
public final class PlaceholderRandomStringLength extends PlaceholderWithParams {

    /**
     * Ctor.
     * @throws Exception if fails
     */
    public PlaceholderRandomStringLength()
        throws Exception {
        this(new PlaceholdersAll());
    }

    /**
     * Ctor.
     * @param regexp Regexp
     * @throws Exception if fails
     */
    public PlaceholderRandomStringLength(
        final String regexp
    ) throws Exception {
        this(
            regexp,
            new PlaceholdersAll()
        );
    }

    /**
     * Ctor.
     * @param placeholder Placeholder
     * @throws Exception if fails
     */
    public PlaceholderRandomStringLength(
        final Placeholder placeholder
    ) throws Exception {
        this(
            "#Random#String",
            placeholder
        );
    }

    /**
     * Ctor.
     * @param regexp Regexp
     * @param placeholder Placeholder
     * @throws Exception if fails
     */
    private PlaceholderRandomStringLength(
        final String regexp,
        final Placeholder placeholder
    ) throws Exception {
        super(
            (final String first, final String second) -> new RandomText(
                Integer.valueOf(
                    second
                )
            ).asString(),
            regexp,
            placeholder
        );
    }
}
