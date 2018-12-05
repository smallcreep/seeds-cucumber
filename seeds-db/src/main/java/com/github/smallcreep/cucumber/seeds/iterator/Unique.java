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

package com.github.smallcreep.cucumber.seeds.iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.cactoos.scalar.StickyScalar;
import org.cactoos.scalar.UncheckedScalar;

/**
 * Unique iterator. Return only unique items.
 * @param <T> Element type
 * @since 0.2.2
 */
public final class Unique<T> implements Iterator<T> {

    /**
     * Unique scalar.
     */
    private final UncheckedScalar<Iterator<T>> scalar;

    /**
     * Ctor.
     * @param iterator The original iterator
     */
    public Unique(final Iterator<T> iterator) {
        this.scalar = new UncheckedScalar<>(
            new StickyScalar<>(
                () -> {
                    final Set<T> items = new HashSet<>();
                    while (iterator.hasNext()) {
                        items.add(iterator.next());
                    }
                    return items.iterator();
                }
            )
        );
    }

    @Override
    public boolean hasNext() {
        return this.scalar.value().hasNext();
    }

    @Override
    public T next() {
        return this.scalar.value().next();
    }
}
