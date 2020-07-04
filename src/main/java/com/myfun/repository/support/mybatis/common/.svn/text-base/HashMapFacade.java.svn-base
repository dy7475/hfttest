package com.myfun.repository.support.mybatis.common;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.http.converter.HttpMessageNotReadableException;

import com.myfun.utils.StringUtil;
/**
 * Map的外观类
 * @author flj
 * @param <K>
 * @param <V>
 */
public class HashMapFacade<K,V> implements Map<K, V>{
	private Map<K,V> map;
	public HashMapFacade(Map<K,V> map) {
		this.map = map;
	}
	/**
	 * 返回字符串值
	 * @param key
	 * @return
	 */
	public String getString(String key){
		Object object = map.get(key);
		if(null != object) {
			return String.valueOf(object);
		}
		return null;
	}
	
	/**
	 * 返回字符串值
	 * 检查参数如果为空将抛出HttpMessageNotReadableException异常
	 * @param key
	 * @return
	 */
	public String getStringCheck(String key){
		String result = getString(key);
		if(result == null){
			throw new HttpMessageNotReadableException("Unrecognized field \""+key+"\"");
		}
		return result;
	}
	
	/**
	 * 返回整形值
	 * 检查参数如果为空将抛出HttpMessageNotReadableException异常
	 * @param key
	 * @return
	 */
	public Integer getIntegerCheck(String key) {
		Integer result = getInteger(key, null);
		if(result == null){
			throw new HttpMessageNotReadableException("Unrecognized field \""+key+"\"");
		}
		return result;
	}
	
	/**
	 * 返回整形值，没有返回空
	 * @param key
	 * @return
	 */
	public Integer getInteger(String key) {
		return getInteger(key, null);
	}
	
	/**
	 * 返回整形值，没有defVal
	 * @param key
	 * @return
	 */
	public Integer getInteger(String key, Integer defVal) {
		return StringUtil.parseInteger(map.get(key) + "", defVal);
	}

	@Override
	public int size() {
		return map.size();
	}
	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}
	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}
	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}
	@Override
	public V get(Object key) {
		return map.get(key);
	}
	@Override
	public V put(K key, V value) {
		return map.put(key, value);
	}
	@Override
	public V remove(Object key) {
		return map.remove(key);
	}
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		putAll(m);
	}
	@Override
	public void clear() {
		map.clear();
	}
	@Override
	public Set<K> keySet() {
		return map.keySet();
	}
	@Override
	public Collection<V> values() {
		return map.values();
	}
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return map.entrySet();
	}
	@Override
	public V getOrDefault(Object key, V defaultValue) {
		return map.getOrDefault(key, defaultValue);
	}
	@Override
	public void forEach(BiConsumer<? super K, ? super V> action) {
		map.forEach(action);
	}
	@Override
	public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
		map.replaceAll(function);
	}
	@Override
	public V putIfAbsent(K key, V value) {
		return map.putIfAbsent(key, value);
	}
	@Override
	public boolean remove(Object key, Object value) {
		return map.remove(key, value);
	}
	@Override
	public boolean replace(K key, V oldValue, V newValue) {
		return map.replace(key, oldValue, newValue);
	}
	@Override
	public V replace(K key, V value) {
		return map.replace(key, value);
	}
	@Override
	public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
		return map.computeIfAbsent(key, mappingFunction);
	}
	@Override
	public V computeIfPresent(K key,
			BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return map.computeIfPresent(key, remappingFunction);
	}
	@Override
	public V compute(K key,
			BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return map.compute(key, remappingFunction);
	}
	@Override
	public V merge(K key, V value,
			BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
		return map.merge(key, value, remappingFunction);
	}
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("student", "student");
		HashMapFacade<String,String> mapFacade = new HashMapFacade<String,String>(map);
		System.out.println(mapFacade.getString("student"));
	}
	 
}
