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

import com.jcabi.matchers.RegexMatchers;
import org.cactoos.text.FormattedText;
import org.cactoos.text.JoinedText;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Test Case for {@link PlaceholdersAll}.
 * @since 0.2.0
 */
public final class PlaceholdersAllTest {

    /**
     * PlaceholdersAll can replace placeholders.
     * @throws Exception if fails
     */
    @Test
    public void replacePlaceholders() throws Exception {
        MatcherAssert.assertThat(
            Integer.valueOf(
                new PlaceholdersAll().apply("#Random#Integer")
            ),
            CoreMatchers.instanceOf(Integer.class)
        );
    }

    /**
     * PlaceholdersAll can replace placeholders check specific placeholder.
     */
    @Test
    public void replaceSpecificPlaceholder() {
        final String value = "specific";
        MatcherAssert.assertThat(
            new PlaceholdersAll(
                new PlaceholderSimple(
                    value
                )
            ).apply("#AnyPlaceholder"),
            CoreMatchers.equalTo(value)
        );
    }

    /**
     * PlaceholdersAll can't replace placeholders if placeholder not exists.
     * @throws Exception if fails
     */
    @Test
    public void notReplacePlaceholder() throws Exception {
        final String value = "#NotExistingPlaceholder";
        MatcherAssert.assertThat(
            new PlaceholdersAll().apply(value),
            CoreMatchers.equalTo(value)
        );
    }

    /**
     * Placeholders must rewrite only self string.
     * @throws Exception if fails
     */
    @Test
    public void replaceSelfString() throws Exception {
        MatcherAssert.assertThat(
            new PlaceholdersAll().apply("Start#Random#IntegerEnd"),
            CoreMatchers.allOf(
                CoreMatchers.startsWith("Start"),
                CoreMatchers.endsWith("End")
            )
        );
    }

    /**
     * PlaceholdersAll can replace all placeholders in string.
     * @throws Exception if fails
     */
    @Test
    public void replaceAllPlaceholder() throws Exception {
        MatcherAssert.assertThat(
            new PlaceholdersAll(
            ).apply(
                new JoinedText(
                    "; ",
                    "timestamp = #Timestamp#Now",
                    "integer = #Random#Integer",
                    "string = #Random#String",
                    "string length = #Random#String(10)",
                    "serial = #Random#Serial",
                    "md5 = #Encryption#Md5(#Random#String)"
                ).asString()
            ),
            RegexMatchers.matchesPattern(
                new FormattedText(
                    "^%s$",
                    new JoinedText(
                        "; ",
                        new JoinedText(
                            " = ",
                            "timestamp",
                            "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d+"
                        ).asString(),
                        "integer = -?\\d+",
                        "string = (?!#Random#String).+",
                        "string length = .*{10}",
                        "serial = [1-9]{1}\\d*",
                        "md5 = [0-9abcdef]{32}"
                    ).asString()
                ).asString()
            )
        );
    }
}
