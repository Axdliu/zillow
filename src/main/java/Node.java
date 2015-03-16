import java.util.LinkedList;
import java.util.List;



public class Node<K extends Comparable<K>> {
    private K key;

    private Node<K> left;
    private Node<K> center;
    private Node<K> right;

    public Node(K key) {
        this.key = key;
    }

    /**
     * Convenience constructor to reduce SLOC
     *
     * @param thisKey this nodes key
     * @param lNode   left node
     * @param cNode   center node
     * @param rNode   right node
     */
    public Node(K thisKey, Node<K> lNode, Node<K> cNode, Node<K> rNode) {
        this.key = thisKey;
        this.left = lNode;
        this.center = cNode;
        this.right = rNode;

    }


    @Override
    /**
     * Override allows for easier debug
     */
    public String toString() {
        return "" + key;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node))
            return false;
        Node<K> other = (Node<K>) obj;
        List<K> me = dfs(this,new LinkedList<>());
        List<K> miniMe = dfs(other,new LinkedList<>());

        return me.equals(miniMe);
    }
    private List<K> dfs(Node<K> n, List<K> keys) {

        if (n != null) {
            if (n.getLeft() != null) {
                dfs(n.getLeft(), keys);
            }
            if (n.getCenter() != null) {
                dfs(n.getCenter(), keys);
            }
            if (n.getRight() != null) {
                dfs(n.getRight(), keys);
            }
            keys.add(n.key);
        }
        return keys;
    }


    public Node<K> getCenter() {
        return center;
    }


    public K getKey() {
        return key;
    }

    public Node<K> getLeft() {
        return left;
    }


    public Node<K> getRight() {
        return right;
    }


    /**
     * It's really only necessary to find either the lowest or highest branch leaf
     * as equality is essentially a linked list and the other condition can be presumed
     *
     * @return minimal leaf node
     */
    private Node<K> findMinNode() {
        // since this could be a tail recursion we can substitute a loop
        Node<K> min = this;
        while (min.left != null)
            min = min.left;
        return min;
    }

    public Node<K> delete(K key) {
        // base case
        return delete(this, key);
    }

    private Node<K> delete(Node<K> n, K key) {
        Node<K> result = n;
        if (n != null) {
            if (n.key.compareTo(key) > 0) {
                n.left = delete(n.left, key);
            } else if (n.key.compareTo(key) == 0) {
                if (n.center != null) {
                    n.center = delete(n.center, key);
                } else if (n.right != null) {
                    Node<K> minNode = n.right.findMinNode();
                    n.key = minNode.key;
                    n.right = delete(n.right, minNode.key);
                } else {
                    // left is either higher or null -- either works
                    result = n.left;
                }
            } else {
                n.right = delete(n.right, key);
            }
        }
        return result;
    }

    private Node<K> insert(Node<K> n, K key) {
        // this method may seem unnecessary but it allows us to create new
        // nodes without checking L,C,R for null individually
        if (n != null) {
            if (n.key.compareTo(key) > 0) {
                n.left = insert(n.left, key);
            } else if (n.key.compareTo(key) == 0) {
                n.center = insert(n.center, key);
            } else {
                n.right = insert(n.right, key);
            }
        } else
            n = new Node<K>(key);
        return n;
    }

    public Node<K> insert(K key) {
        return insert(this, key);
    }

    public boolean hasChildren() {
        return left != null || center != null || right != null;
    }

}