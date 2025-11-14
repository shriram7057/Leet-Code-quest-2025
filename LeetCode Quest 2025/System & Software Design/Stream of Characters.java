class StreamChecker {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private TrieNode root = new TrieNode();
    private StringBuilder stream = new StringBuilder();
    private int maxLen = 0;

    public StreamChecker(String[] words) {
        for (String w : words) {
            maxLen = Math.max(maxLen, w.length());

            TrieNode curr = root;
            for (int i = w.length() - 1; i >= 0; i--) {
                int idx = w.charAt(i) - 'a';
                if (curr.children[idx] == null)
                    curr.children[idx] = new TrieNode();
                curr = curr.children[idx];
            }
            curr.isEnd = true;
        }
    }

    public boolean query(char letter) {
        stream.append(letter);

        TrieNode curr = root;
        int limit = Math.min(stream.length(), maxLen);

        for (int i = stream.length() - 1; i >= stream.length() - limit; i--) {
            int idx = stream.charAt(i) - 'a';

            if (curr.children[idx] == null)
                return false;

            curr = curr.children[idx];

            if (curr.isEnd)
                return true;
        }

        return false;
    }
}
