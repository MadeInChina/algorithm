package org.hanrw.array;

import com.sun.tools.javac.util.Assert;

/**
 * @author hanrw
 * 判断一个数是不是在bitMap里面
 * @date 2020/3/10 4:59 PM
 */
public class IntBitMapV2 {

  int[] tables;

  /**
   * 一个int占4byte
   * 一个byte等于 8 bit
   * 一个int有32位 就可以表示32个数据[0,31]
   * 如果要表示32所在位置的话,需要多开辟一个空间
   * 如果要存capacity个数据,那么需要开辟capacity/32个空间+ 1个空间
   * 0000 0000 0000 0000 0000 0000 0000 0000 [0~31]
   * 0000 0000 0000 0000 0000 0000 0000 0000 [32~63]
   * @param capacity
   */
  public IntBitMapV2(int capacity) {
    tables = new int[(capacity >> 5) + 1];
  }

  public static void main(String[] args) {
    IntBitMapV2 bitMap = new IntBitMapV2(100);
    bitMap.add(0);
    bitMap.add(9);
    bitMap.add(31);
    bitMap.add(32);

    Assert.check(bitMap.find(0));
    Assert.check(bitMap.find(9));
    Assert.check(bitMap.find(31));
    Assert.check(bitMap.find(32));
    Assert.check(!bitMap.find(10));
    Assert.check(!bitMap.find(50));
  }

  /**
   * bit查找元素方法
   * 1.查找对应的table
   * e.g 8,9和31都添加到了bitMap里面
   * 下面数据表示
   * 1000 0000 0000 0000 0000 0011 0000 0000
   * ^                          ^^
   * 31                         98
   * 如果查找的元素为31
   * 那么这个元素右移31为则数据表示为
   * 0000 0000 0000 0000 0000 0000 0000 0001
   * &
   * 0000 0000 0000 0000 0000 0000 0000 0001
   * =1
   * 则表示找到
   * @param number
   * @return 是否找到
   */
  private boolean find(int number) {
    int table = tables[indexForTable(number)];
    int bitLoc = number & 31;
    if ((table >> bitLoc & 1) == 1) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * bit添加元素方法
   * 1.查找对应的table
   * table: 2进制表示
   * 0000 0000 0000 0000 0000 0000 0000 0000
   * 2.添加元素,操作bit位,使得该bit位为1
   * e.g 添加31,31所在位置是: 31 % 32 = 31
   * 因为int为32位,是2的幂次方,所以可以使用31&(32-1)
   * table: 变为
   * 1000 0000 0000 0000 0000 0000 0000 0000
   * 即把1的二进制往右移动31位|原table的数据
   * 0000 0000 0000 0000 0000 0000 0000 0000
   * |
   * 1000 0000 0000 0000 0000 0000 0000 0000
   * =
   * 1000 0000 0000 0000 0000 0000 0000 0000
   *
   * @param number
   */
  private void add(int number) {
    int bitLoc = number & 31;
    tables[indexForTable(number)] |= 1 << bitLoc;
  }


  /**
   * 查询当前数据,所处于的table数组位置
   * data/32 == data>>5 因为2^5次方等于32
   * @param number
   * @return index
   */
  private int indexForTable(int number) {
    return number >> 5;
  }

}
