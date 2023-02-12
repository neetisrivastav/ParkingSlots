package collection;

import java.util.*;
class HashMapInternalImp {

    private ArrayList<HashNode> bucketArray;
    private int numBuckets;
    private int size;

    public HashMapInternalImp() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;
        for(int i = 0; i <numBuckets; i++)
            bucketArray.add(null);
    }
    public int size(){
        return size;
    }
    private final int hashcode(int key){
        return Objects.hashCode(key);
    }
    private int getBucketIndex(int key){
        int hashcode = hashcode(key);
        int index = hashcode % numBuckets;
        index = index < 0 ? index * -1: index;
        return index;
    }
    void put(int key, int value) {
        int bucketIndex = getBucketIndex(key);
        int hashcode = hashcode(key);
        HashNode head = bucketArray.get(bucketIndex);
        while(head != null){
            if((head.key==key) && hashcode == head.hashcode){
                head.value = value;
                return;
            }
            head = head.next;
        }
        LinkedList linkedList = new LinkedList();

        size++;
        head = bucketArray.get(bucketIndex);
        HashNode newNode = new HashNode(key,value,hashcode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
        if((1.0 * size)/numBuckets >= 0.7){
            ArrayList<HashNode> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for(int i = 0; i<numBuckets; i++)
                bucketArray.add(null);
            for(HashNode node : temp){
                while(node != null){
                    put(node.key,node.value);
                    node = node.next;
                }
            }

        }

    }

    int get(int key) {
        int bucketIndex = getBucketIndex(key);
        int hashcode = hashcode(key);
        HashNode head = bucketArray.get(bucketIndex);
        while(head != null){
            if((head.key==key) && hashcode == head.hashcode)
                return head.value;
            head = head.next;
        }
        return -1;
    }

    void remove(int key) {
        int bucketIndex = getBucketIndex(key);
        int hashcode = hashcode(key);
        HashNode head = bucketArray.get(bucketIndex);
        HashNode prev = null;
        while(head != null){
            if((head.key==key) && hashcode == head.hashcode)
                break;
            prev = head;
            head = head.next;
        }
        if(head == null)
            return ;
        size--;
        if(prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex,head.next);

    }
    static class HashNode{
        int key;
        int value;
        final int hashcode;
        HashNode next;
        public HashNode(int key, int value, int hashcode){
            this.key = key;
            this.value = value;
            this.hashcode = hashcode;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */