package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

class SimplifyPath_71 {

    String simplifyPath(String path) {
        Deque<String> buffer = new LinkedList<>();
        buffer.add("/");
        String[] pathElements = path.split("/");
        for (String e : pathElements) {
            if (isPathName(e)) {
                if (!buffer.peekLast().equals("/")) {
                    buffer.addLast("/");
                }
                buffer.addLast(e);
            } else if (e.equals("..")) {
                if (!buffer.peekLast().equals("/")) {
                    buffer.removeLast();
                } else if (buffer.peekLast().equals("/") && buffer.size() > 1) {
                    buffer.removeLast();
                    buffer.removeLast();
                }
            } else if (e.equals(".")) {
                continue;
            } else if (!e.equals("")) {
                if (!buffer.peekLast().equals("/")) {
                    buffer.addLast("/");
                }
                buffer.addLast(e);
            }
        }
        StringBuilder result = new StringBuilder();
        if (buffer.size() > 1 && buffer.peekLast().equals("/")) {
            buffer.pollLast();
        }
        while (!buffer.isEmpty()) {
            result.append(buffer.pollFirst());
        }

        return result.toString();
    }

    private boolean isPathName(String e) {
        return e.matches("[a-zA-Z]+");
    }
}
