package org.sandbox.collection.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sandbox.collection.cache.LruCache.DoubleLinkedList;
import org.sandbox.collection.cache.LruCache.Node;

class DoubleLinkedListTest {

    DoubleLinkedList<String, BigDecimal> list;
    Node<String, BigDecimal> appleNode = new Node<>("Apple", BigDecimal.valueOf(2.5));
    Node<String, BigDecimal> microsoftNode = new Node<>("Microsoft", BigDecimal.valueOf(1.2));
    Node<String, BigDecimal> bananaNode = new Node<>("Banana", BigDecimal.valueOf(5));

    @BeforeEach
    void setup() {
        list = new DoubleLinkedList<>();
    }

    @Test
    void givenAnyList_whenAddingANullNode_shouldComplain() {
        assertThrows(IllegalArgumentException.class, () -> list.addToHead(null));
    }

    @Test
    void givenAnEmptyList_whenAddingFirstNode_nodeShouldBeHeadAndTail() {
        list.addToHead(appleNode);

        assertEquals(appleNode, list.getHead());
        assertEquals(appleNode, list.getTail());
    }

    @Test
    void givenANonEmptyList_whenAddingSecondNode_secondNodeShouldBeHead() {
        list.addToHead(appleNode);

        list.addToHead(microsoftNode);

        assertEquals(microsoftNode, list.getHead());
        assertEquals(appleNode, list.getTail());
    }

    @Test
    void givenANonEmptyList_whenAddingThirdNode_thirdNodeShouldBeHeadAndFirstNodeShouldBeTail() {
        list.addToHead(appleNode);
        list.addToHead(microsoftNode);

        list.addToHead(bananaNode);
        assertEquals(bananaNode, list.getHead());
        assertEquals(appleNode, list.getTail());
    }

    @Test
    void givenAnyList_whenRemovingANullNode_shouldComplain() {
        assertThrows(IllegalArgumentException.class, () -> list.remove(null));
    }

    @Test
    void givenAnEmptyList_whenRemovingANode_shouldComplain() {
        assertThrows(IllegalStateException.class, () -> list.remove(appleNode));
    }

    @Test
    void givenAnyList_whenRemovingNonexistentNode_shouldHaveNoEffect() {
        list.addToHead(appleNode);

        list.remove(microsoftNode);

        assertEquals(appleNode, list.getHead());
        assertEquals(appleNode, list.getTail());
    }

    @Test
    void givenAOneNodeList_whenRemovingTheNode_shouldLeaveListEmpty() {
        list.addToHead(appleNode);

        list.remove(appleNode);

        assertTrue(list.isEmpty());
    }

    @Test
    void givenATwoNodeList_whenRemovingHead_shouldLeaveTail() {
        list.addToHead(appleNode);
        list.addToHead(microsoftNode);

        list.remove(appleNode);

        assertEquals(microsoftNode, list.getHead());
        assertEquals(microsoftNode, list.getTail());
    }

    @Test
    void givenATwoNodeList_whenRemovingTail_shouldLeaveHead() {
        list.addToHead(appleNode);
        list.addToHead(microsoftNode);

        list.remove(microsoftNode);

        assertEquals(appleNode, list.getHead());
        assertEquals(appleNode, list.getTail());
    }

    @Test
    void givenAThreeNodeList_whenRemovingMiddleNode_shouldLeaveHeadAndTail() {
        list.addToHead(appleNode);
        list.addToHead(microsoftNode);
        list.addToHead(bananaNode);

        list.remove(microsoftNode);

        assertEquals(bananaNode, list.getHead());
        assertEquals(appleNode, list.getTail());
    }

    @Test
    void givenAnEmptyList_whenRemovingTailNode_shouldComplain() {
        assertThrows(IllegalStateException.class, () -> list.removeTail());
    }

    @Test
    void givenANonEmptyList_whenRemovingTailNode_shouldReturnTheKeyOfRemovedNode() {
        list.addToHead(appleNode);

        String tailKey = list.removeTail();

        assertEquals("Apple", tailKey);
        assertTrue(list.isEmpty());
    }

    @Test
    void givenATwoNodeList_whenRemovingTailNode_remainingNodeShouldBeHeadAndTail() {
        list.addToHead(appleNode);
        list.addToHead(microsoftNode);

        list.removeTail();

        assertEquals(microsoftNode, list.getHead());
        assertEquals(microsoftNode, list.getTail());
    }
}
