package org.hanrw.array;

/**
 * @author hanrw
 * @date 2020/3/10 4:59 PM
 */
public class IntBitMap {

  /**
   * 1个byte 等于8 bit
   * 1个int等于 4 byte 等于 32 bit
   * 1个int如果用bit来表示数据的话,可以表示[0, 31]个数据
   */
  private int[] ints;

  /**
   * 如果一个数列有[0~32]个数据 那么第32个数据所储存的位置是在
   *  32/32 = 1 表示在下标为1的元素里面
   *  32%32 = 0 表示在下标为0的元素里面
   *  既ints[1]的第一个元素里面
   * 0000 0000 0000 0000 0000 0000 0000 0000 [0~31]
   * 0000 0000 0000 0000 0000 0000 0000 0000 [32~63]
   * @param max 最大数据量大小
   */
  public IntBitMap(int max) {
    ints = new int[max / 32 + 1];
  }

  /**
   * 以二进制的方式添加数据
   * 如果添加的数据是1
   * 数据所在ints里面的元素: 1/32 = 0 等于n>>4 右移4位
   * 数据所在bit里面的位置: 1%32 = 1
   * 将bit里面下标为1的元素设置成1
   * 既 二进制运算 0|1<<
   * 0000 0000 0000 0000 0000 0000 0000 0000
   * |
   * 0000 0000 0000 0000 0000 0000 0000 0010
   *
   * 0000 0000 0000 0000 0000 0000 0000 0010
   * @param n
   */
  public void add(int n){
    /**
     * 1个int表示32个元素
     * 数据所在ints里面的位置 n/32
     * 数据所在bit里面的位置 n%32
     */
    int index = n>>5;

    int bitLoc = n % 32;
    /**
     * 因为需要操作的是bit位,所以不能用十进制的方法直接赋值ints[index] = 1 << (n % 32),这样是操作的int数据而不是bit
     * 数据会被覆盖
     * 操作方法使用或运算
     * 0000 0000 0000 0000 0000 0000 0000 0000
     * |
     * 0000 0000 0000 0000 0000 0000 0000 0010
     * 结果
     * 0000 0000 0000 0000 0000 0000 0000 0010
     */
    ints[index] |= 1 << bitLoc;
//    System.out.println(Integer.toBinaryString(ints[index]));
  }

  /**
   * 查找是否存在
   * @param n
   * 找到n所在的位置
   * 右移到最右边和1相与(只有同时都为1,则返回1) 1的高位都是0,相当于不参加计算
   * 0000 0000 0000 0000 0000 0000 0000 0010 右移一位
   * &
   * 0000 0000 0000 0000 0000 0000 0000 0001
   * 如果相等返回1 否则返回0
   * @return
   */
  public boolean find(int n){
    int index = n>>5;

    int bitLoc = n % 32;
    /**
     * 如果插入的数是1,那么二进制格式如下
     * 0000 0000 0000 0000 0000 0000 0000 0010
     * bitLoc等于1
     * 右移1位
     */
    int target= ints[index] >> bitLoc;

//    System.out.println(Integer.toBinaryString(target));
    int flag = target & 1;
    if (flag == 1) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    IntBitMap bitMap = new IntBitMap(100);
    bitMap.add(1);
    bitMap.add(15);
    bitMap.add(99);
    System.out.println(bitMap.find(1));//true
    System.out.println(bitMap.find(15));//true
    System.out.println(bitMap.find(99));//true
    System.out.println(bitMap.find(5));//false
  }

}
