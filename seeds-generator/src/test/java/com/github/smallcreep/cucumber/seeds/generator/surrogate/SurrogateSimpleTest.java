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

package com.github.smallcreep.cucumber.seeds.generator.surrogate;

import com.github.smallcreep.cucumber.seeds.generator.placeholders.PlaceholderSimple;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Test Case for {@link SurrogateSimple}.
 * @since 0.2.0
 */
public final class SurrogateSimpleTest {

    /**
     * SurrogateSimple can replace placeholders.
     */
    @Test
    public void replacePlaceholders() {
        final String key = "replacePlaceholders";
        MatcherAssert.assertThat(
            Integer.valueOf(
                new SurrogateSimple().apply(
                    new MapOf<String, String>(
                        new MapEntry<String, String>(
                            key,
                            "#Random#Integer"
                        )
                    )
                ).get(key)
            ),
            CoreMatchers.instanceOf(Integer.class)
        );
    }

    /**
     * SurrogateSimple can replace placeholders check specific placeholder.
     */
    @Test
    public void replaceSpecificPlaceholder() {
        final String key = "replaceSpecificPlaceholder";
        final String value = "specific";
        MatcherAssert.assertThat(
            new SurrogateSimple(
                new PlaceholderSimple(
                    value
                )
            ).apply(
                new MapOf<String, String>(
                    new MapEntry<String, String>(
                        key,
                        "#AnyPlaceholder"
                    )
                )
            ).get(key),
            CoreMatchers.equalTo(value)
        );
    }
}
