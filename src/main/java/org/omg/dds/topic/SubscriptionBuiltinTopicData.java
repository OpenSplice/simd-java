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

package org.omg.dds.topic;

import java.util.List;

import org.omg.dds.core.policy.DataRepresentation;
import org.omg.dds.core.policy.Deadline;
import org.omg.dds.core.policy.DestinationOrder;
import org.omg.dds.core.policy.Durability;
import org.omg.dds.core.policy.GroupData;
import org.omg.dds.core.policy.LatencyBudget;
import org.omg.dds.core.policy.Liveliness;
import org.omg.dds.core.policy.Ownership;
import org.omg.dds.core.policy.Partition;
import org.omg.dds.core.policy.Presentation;
import org.omg.dds.core.policy.Reliability;
import org.omg.dds.core.policy.TimeBasedFilter;
import org.omg.dds.core.policy.TopicData;
import org.omg.dds.core.policy.TypeConsistencyEnforcement;
import org.omg.dds.core.policy.UserData;
import org.omg.dds.type.Extensibility;
import org.omg.dds.type.ID;
import org.omg.dds.type.Key;
import org.omg.dds.type.Optional;
import org.omg.dds.type.typeobject.TypeObject;


@Extensibility(Extensibility.Kind.MUTABLE_EXTENSIBILITY)
public abstract class SubscriptionBuiltinTopicData {
    // -----------------------------------------------------------------------
    // Private Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = 1517912242172167011L;



    // -----------------------------------------------------------------------
    // Factory Methods
    // -----------------------------------------------------------------------

    /**
     * @param bootstrap Identifies the Service instance to which the new
     *                  object will belong.
     */
    /*
    public static SubscriptionBuiltinTopicData newSubscriptionBuiltinTopicData(
            Bootstrap bootstrap) {
        return bootstrap.getSPI().newSubscriptionBuiltinTopicData();
    }
      */


    // -----------------------------------------------------------------------
    // Instance Methods
    // -----------------------------------------------------------------------

    @ID(0x005A) @Key
    public abstract BuiltinTopicKey getKey();

    /**
     * @return the participantKey
     */
    @ID(0x0050)
    public abstract BuiltinTopicKey getParticipantKey();

    /**
     * @return the topicName
     */
    @ID(0x0005)
    public abstract String getTopicName();

    /**
     * @return the typeName
     */
    @ID(0x0007)
    public abstract String getTypeName();

    @ID(0x0075) @Optional
    public abstract List<String> getEquivalentTypeName();

    @ID(0x0076) @Optional
    public abstract List<String> getBaseTypeName();

    @ID(0x0072) @Optional
    public abstract TypeObject getType();

    /**
     * @return the durability
     */
    @ID(0x001D)
    public abstract Durability getDurability();

    /**
     * @return the deadline
     */
    @ID(0x0023)
    public abstract Deadline getDeadline();

    /**
     * @return the latencyBudget
     */
    @ID(0x0027)
    public abstract LatencyBudget getLatencyBudget();

    /**
     * @return the liveliness
     */
    @ID(0x001B)
    public abstract Liveliness getLiveliness();

    /**
     * @return the reliability
     */
    @ID(0x001A)
    public abstract Reliability getReliability();

    /**
     * @return the ownership
     */
    @ID(0x001F)
    public abstract Ownership getOwnership();

    /**
     * @return the destinationOrder
     */
    @ID(0x0025)
    public abstract DestinationOrder getDestinationOrder();

    /**
     * @return the userData
     */
    @ID(0x002C)
    public abstract UserData getUserData();

    /**
     * @return the timeBasedFilter
     */
    @ID(0x0004)
    public abstract TimeBasedFilter getTimeBasedFilter();

    /**
     * @return the presentation
     */
    @ID(0x0021)
    public abstract Presentation getPresentation();

    /**
     * @return the partition
     */
    @ID(0x0029)
    public abstract Partition getPartition();

    /**
     * @return the topicData
     */
    @ID(0x002E)
    public abstract TopicData getTopicData();

    /**
     * @return the groupData
     */
    @ID(0x002D)
    public abstract GroupData getGroupData();

    @ID(0x0073)
    public abstract DataRepresentation getRepresentation();

    @ID(0x0074)
    public abstract TypeConsistencyEnforcement getTypeConsistency();


    // --- From Object: ------------------------------------------------------

    @Override
    public abstract SubscriptionBuiltinTopicData clone();
}
