import java.util.HashMap;
import java.util.Map;

/**
 * LRUCache - Implements a Least Recently Used Cache with O(1) time complexity.
 * It uses a HashMap for quick lookups and a Doubly-Linked List to track usage order.
 */
public class LRUCache {

    // Internal Node class for the Doubly-Linked List
    private static class Node {
        int key;
        int value;
        Node previous;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, Node> cacheMap;
    private final int capacity;
    private final Node head; // Marker node for the beginning (Most Recently Used)
    private final Node tail; // Marker node for the end (Least Recently Used)

    /**
     * Constructor sets up the cache with a defined size.
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        
        // Initialize the sentinel head and tail nodes
        head = new Node(0, 0); 
        tail = new Node(0, 0); 
        
        // Link head and tail together initially
        head.next = tail;
        tail.previous = head;
    }

    /**
     * Retrieves a value from the cache. Updates its position to Most Recently Used.
     * Time Complexity: O(1)
     */
    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            
            // Move node to the front (Most Recently Used)
            removeNode(node);
            addNodeToHead(node);
            
            return node.value;
        }
        return -1; // Not found
    }

    /**
     * Adds a key-value pair to the cache or updates an existing one.
     * Handles cache overflow by removing the Least Recently Used item.
     * Time Complexity: O(1)
     */
    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            // Update existing node
            Node node = cacheMap.get(key);
            node.value = value;
            
            // Update position to MRU
            removeNode(node);
            addNodeToHead(node);
        } else {
            // New node
            Node newNode = new Node(key, value);
            cacheMap.put(key, newNode);
            addNodeToHead(newNode);

            // Check capacity and remove LRU if exceeded
            if (cacheMap.size() > capacity) {
                Node tailNode = popTail();
                cacheMap.remove(tailNode.key);
            }
        }
    }
    
    // --- Doubly-Linked List Operations (O(1)) ---

    // Adds a node right after the head (MRU position)
    private void addNodeToHead(Node node) {
        node.next = head.next;
        node.previous = head;
        head.next.previous = node;
        head.next = node;
    }

    // Removes a node from its current position
    private void removeNode(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    // Removes and returns the node just before the tail (LRU position)
    private Node popTail() {
        Node result = tail.previous;
        removeNode(result);
        return result;
    }

    // --- Main Method for Testing ---
    public static void main(String[] args) {
        // Create a cache with a capacity of 2
        LRUCache cache = new LRUCache(2);

        System.out.println("--- LRU CACHE DEMO (CAPACITY=2) ---");
        
        cache.put(1, 10); // Cache: {1}
        cache.put(2, 20); // Cache: {2, 1} -> 2 is MRU
        System.out.println("Get(1): " + cache.get(1)); // Cache: {1, 2} -> 1 is MRU
        
        cache.put(3, 30); // Cache capacity reached. 2 is LRU and gets removed. Cache: {3, 1}
        System.out.println("Put(3, 30) executed. Cache size: " + cache.cacheMap.size());
        
        System.out.println("Get(2): " + cache.get(2)); // Returns -1 (2 was removed)
        
        cache.put(4, 40); // Cache capacity reached. 1 is LRU and gets removed. Cache: {4, 3}
        System.out.println("Put(4, 40) executed. Cache size: " + cache.cacheMap.size());
        
        System.out.println("Get(1): " + cache.get(1)); // Returns -1 (1 was removed)
    }
}