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
import org.cactoos.BiFunc;
import org.cactoos.Text;
import org.cactoos.text.FormattedText;

/**
 * Placeholder with params in round braces,
 * replace all placeholders in parameter.
 * @since 0.2.0
 */
public abstract class PlaceholderWithParams implements Placeholder {

    /**
     * Function string.
     */
    private static final String FUNCTION = "%s\\(%s\\)";

    /**
     * Origin function for placeholder.
     */
    private final BiFunc<String, String, String> origin;

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
     * @param origin Origin function for placeholder
     * @param regexp Regexp
     * @param placeholder Placeholder
     * @throws Exception if fails
     */
    public PlaceholderWithParams(
        final BiFunc<String, String, String> origin,
        final String regexp,
        final Placeholder placeholder
    ) throws Exception {
        this.origin = origin;
        this.pattern = Pattern.compile(
            new FormattedText(
                PlaceholderWithParams.FUNCTION,
                regexp,
                "([^)]*)"
            ).asString()
        );
        this.regexp = new FormattedText(
            PlaceholderWithParams.FUNCTION,
            regexp,
            "%s"
        );
        this.placeholder = placeholder;
    }

    @Override
    public final String apply(final String input) throws Exception {
        String result = input;
        Matcher matcher = this.pattern.matcher(result);
        while (matcher.find()) {
            final String group = matcher.group(1);
            result = new PlaceholderRegexp(
                temp -> this.origin.apply(temp, this.placeholder.apply(group)),
                String.format(this.regexp.asString(), group)
            ).apply(result);
            matcher = this.pattern.matcher(result);
        }
        return result;
    }
}
