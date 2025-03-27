package org.sandbox.collection.cache;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class LruCacheTest {

    @Test
    void whenCreatingCacheWithZeroItemCapacity_shouldComplain() {
        assertThrows(IllegalArgumentException.class, () -> new LruCache<String, BigDecimal>(0));
    }

    @Test
    void whenCreatingCacheWithOneItemCapacity_shouldNotComplain() {
        assertDoesNotThrow(() -> new LruCache<>(1));
    }

    @Test
    void givenOneItemSizeEmptyCache_whenGetItem_shouldReturnNull() {
        Cache<String, BigDecimal> cache = new LruCache<String, BigDecimal>(1);

        Optional<BigDecimal> item = cache.get("Apple");

        assertTrue(item.isEmpty());
    }

    @Test
    void givenOneItemSizeEmptyCache_whenPutFirstItem_shouldAddItem() {
        Cache<String, BigDecimal> cache = new LruCache<String, BigDecimal>(1);

        cache.put("Apple", BigDecimal.valueOf(2.5));

        Optional<BigDecimal> item = cache.get("Apple");
        assertFalse(item.isEmpty());
    }

    @Test
    void givenOneItemSizeCacheWithOneItem_whenPutFirstItem_shouldOverrideFirstItem() {
        Cache<String, BigDecimal> cache = new LruCache<String, BigDecimal>(1);
        cache.put("Apple", BigDecimal.valueOf(2.5));

        cache.put("Microsoft", BigDecimal.valueOf(1.2));

        assertFalse(cache.get("Microsoft").isEmpty());
        assertTrue(cache.get("Apple").isEmpty());
    }

    @Test
    void givenTwoItemSizeCacheWithOneItem_whenPutFirstItem_shouldAddItem() {
        Cache<String, BigDecimal> cache = new LruCache<String, BigDecimal>(2);
        cache.put("Apple", BigDecimal.valueOf(2.5));

        cache.put("Microsoft", BigDecimal.valueOf(1.2));

        assertFalse(cache.get("Apple").isEmpty());
        assertFalse(cache.get("Microsoft").isEmpty());
    }

    @Test
    void givenTwoItemSizeCacheWithOneItem_whenPutItemWithSameKeyAsFirstItem_shouldOverrideItem() {
        Cache<String, BigDecimal> cache = new LruCache<String, BigDecimal>(2);
        cache.put("Apple", BigDecimal.valueOf(2.5));

        cache.put("Apple", BigDecimal.valueOf(10));

        assertEquals(1, cache.size());
        assertEquals(cache.get("Apple").get(), BigDecimal.valueOf(10));
    }

    @Test
    void givenTwoItemSizeCacheWithTwoItems_whenPuFirstItem_shouldOverrideFirstItem() {
        Cache<String, BigDecimal> cache = new LruCache<String, BigDecimal>(2);
        cache.put("Apple", BigDecimal.valueOf(2.5));
        cache.put("Microsoft", BigDecimal.valueOf(1.2));

        cache.put("Bananas", BigDecimal.valueOf(5));

        assertFalse(cache.get("Microsoft").isEmpty());
        assertFalse(cache.get("Bananas").isEmpty());
        assertTrue(cache.get("Apple").isEmpty());
    }

    @Test
    void givenTwoItemSizeCacheWithTwoItems_whenGeFirstItemAndPuFirstItem_shouldOverrideSecondItem() {
        Cache<String, BigDecimal> cache = new LruCache<String, BigDecimal>(2);
        cache.put("Apple", BigDecimal.valueOf(2.5));
        cache.put("Microsoft", BigDecimal.valueOf(1.2));

        cache.get("Apple");
        cache.put("Bananas", BigDecimal.valueOf(5));

        assertFalse(cache.get("Apple").isEmpty());
        assertFalse(cache.get("Bananas").isEmpty());
        assertTrue(cache.get("Microsoft").isEmpty());
    }
}
