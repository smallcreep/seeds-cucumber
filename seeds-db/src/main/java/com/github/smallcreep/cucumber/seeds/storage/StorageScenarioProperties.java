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

package com.github.smallcreep.cucumber.seeds.storage;

import com.github.smallcreep.cucumber.seeds.Context;
import com.github.smallcreep.cucumber.seeds.Storage;
import java.util.Map;
import org.cactoos.iterable.IterableEnvelope;
import org.cactoos.iterable.Mapped;
import org.cactoos.text.FormattedText;
import org.cactoos.text.JoinedText;
import org.cactoos.text.UncheckedText;

/**
 * Save all values to Scenario context.
 * @since 0.2.0
 */
public final class StorageScenarioProperties
    extends IterableEnvelope<Map<String, String>> implements Storage {

    /**
     * Ctor.
     * @param maps Iterable maps
     * @param ctx Context
     * @param name Name properties in context
     */
    public StorageScenarioProperties(
        final Iterable<Map<String, String>> maps,
        final Context ctx,
        final String name
    ) {
        super(
            () -> new Mapped<>(
                input -> {
                    final String iid = input.get("iid");
                    input.forEach(
                        (key, value) -> ctx.add(
                            new UncheckedText(
                                new JoinedText(
                                    "#",
                                    "#Storage",
                                    name,
                                    new UncheckedText(
                                        new FormattedText(
                                            "iid=%s(%s)",
                                            iid,
                                            key
                                        )
                                    ).asString()
                                )
                            ).asString(),
                            value
                        )
                    );
                    return input;
                },
                maps
            )
        );
    }

}
