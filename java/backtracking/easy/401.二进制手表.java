import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 *
 * https://leetcode-cn.com/problems/binary-watch/description/
 *
 * algorithms
 * Easy (47.44%)
 * Likes:    62
 * Dislikes: 0
 * Total Accepted:    3.9K
 * Total Submissions: 8.2K
 * Testcase Example:  '0'
 *
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * 
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 
 * 
 * 
 * 例如，上面的二进制手表读取 “3:25”。
 * 
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * 
 * 案例:
 * 
 * 
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16",
 * "0:32"]
 * 
 * 
 * 
 * 注意事项:
 * 
 * 
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 
 * 
 */
class Solution {

    List<String> res = new ArrayList<>();
    boolean[] use = {false,false,false,false,false,false,false,false,false,false};
    int[] numbers = {1,2,4,8,1,2,4,8,16,32};

    public String handleDate(){
        int sum_h = 0;
        int sum_m = 0;
        for(int i = 0;i<use.length;i++){
            if(!use[i])
                continue;
            if(i<4)
                sum_h += numbers[i];
            else
                sum_m += numbers[i];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sum_h+":");
        if(sum_m < 10){
            stringBuilder.append("0"+sum_m);
        }else{
            stringBuilder.append(sum_m);
        }
        return stringBuilder.toString();
    }

    public boolean valid(){
        int sum_h = 0;
        int sum_m = 0;
        for(int i = 0;i<use.length;i++){
            if(!use[i])
                continue;
            if(i<4)
                sum_h += numbers[i];
            else
                sum_m += numbers[i];
        }
        return sum_h <= 11 && sum_m <= 59;
    }

    public void dfs(int num, int step, int start){
        if(step == num){
            res.add(handleDate());
            return;
        }
        for(int i = start;i<numbers.length;i++){
            use[i] = true;
            if(!valid()){
                use[i] = false;
                continue;
            }
            dfs(num, step + 1, i + 1);
            use[i] = false;
        }
    } 

    public List<String> readBinaryWatch(int num) {
        dfs(num, 0, 0);
        return this.res;
    }
}

