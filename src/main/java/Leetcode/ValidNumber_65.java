package Leetcode;

class ValidNumber_65 {
    /**
     * Validate if a given string can be interpreted as a decimal number.
     * Some examples:
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * " -90e3   " => true
     * " 1e" => false
     * "e3" => false
     * " 6e-1" => true
     * " 99e2.5 " => false
     * "53.5e93" => true
     * " --6 " => false
     * "-+3" => false
     * "95a54e53" => false
     */
    boolean isNumber(String s) {
        //使用正则表达式
        String post = s.trim();
        if (post.length() == 0) {
            return false;
        }
        return post.matches("[+-]?(([0-9]*\\.?[0-9]+)|([0-9]+\\.?[0-9]*))([eE][+-]?[0-9]+)?");
    }
}
