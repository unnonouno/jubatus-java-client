package us.jubat.common.type;

import java.util.Map;

public class TMap<K, V> implements TType<Map<K, V>> {
	private final TType<K> keyType;
	private final TType<V> valueType;

	public TMap(TType<K> keyType, TType<V> valueType) {
		this.keyType = keyType;
		this.valueType = valueType;
	}

	public void check(Map<K, V> value) {
		if (value == null)
			throw new NullPointerException();
		for (Map.Entry<K, V> e : value.entrySet()) {
			keyType.check(e.getKey());
			valueType.check(e.getValue());
		}
	}

}
