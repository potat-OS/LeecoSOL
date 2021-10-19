import java.util.Arrays;

public class WordDictionary {

    // 维护一个字符串数组
    private String[] container = {};
    // add指针位置
    private int index;
    // 容器大小
    private int size;

    public WordDictionary() {
        this.index = 0;
        this.size = 0;
    }

    // 添加操作
    public void addWord(String word) {
        // 指针大于维护的数组长度时自增
        if (index == container.length) {
            this.container = grow();
        }
        container[index] = word;
        this.index++;
        this.size++;
    }

    // 查询操作
    public boolean search(String word) {
        for (int i = 0; i < this.size; i++) {
            if (iEqual(word, container[i])) {
                return true;
            }
        }
        return false;
    }

    // 类似ArrayList自增操作
    private String[] grow() {
        int oldCapacity = container.length == 0 ? 10 : container.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - oldCapacity + 1 <= 0) {
            newCapacity = oldCapacity + 1;
        }
        return Arrays.copyOf(container, newCapacity);
    }

    // 比较两字符串
    private boolean iEqual(String word, String dict) {
        int wordLen = word.length();
        int dictLen = dict.length();
        // 长度不同直接返回false
        if (wordLen != dictLen) {
            return false;
        }
        // equals进行值比较
        if (word.equals(dict)) {
            return true;
            // 值不同说明有'.', 进行相应判断
        } else {
            for (int i = 0; i < wordLen; i++) {
                if (word.charAt(i) != dict.charAt(i) && word.charAt(i) != '.' && dict.charAt(i) != '.') {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
     * = obj.search(word);
     */
    public static void main(String[] args) {
        String[] words = { "bad", "dad", "med", "pad", "b..", "..d" };
        WordDictionary wordDict = new WordDictionary();
        for (int i = 0; i < words.length; i++) {
            if (i < 3) {
                wordDict.addWord(words[i]);
            } else {
                System.out.println(wordDict.search(words[i]));
            }
        }
    }
}
