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

package com.github.smallcreep.cucumber.seeds.web.browser;

import com.github.smallcreep.cucumber.seeds.web.Browser;
import com.github.smallcreep.cucumber.seeds.web.Tab;
import com.github.smallcreep.cucumber.seeds.web.tab.WebDriverTab;
import java.util.concurrent.atomic.AtomicReference;
import org.openqa.selenium.WebDriver;

/**
 * Browser based on WebDriver.
 * @since 0.2.2
 */
public final class WebDriverBrowser implements Browser {

    /**
     * Web driver.
     */
    private final WebDriver driver;

    /**
     * Current tab.
     */
    private final AtomicReference<Tab> current;

    /**
     * Ctor.
     * @param driver Web driver
     */
    public WebDriverBrowser(final WebDriver driver) {
        this.driver = driver;
        this.current = new AtomicReference<>(null);
    }

    @Override
    public Tab tab() {
        if (this.current.get() == null) {
            this.current.set(new WebDriverTab(this, this.driver));
        }
        return this.current.get();
    }

    @Override
    public void close() {
        this.driver.close();
    }
}