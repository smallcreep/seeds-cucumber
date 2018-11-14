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
import org.cactoos.io.InputOf;
import org.cactoos.io.Md5DigestOf;
import org.cactoos.text.HexOf;
import org.cactoos.text.TextOf;

/**
 * Placeholder return md5 hash from string.
 * @since 0.2.0
 */
public final class PlaceholderEncryptionMd5 extends PlaceholderWithParams {

    /**
     * Ctor.
     * @throws Exception if fails
     */
    public PlaceholderEncryptionMd5()
        throws Exception {
        this(new PlaceholdersWithoutFunctions());
    }

    /**
     * Ctor.
     * @param placeholder Placeholder
     * @throws Exception if fails
     */
    public PlaceholderEncryptionMd5(
        final Placeholder placeholder
    ) throws Exception {
        this(
            "#Encryption#Md5",
            placeholder
        );
    }

    /**
     * Ctor.
     * @param regexp Regexp
     * @param placeholder Placeholder
     * @throws Exception if fails
     */
    private PlaceholderEncryptionMd5(
        final String regexp,
        final Placeholder placeholder
    ) throws Exception {
        super(
            (final String first, final String second) -> new HexOf(
                new Md5DigestOf(
                    new InputOf(
                        new TextOf(
                            second
                        )
                    )
                )
            ).asString(),
            regexp,
            placeholder
        );
    }
}
