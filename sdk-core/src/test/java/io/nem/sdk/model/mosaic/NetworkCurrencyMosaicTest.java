package io.nem.sdk.model.mosaic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.nem.sdk.model.namespace.NamespaceId;
import io.nem.sdk.model.transaction.UInt64;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class NetworkCurrencyMosaicTest {

    @Test
    void shouldCreateNetworkCurrencyMosaicViaConstructor() {
        NetworkCurrencyMosaic currency = new NetworkCurrencyMosaic(BigInteger.valueOf(0));
        assertEquals(BigInteger.valueOf(0), currency.getAmount());
        assertEquals(NetworkCurrencyMosaic.NAMESPACEID, currency.getId());
        assertEquals("85bbea6cc462b244", currency.getIdAsHex());
    }

    @Test
    void shouldCreateRelativeNetworkCurrencyMosaic() {
        NetworkCurrencyMosaic currency = NetworkCurrencyMosaic
            .createRelative(BigInteger.valueOf(1000));
        assertEquals(BigInteger.valueOf(1000 * 1000000), currency.getAmount());
        assertEquals(NetworkCurrencyMosaic.NAMESPACEID, currency.getId());
        assertEquals("85bbea6cc462b244", currency.getIdAsHex());
    }

    @Test
    void shouldCreateAbsoluteNetworkCurrencyMosaic() {
        NetworkCurrencyMosaic currency = NetworkCurrencyMosaic
            .createAbsolute(BigInteger.valueOf(1));
        assertEquals(BigInteger.valueOf(1), currency.getAmount());
        assertEquals(NetworkCurrencyMosaic.NAMESPACEID, currency.getId());
        assertEquals("85bbea6cc462b244", currency.getIdAsHex());
    }

    @Test
    void shouldCompareNamespaceIdsForEquality() {
        NamespaceId namespaceId = new NamespaceId(
            UInt64.fromLowerAndHigher(3294802500L, 2243684972L));
        assertEquals(-8810190493148073404L, namespaceId.getIdAsLong());
        assertEquals(NetworkCurrencyMosaic.NAMESPACEID.getIdAsLong(), namespaceId.getIdAsLong());
        assertEquals(NetworkCurrencyMosaic.NAMESPACEID.getIdAsHex(), namespaceId.getIdAsHex());

        // Note:
        // BigInteger decimal generated from namespace path vs generated using Lower and Higher integers
        // Using namespace path:     9636553580561478212 (Decimal number)
        // Using Lower and Higher:  -8810190493148073404 (Decimal from signed 2's complement)
        // In Hexadecimal:              85bbea6cc462b244 (same for both)
    }

    @Test
    @SuppressWarnings("squid:S3415")
    void shouldHaveValidStatics() {
        assertEquals(6, NetworkCurrencyMosaic.DIVISIBILITY);
        assertEquals(BigInteger.valueOf(8999999999L), NetworkCurrencyMosaic.INITIALSUPPLY);
        assertTrue(NetworkCurrencyMosaic.TRANSFERABLE);
        assertFalse(NetworkCurrencyMosaic.SUPPLYMUTABLE);
    }
}