package org.hanrw.util.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hanrw
 * @date 2020/4/22 3:44 PM
 */
public class LocalCache {

  /**
   * 缓存容器
   */
  private Map<String, String> cache;

  /**
   * 最后一次更新时间
   */
  long lastModified;
  private static long REFRESH_AFTER_30_MINS = 30 * 60 * 1000;

  /**
   * 构造初始化容器
   */
  public LocalCache() {
    this.cache = new HashMap<>();
    initCache();
  }

  private void initCache() {
    //初始化cache操作
  }

  /**
   * 添加元素到缓存容器方法
   */
  public void put(String key, String value) {
    cache.put(key, value);
    lastModified = System.currentTimeMillis();
  }

  /**
   * 获取在缓存容器里面的元素
   */
  public String get(String key) {
    refreshIfNecessary();
    return cache.get(key);
  }

  /**
   * 如果缓存上次更新时间超过30分钟,则需要刷新缓存
   */
  private void refreshIfNecessary() {
    if (System.currentTimeMillis() - lastModified > REFRESH_AFTER_30_MINS) {
       refresh();
     }
  }

  /**
   * 刷新缓存
   */
  private void refresh() {
    initCache();
  }
}
