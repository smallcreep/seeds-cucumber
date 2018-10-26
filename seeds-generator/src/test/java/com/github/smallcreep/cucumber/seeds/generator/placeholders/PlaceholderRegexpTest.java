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
 * Test Case for {@link PlaceholderRegexp}.
 * @since 0.2.0
 */
public final class PlaceholderRegexpTest {

    /**
     * PlaceholderRegexp should run origin placeholder if input string match
     * with regexp.
     * @throws Exception if Fails
     */
    @Test
    public void returnValueIfInputMatchesRegexp() throws Exception {
        final String res = "returnValueIfInputMatchesRegexp";
        MatcherAssert.assertThat(
            new PlaceholderRegexp(
                new PlaceholderSimple(
                    res
                ),
                ".+"
            ).apply("any words"),
            CoreMatchers.equalTo(res)
        );
    }

    /**
     * PlaceholderRegexp shouldn't run origin placeholder if input string
     * doesn't match with regexp.
     * @throws Exception if Fails
     */
    @Test
    public void returnNullIfInputNotMatchesRegexp() throws Exception {
        final String input = "not match words";
        MatcherAssert.assertThat(
            new PlaceholderRegexp(
                new PlaceholderSimple(
                    "returnNullIfInputNotMatchesRegexp"
                ),
                "1"
            ).apply(input),
            CoreMatchers.equalTo(input)
        );
    }

    /**
     * Placeholders must rewrite only self string.
     * @throws Exception if Fails
     */
    @Test
    public void replaceSelfString() throws Exception {
        MatcherAssert.assertThat(
            new PlaceholderRegexp(
                new PlaceholderSimple(
                    "123"
                ),
                "#Random#Integer"
            ).apply("Start#Random#IntegerEnd"),
            CoreMatchers.equalTo("Start123End")
        );
    }
}
