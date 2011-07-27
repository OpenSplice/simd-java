/* Copyright 2010, Object Management Group, Inc.
 * Copyright 2010, PrismTech, Inc.
 * Copyright 2010, Real-Time Innovations, Inc.
 * All rights reserved.
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
 */

package org.omg.dds.core.policy;

import org.omg.dds.pub.DataWriter;
import org.omg.dds.sub.DataReader;
import org.omg.dds.topic.Topic;

/**
 * [optional] Specifies whether it is allowed for multiple {@link DataWriter}s
 * to write the same instance of the data and if so, how these modifications
 * should be arbitrated.
 * 
 * <b>Concerns:</b> {@link Topic}, {@link DataReader}, {@link DataWriter}
 * 
 * <b>RxO:</b> Yes
 * 
 * <b>Changeable:</b> No
 * 
 * @see OwnershipStrength
 */
public class Ownership implements QosPolicy {
    /** The default serialVersionUID. */
    private static final long serialVersionUID = 1L;
    // -- Constant Members
    public final static int ID = 9;
    private final static String NAME = "Ownership";
    private static final Ownership SHARED = new Ownership(Kind.SHARED);
    private static final Ownership EXCLUSIVE = new Ownership(Kind.EXCLUSIVE);
    // - Attributes
    private Kind kind;

    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    /**
     * @return the kind
     */
    public Kind getKind() {
        return kind;
    }

    // -----------------------------------------------------------------------
    // Types
    // -----------------------------------------------------------------------

    public enum Kind {
        /**
         * Indicates shared ownership for each instance. Multiple writers are
         * allowed to update the same instance and all the updates are made
         * available to the readers. In other words there is no concept of an
         * "owner" for the instances. This is the default behavior.
         */
        SHARED,

        /**
         * Indicates each instance can only be owned by one {@link DataWriter},
         * but the owner of an instance can change dynamically. The selection of
         * the owner is controlled by the setting of the
         * {@link OwnershipStrength}. The owner is always set to be the
         * highest-strength DataWriter object among the ones currently "active"
         * (as determined by the {@link Liveliness}).
         */
        EXCLUSIVE
    }

    // -- Ctors
    private Ownership(Kind kind) {
        this.kind = kind;
    }

    // -- Methods from QosPolicy
    public final int getPolicyId() {
        return ID;
    }

    public final String getPolicyName() {
        return NAME;
    }

    public static Ownership Shared() {
        return Ownership.SHARED;
    }

    public static Ownership Exclusive() {
        return Ownership.EXCLUSIVE;
    }

}
