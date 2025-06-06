/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.index.compositeindex.datacube;

import org.opensearch.common.annotation.ExperimentalApi;

/**
 * Represents the data type of the dimension value.
 * TODO: This needs to be eventually merged with DimensionFilterMapper and all indexing related code
 *  which use this should instead use the mapper
 *
 * @opensearch.experimental
 */
@ExperimentalApi
public enum DimensionDataType {
    LONG {
        @Override
        public int compare(Long a, Long b) {
            if (a == null && b == null) {
                return 0;
            }
            if (b == null) {
                return -1;
            }
            if (a == null) {
                return 1;
            }
            return Long.compare(a, b);
        }
    },
    UNSIGNED_LONG {
        @Override
        public int compare(Long a, Long b) {
            if (a == null && b == null) {
                return 0;
            }
            if (b == null) {
                return -1;
            }
            if (a == null) {
                return 1;
            }
            return Long.compareUnsigned(a, b);
        }
    };

    public abstract int compare(Long a, Long b);
}
