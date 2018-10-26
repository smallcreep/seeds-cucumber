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
import com.jcabi.matchers.RegexMatchers;
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
                new SurrogateSimple(
                    () -> new MapOf<String, String>(
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
                () -> new MapOf<String, String>(
                    new MapEntry<String, String>(
                        key,
                        "#AnyPlaceholder"
                    )
                ),
                new PlaceholderSimple(
                    value
                )
            ).get(key),
            CoreMatchers.equalTo(value)
        );
    }

    /**
     * SurrogateSimple can't replace placeholders if placeholder not exists.
     */
    @Test
    public void notReplacePlaceholder() {
        final String key = "notReplacePlaceholder";
        final String value = "#NotExistingPlaceholder";
        MatcherAssert.assertThat(
            new SurrogateSimple(
                () -> new MapOf<String, String>(
                    new MapEntry<String, String>(
                        key,
                        value
                    )
                )
            ).get(key),
            CoreMatchers.equalTo(value)
        );
    }

    /**
     * Placeholders must rewrite only self string.
     */
    @Test
    public void replaceSelfString() {
        final String key = "replaceSelfString";
        MatcherAssert.assertThat(
            new SurrogateSimple(
                () -> new MapOf<String, String>(
                    new MapEntry<String, String>(
                        key,
                        "Start#Random#IntegerEnd"
                    )
                )
            ).get(key),
            CoreMatchers.allOf(
                CoreMatchers.startsWith("Start"),
                CoreMatchers.endsWith("End")
            )
        );
    }

    /**
     * Surrogate can replace all placeholders in string.
     */
    @Test
    public void replaceAllPlaceholder() {
        final String key = "replaceAllPlaceholder";
        MatcherAssert.assertThat(
            new SurrogateSimple(
                () -> new MapOf<String, String>(
                    new MapEntry<String, String>(
                        key,
                        String.format(
                            "%s; %s; %s;",
                            "timestamp = #Timestamp#Now",
                            "integer = #Random#Integer",
                            "string = #Random#String"
                        )
                    )
                )
            ).get(key),
            RegexMatchers.matchesPattern(
                String.format(
                    "^timestamp = %s; integer = %s; string = %s;$",
                    "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d+",
                    "-?\\d+",
                    "(?!#Random#String).+"
                )
            )
        );
    }
}
