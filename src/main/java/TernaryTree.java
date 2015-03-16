import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class TernaryTree<K extends Comparable<K>> implements Iterable<K> {

    private Node<K> root;


    /**
     * Convenience constructor
     *
     * @param keys all the keys to add to this tree
     */
    public TernaryTree(K... keys) {
        for (K key : keys) {
            put(key);
        }
    }

    /**
     * Add a key to this tree
     *
     * @param key the key to add
     */
    public void put(K key) {
        if (root == null)
            root = new Node<>(key);
        else
            root.insert(key);
    }

    public void put(K... keys) {
        for (K key : keys) {
            put(key);
        }
    }


    public void delete(K key) {
        if (root != null) {
            root.delete(key);
            // must be done here as when you're inside root you don't know you're root!
            if (!root.hasChildren())
                root = null;
        }
    }

    public void delete(K... keys) {
        for (K key : keys) {
            delete(key);
        }
    }

    @Override
    public Iterator<K> iterator() {
        return dfs().iterator();
    }

    public Node<K> getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public List<K> dfs() {
        List<Node<K>> dfs = dfs(root, new LinkedList<>());
        return dfs.stream().map(Node::getKey).collect(toList());
    }

    private List<Node<K>> dfs(Node<K> n, List<Node<K>> nodes) {

        if (n != null) {
            if (n.getLeft() != null) {
                dfs(n.getLeft(), nodes);
            }
            if (n.getCenter() != null) {
                dfs(n.getCenter(), nodes);
            }
            if (n.getRight() != null) {
                dfs(n.getRight(), nodes);
            }
            nodes.add(n);
        }
        return nodes;
    }
}
