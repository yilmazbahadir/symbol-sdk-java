/*
 * Copyright 2019. NEM
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package io.nem.sdk.model.transaction;

import io.nem.sdk.model.blockchain.NetworkType;
import io.nem.sdk.model.namespace.NamespaceId;
import io.nem.sdk.model.namespace.NamespaceType;
import java.math.BigInteger;
import java.util.Optional;
import org.apache.commons.lang3.Validate;

/**
 * Factory of {@link NamespaceRegistrationTransaction}
 */
public class NamespaceRegistrationTransactionFactory extends
    TransactionFactory<NamespaceRegistrationTransaction> {

    private final String namespaceName;
    private final NamespaceId namespaceId;
    private final Optional<BigInteger> duration;
    private final Optional<NamespaceId> parentId;
    private final NamespaceType namespaceType;


    public NamespaceRegistrationTransactionFactory(
        final NetworkType networkType,
        final String namespaceName,
        final NamespaceId namespaceId,
        final NamespaceType namespaceType,
        final Optional<BigInteger> duration,
        final Optional<NamespaceId> parentId) {
        super(TransactionType.REGISTER_NAMESPACE, networkType);
        Validate.notNull(namespaceName, "NamespaceName must not be null");
        Validate.notNull(namespaceType, "NamespaceType must not be null");
        Validate.notNull(namespaceId, "NamespaceId must not be null");
        if (namespaceType == NamespaceType.ROOT_NAMESPACE) {
            Validate.isTrue(duration.isPresent(), "Duration must be provided");
        } else {
            Validate.isTrue(parentId.isPresent(), "ParentId must be provided");
        }
        this.namespaceName = namespaceName;
        this.namespaceType = namespaceType;
        this.namespaceId = namespaceId;
        this.duration = duration;
        this.parentId = parentId;
    }

    /**
     * Creates a root namespace factory.
     *
     * @param networkType Network type.
     * @param namespaceName Namespace name.
     * @param duration Duration of the namespace.
     * @return Register namespace transaction.
     */
    public static NamespaceRegistrationTransactionFactory createRootNamespace(
        final NetworkType networkType,
        final String namespaceName,
        final BigInteger duration) {
        NamespaceId namespaceId = NamespaceId.createFromName(namespaceName);
        return new NamespaceRegistrationTransactionFactory(networkType, namespaceName,
            namespaceId, NamespaceType.ROOT_NAMESPACE, Optional.of(duration), Optional.empty());
    }


    /**
     * Create a sub namespace object.
     *
     * @param namespaceName Namespace name.
     * @param parentId Parent id name.
     * @param networkType Network type.
     * @return instance of RegisterNamespaceTransaction
     */
    public static NamespaceRegistrationTransactionFactory createSubNamespace(
        final NetworkType networkType,
        final String namespaceName,
        final NamespaceId parentId) {
        NamespaceId namespaceId = NamespaceId
            .createFromNameAndParentId(namespaceName, parentId.getId());
        return new NamespaceRegistrationTransactionFactory(networkType, namespaceName, namespaceId,
            NamespaceType.SUB_NAMESPACE, Optional.empty(),
            Optional.of(parentId));
    }


    /**
     * Returns namespace name.
     *
     * @return namespace name
     */
    public String getNamespaceName() {
        return namespaceName;
    }

    /**
     * Returns id of the namespace derived from namespaceName. When creating a sub namespace the
     * namespaceId is derived from namespaceName and parentId.
     *
     * @return namespace id
     */
    public NamespaceId getNamespaceId() {
        return namespaceId;
    }

    /**
     * Returns number of blocks a namespace is active.
     *
     * @return namespace renting duration
     */
    public Optional<BigInteger> getDuration() {
        return duration;
    }

    /**
     * The id of the parent sub namespace.
     *
     * @return sub namespace
     */
    public Optional<NamespaceId> getParentId() {
        return parentId;
    }

    /**
     * Returns namespace type either RootNamespace or SubNamespace.
     *
     * @return namespace type
     */
    public NamespaceType getNamespaceType() {
        return namespaceType;
    }

    @Override
    public NamespaceRegistrationTransaction build() {
        return new NamespaceRegistrationTransaction(this);
    }
}
