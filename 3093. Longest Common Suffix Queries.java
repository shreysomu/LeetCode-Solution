class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];

        int index = -1;
        int length = Integer.MAX_VALUE;
    }

    TrieNode root = new TrieNode();

    // Update best answer at node
    private void updateNode(TrieNode node, int wordLen, int idx) {

        if (wordLen < node.length ||
           (wordLen == node.length && idx < node.index)) {

            node.length = wordLen;
            node.index = idx;
        }
    }

    // Insert reversed word into Trie
    private void insert(String word, int idx) {

        TrieNode node = root;

        updateNode(node, word.length(), idx);

        for (int i = word.length() - 1; i >= 0; i--) {

            char ch = word.charAt(i);
            int pos = ch - 'a';

            if (node.children[pos] == null) {
                node.children[pos] = new TrieNode();
            }

            node = node.children[pos];

            updateNode(node, word.length(), idx);
        }
    }

    // Query best matching suffix
    private int search(String word) {

        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {

            char ch = word.charAt(i);
            int pos = ch - 'a';

            if (node.children[pos] == null) {
                break;
            }

            node = node.children[pos];
        }

        return node.index;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        // Build Trie
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        // Process queries
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}
