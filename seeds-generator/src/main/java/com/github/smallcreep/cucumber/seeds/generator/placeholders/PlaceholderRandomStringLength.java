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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.cactoos.Text;
import org.cactoos.text.FormattedText;
import org.cactoos.text.RandomText;

/**
 * Placeholder return random string with fixed length.
 * @since 0.2.0
 */
public final class PlaceholderRandomStringLength implements Placeholder {

    /**
     * Function string.
     */
    private static final String FUNCTION = "%s\\(%s\\)";

    /**
     * Placeholder.
     */
    private final Placeholder placeholder;

    /**
     * Pattern.
     */
    private final Pattern pattern;

    /**
     * Regexp.
     */
    private final Text regexp;

    /**
     * Ctor.
     * @throws Exception if fails
     */
    public PlaceholderRandomStringLength() throws Exception {
        this(new PlaceholdersAll());
    }

    /**
     * Ctor.
     * @param placeholder Placeholder
     * @throws Exception if fails
     */
    public PlaceholderRandomStringLength(final Placeholder placeholder)
        throws Exception {
        this(placeholder, "#Random#String");
    }

    /**
     * Ctor.
     * @param placeholder Placeholder
     * @param regexp Regexp
     * @throws Exception if fails
     */
    public PlaceholderRandomStringLength(
        final Placeholder placeholder,
        final String regexp
    ) throws Exception {
        this(
            placeholder,
            Pattern.compile(
                new FormattedText(
                    PlaceholderRandomStringLength.FUNCTION,
                    regexp,
                    "([^)]*)"
                ).asString()
            ),
            new FormattedText(
                PlaceholderRandomStringLength.FUNCTION,
                regexp,
                "%s"
            )
        );
    }

    /**
     * Ctor.
     * @param placeholder Placeholder
     * @param pattern Pattern
     * @param regexp Regexp
     */
    private PlaceholderRandomStringLength(
        final Placeholder placeholder,
        final Pattern pattern,
        final Text regexp
    ) {
        this.pattern = pattern;
        this.regexp = regexp;
        this.placeholder = placeholder;
    }

    @Override
    public String apply(final String input) throws Exception {
        String result = input;
        Matcher matcher = this.pattern.matcher(result);
        while (matcher.find()) {
            final String group = matcher.group(1);
            result = new PlaceholderRegexp(
                temp -> new RandomText(
                    Integer.valueOf(
                        this.placeholder.apply(
                            group
                        )
                    )
                ).asString(),
                String.format(this.regexp.asString(), group)
            ).apply(result);
            matcher = this.pattern.matcher(result);
        }
        return result;
    }
}
