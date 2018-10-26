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
import org.cactoos.text.ReplacedText;
import org.cactoos.text.TextOf;

/**
 * Regexp placeholder.
 * @since 0.2.0
 */
final class PlaceholderRegexp implements Placeholder {

    /**
     * Origin placeholder.
     */
    private final Placeholder origin;

    /**
     * Regexp.
     */
    private final String regexp;

    /**
     * Ctor.
     * @param origin Origin placeholder
     * @param regexp Regexp
     */
    PlaceholderRegexp(final Placeholder origin, final String regexp) {
        this.origin = origin;
        this.regexp = regexp;
    }

    @Override
    public String apply(final String input) throws Exception {
        final String result;
        if (input.matches(String.format(".*?(%s).*?", this.regexp))) {
            result = new ReplacedText(
                new TextOf(input),
                () -> Pattern.compile(this.regexp),
                matcher -> Matcher.quoteReplacement(this.origin.apply(input))
            ).asString();
        } else {
            result = input;
        }
        return result;
    }
}
