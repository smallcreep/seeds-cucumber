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
import java.util.Map;
import org.cactoos.Scalar;
import org.cactoos.map.MapEnvelope;

/**
 * Simple implementation of surrogate.
 * @since 0.2.0
 */
public final class SurrogateSimple
    extends MapEnvelope<String, String> implements Surrogate {

    /**
     * Ctor.
     * @param placeholders Placeholders
     * @param origin Origin Map
     * @todo #87:15m/DEV Implement this class.
     *  This class should replace all placeholders.
     *  This class doesn't change key, but change values from origin map.
     *  Values should replaced by regexp.
     */
    @SuppressWarnings("PMD.UnusedFormalParameter")
    public SurrogateSimple(
        final Iterable<Placeholder> placeholders,
        final Scalar<Map<String, String>> origin
    ) {
        super(origin);
    }
}
