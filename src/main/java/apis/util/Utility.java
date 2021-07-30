package apis.util;

import java.lang.reflect.Field;

public class Utility<T> {
	public void mergeNonNullFields(T destination, T source) {
		for (Field field : source.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			String name = field.getName();
			Object value = null;
			try{
			value = field.get(source);
			}
			catch(IllegalAccessException iae) {
			}
			if (value != null) {
				try {
				Field destField = destination.getClass().getDeclaredField(name);
				destField.setAccessible(true);
				destField.set(destination, value);
				}
				catch(Exception ex) {	
				}
			}
		}
	}
}
