# Information
主要用于记录在LeetCode-CN上刷题的代码，JAVA版  

# 更改
从IDEA转入VSCode，因为LeetCode插件
## idea插件生成模版
* 文件名
```
$!velocityTool.camelCaseName(${question.titleSlug})
```
* 代码生成模版
```
package idea.leetcode.editor.cn;

${question.content}

public class $!velocityTool.camelCaseName(${question.titleSlug}){
    Solution solution = new Solution();
    public void test() {

    }
    public static void main(String[] args) {
        $!velocityTool.camelCaseName(${question.titleSlug}) mainClass = new $!velocityTool.camelCaseName(${question.titleSlug})();
        mainClass.test();
    }
    ${question.code}
}
```