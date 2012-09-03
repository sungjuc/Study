package lec.l29;

public class SimpleMap<K, V> implements Map<K, V> {
	private Set<Entry<K, V>> data;
	
	public SimpleMap() {
		data = new SimpleSet<Entry<K, V>>();
	}

	public int size() {
		return data.size();
	}

	public boolean containsKey(Object key) {
		Iterator<Entry<K, V>> it = data.iterator();
		
		while(it.hasNext()) {
			if(it.next().getKey().equals(key))
				return true;
		}
		return false;
	}

	public V get(Object key) {
		Iterator<Entry<K, V>> it = data.iterator();
		
		while(it.hasNext()) {
			Entry<K, V> entry = it.next();
			if(entry.getKey().equals(key))
				return entry.getValue();
		}

		return null;
	}

	public V put(K key, V value) {
		Iterator<Entry<K, V>> it = data.iterator();
		
		while(it.hasNext()) {
			Entry<K, V> entry = it.next();
			if(entry.getKey().equals(key)) {
				V oldVal = entry.getValue();
				entry.setValue(value);
				return oldVal;
			}

		}

		data.add(new Entry<K, V>(key, value));

		return null;
		
	}

	public V remove(Object key) {
		Iterator<Entry<K, V>> it = data.iterator();
		
		while(it.hasNext()) {
			Entry<K, V> entry = it.next();
			if(entry.getKey().equals(key)) {
				data.remove(entry);
				return entry.getValue();
			}
		}

		return null;
	}

	public String toString() {
		return data.toString();
	}

	public Set<K> keySet() {
		Set<K> set = new SimpleSet<K>();
		Iterator<Entry<K, V>> it = data.iterator();
		
		while(it.hasNext()) {
			set.add(it.next().getKey());
		}

		return set;
	}
}