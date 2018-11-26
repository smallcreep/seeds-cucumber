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

package com.github.smallcreep.cucumber.seeds.sqlvalue;

import com.github.smallcreep.cucumber.seeds.SqlValue;
import org.cactoos.iterable.IterableOf;
import org.cactoos.iterable.Mapped;
import org.cactoos.text.FormattedText;
import org.cactoos.text.JoinedText;

/**
 * Envelope sql value with array type with casting.
 * @since 0.2.2
 */
public abstract class SqlValueCastArrayEnvelope extends SqlValueCastEnvelope {

    /**
     * Ctor.
     * @param type Cast type
     * @param value Sql value for element
     */
    public SqlValueCastArrayEnvelope(final String type, final SqlValue value) {
        super(
            type,
            input -> new FormattedText(
                "ARRAY[%s]",
                new JoinedText(
                    ",",
                    new Mapped<>(
                        value,
                        new Mapped<>(
                            String::trim,
                            new IterableOf<>(
                                input.split(",")
                            )
                        )
                    )
                ).asString()
            ).asString()
        );
    }
}
