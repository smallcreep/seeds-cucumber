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

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Test Case for {@link PlaceholderEncryptionMd5}.
 * @since 0.2.0
 */
public final class PlaceholderEncryptionMd5Test {

    /**
     * PlaceholderEncryptionMd5 can generate md5 hash from string.
     * @throws Exception if fails
     * @checkstyle MethodNameCheck (5 lines)
     */
    @Test
    public void generateMd5Hash() throws Exception {
        MatcherAssert.assertThat(
            new PlaceholderEncryptionMd5(
                new PlaceholderRegexp(
                    new PlaceholderSimple("123"),
                    "#Random#String"
                )
            ).apply(
                "#Encryption#Md5(#Random#String)"
            ),
            CoreMatchers.equalTo("202cb962ac59075b964b07152d234b70")
        );
    }

    /**
     * PlaceholderEncryptionMd5 can generate md5 hash from sent string.
     * @throws Exception if fails
     * @checkstyle MethodNameCheck (5 lines)
     */
    @Test
    public void generateMd5HashNotRandomString() throws Exception {
        MatcherAssert.assertThat(
            new PlaceholderEncryptionMd5().apply(
                "#Encryption#Md5(234)"
            ),
            CoreMatchers.equalTo("289dff07669d7a23de0ef88d2f7129e7")
        );
    }
}
