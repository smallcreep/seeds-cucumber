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

package com.github.smallcreep.cucumber.seeds.fake;

import java.util.Map;
import org.cactoos.iterator.IteratorOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Test Case for {@link ResultSetFakeGetLong}.
 * @since 0.2.0
 */
public final class ResultSetFakeGetLongTest {

    /**
     * Check ResultSetFakeGetLong can return next.
     */
    @Test
    public void canReturnNext() {
        MatcherAssert.assertThat(
            new ResultSetFakeGetLong(
                new IteratorOf<Map<String, Long>>(
                    new MapOf<String, Long>(
                        new MapEntry<>(
                            "1",
                            1L
                        )
                    )
                )
            ).next(),
            CoreMatchers.equalTo(true)
        );
    }

    /**
     * Check ResultSetFakeGetLong can return element by index.
     */
    @Test
    public void canReturnLongByIndex() {
        MatcherAssert.assertThat(
            new ResultSetFakeGetLong(
                new IteratorOf<Map<String, Long>>(
                    new MapOf<String, Long>(
                        new MapEntry<>(
                            "index",
                            1L
                        )
                    )
                )
            ).getLong(0),
            CoreMatchers.equalTo(1L)
        );
    }

    /**
     * Check ResultSetFakeGetLong can return element by label.
     */
    @Test
    public void canReturnLongByLabel() {
        final String label = "label";
        MatcherAssert.assertThat(
            new ResultSetFakeGetLong(
                new IteratorOf<Map<String, Long>>(
                    new MapOf<String, Long>(
                        new MapEntry<>(
                            label,
                            1L
                        )
                    )
                )
            ).getLong(label),
            CoreMatchers.equalTo(1L)
        );
    }
}
