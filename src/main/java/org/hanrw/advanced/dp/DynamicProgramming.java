package org.hanrw.advanced.dp;

/**
 * @author hanrw
 * @date 2020/3/11 5:43 PM
 * 动态规划一般步骤:
 * 1.确定状态
 *    -最后一步
 *    -子问题
 * 2.转移方程
 * 3.初始条件和边界情况
 * 4.计算顺序
 *
 * Coin change
 *  - 你有三种硬币, 面值分别为2元, 5元和7元. 每种硬币都有足够多
 *  - 买一本书需要27元
 *  - 使用最少多少枚硬币能够正好付清,而不需要找钱
 */
public class DynamicProgramming {
  /**
   * 第一步: 确定状态
   *  虽然现在还不知道最优策略是什么,但是一定有a1+a2+......+ak枚硬币的面额等于27
   *  - 最后一步是什么: 不管怎么样,都有[最后]一枚硬币ak, 假设就是最优策略所以(27-ak)的硬币数量一定是最少,否则就不是最优策略了
   *  - 子问题就变成: 求 (27-ak) +1 的最小值
   * 第二步: 转移方程
   * 因为有三种面额:2,5,7
   * 那么(27-ak)+1可以有三种形式
   *  - (27-2)+1(一枚5元硬币)
   *  - (27-5)+1(一枚2元硬币)
   *  - (27-7)+1(一枚7元硬币)
   *  转移方程:
   *  f(27) = min{f(27-2)+1,f(27-5)+1,f(27-7)+1}
   *  f(X)  = min{f(X-2)+1,f(X-5)+1,f(X-7)+1}
   * 第三步: 初始值和边界情况
   *  - 初始值 f(0) = 0;
   *          f(1) = min{f(1-2)+1, f(1-5)+1 , f(1-7)+1} 负数表示无法拼出用无穷大表示
   *  - 边界情况
   */

  public static void main(String[] args) {
    System.out.println(dpMin(new int[]{2, 5, 7}, 27));
  }

  /**
   * 返回所需要最少数量的硬币
   * @param coins 不同面额的硬币组合
   * @param price 价格
   * @return
   */
  public static int dpMin(int[] coins, int price) {

    /**
     * new int[price] 下标表示0到26, 要表示27需要 new int[price + 1]
     */
    int[] f = new int[price + 1];
    //初始条件 默认 f[0] = 0
    /**
     * 因为f(0)=0
     * 从下标为1的数据开始遍历
     */
    for (int x = 1; x <= price; x++) {
      f[x] = Integer.MAX_VALUE;
      for (int coinIndex = 0; coinIndex < coins.length; coinIndex++) {
        //边界条件
        if (x >= coins[coinIndex] && f[x - coins[coinIndex]] != Integer.MAX_VALUE) {
          //转移方程
          f[x] = Math.min(f[x - coins[coinIndex]] + 1, f[x]);
        }
      }
      if (f[price] == Integer.MAX_VALUE) {
        //没能找到能组合序列
        return -1;
      }
    }

    return f[price];
  }

}
