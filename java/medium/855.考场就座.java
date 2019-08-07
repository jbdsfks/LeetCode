/*
 * @lc app=leetcode.cn id=855 lang=java
 *
 * [855] 考场就座
 *
 * https://leetcode-cn.com/problems/exam-room/description/
 *
 * algorithms
 * Medium (25.89%)
 * Likes:    13
 * Dislikes: 0
 * Total Accepted:    416
 * Total Submissions: 1.6K
 * Testcase Example:  '["ExamRoom","seat","seat","seat","seat","leave","seat"]\n[[10],[],[],[],[],[4],[]]'
 *
 * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 * 
 * 
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在
 * 0 号座位上。)
 * 
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int
 * （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用
 * ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"],
 * [[10],[],[],[],[],[4],[]]
 * 输出：[null,0,9,4,2,null,5]
 * 解释：
 * ExamRoom(10) -> null
 * seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
 * seat() -> 9，学生最后坐在 9 号座位上。
 * seat() -> 4，学生最后坐在 4 号座位上。
 * seat() -> 2，学生最后坐在 2 号座位上。
 * leave(4) -> null
 * seat() -> 5，学生最后坐在 5 号座位上。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= N <= 10^9
 * 在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
 * 保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。
 * 
 * 
 */
class ExamRoom {

    int size;
    TreeSet<Integer> seat_set;

    public ExamRoom(int N) {
        this.size = N;
        this.seat_set = new TreeSet<>();
    }

    public int seat() {
        int seat_index = 0;
        if (seat_set.size() == 1) {
            seat_index = seat_set.first() > (this.size / 2) ? 0 : this.size - 1;
        } else if (!seat_set.isEmpty()) {
            int nearest_index = seat_set.first();
            int max_sub;
            if (nearest_index >= (this.size - 1) - seat_set.last()) {
                max_sub = nearest_index;
                seat_index = 0;
            } else {
                max_sub = (this.size - 1) - seat_set.last() - 1;
                seat_index = this.size - 1;
            }
            for (Integer s : seat_set) {

            }
            while (seat_set.higher(nearest_index) != null) {
                int temp_index = (nearest_index + seat_set.higher(nearest_index)) / 2;
                if (max_sub < temp_index - nearest_index) {
                    seat_index = temp_index;
                    max_sub = temp_index - nearest_index;
                }
                nearest_index = seat_set.higher(nearest_index);
            }
        }
        seat_set.add(seat_index);
        return seat_index;
    }

    public void leave(int p) {
        seat_set.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such: ExamRoom obj =
 * new ExamRoom(N); int param_1 = obj.seat(); obj.leave(p);
 */
