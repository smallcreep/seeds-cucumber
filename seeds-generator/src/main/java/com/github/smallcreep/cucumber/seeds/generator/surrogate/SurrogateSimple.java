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

import com.github.smallcreep.cucumber.seeds.generator.Placeholder;
import com.github.smallcreep.cucumber.seeds.generator.Surrogate;
import com.github.smallcreep.cucumber.seeds.generator.placeholders.PlaceholderRandomInt;
import java.util.Iterator;
import java.util.Map;
import org.cactoos.Scalar;
import org.cactoos.func.UncheckedFunc;
import org.cactoos.iterable.IterableOf;
import org.cactoos.map.MapEnvelope;
import org.cactoos.map.MapOf;

/**
 * Simple implementation of surrogate.
 * @since 0.2.0
 */
public final class SurrogateSimple
    extends MapEnvelope<String, String> implements Surrogate {

    /**
     * Ctor.
     * @param origin Origin Map
     */
    public SurrogateSimple(final Scalar<Map<String, String>> origin) {
        this(origin, new PlaceholderRandomInt());
    }

    /**
     * Ctor.
     * @param origin Origin Map
     * @param placeholders Placeholders
     */
    public SurrogateSimple(
        final Scalar<Map<String, String>> origin,
        final Placeholder... placeholders
    ) {
        this(origin, new IterableOf<>(placeholders));
    }

    /**
     * Ctor.
     * @param origin Origin Map
     * @param placeholders Placeholders
     */
    public SurrogateSimple(
        final Scalar<Map<String, String>> origin,
        final Iterable<Placeholder> placeholders
    ) {
        super(
            () -> new MapOf<>(
                Entry::getKey, entry -> {
                String value = null;
                final Iterator<Placeholder> places = placeholders.iterator();
                while (value == null && places.hasNext()) {
                    value = new UncheckedFunc<>(
                        places.next()
                    ).apply(entry.getValue());
                }
                return value;
            },
                origin.value().entrySet()
            )
        );
    }
}
