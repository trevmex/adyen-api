/*
 * Copyright 2015 Willian Oki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.github.woki.payments.adyen.action;

import com.github.woki.payments.adyen.ClientConfig;
import com.github.woki.payments.adyen.error.APSAccessException;
import com.github.woki.payments.adyen.model.RecurringDisableRequest;
import com.github.woki.payments.adyen.model.RecurringDisableResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
public final class RecurringDisable {
    private RecurringDisable() {
        // utility
    }

    private static final Logger LOG = LoggerFactory.getLogger(RecurringDisable.class);

    public static RecurringDisableResponse execute(final ClientConfig config, final RecurringDisableRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("config: {}, request: {}", config, request);
        }
        RecurringDisableResponse retval;
        try {
            retval = Endpoint.invoke(config, request, RecurringDisableResponse.class);
        } catch (Exception e) {
            LOG.error("recurring disable", e);
            throw new APSAccessException("recurring disable", e);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("retval: {}", retval);
        }
        return retval;
    }
}