package utils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import annotation.EnumField;

/**
 * Servlet utils created to manipulate servlet actions. 
 * 
 * @author pedholivera
 */
public abstract class ServletUtils {

	/**
	 * Create a new object that have informations in {@link HttpServletRequest}.
	 * 
	 * @param req Request
	 * @param clazz Object class
	 * @return
	 */
	public static <T> T getObjectFromRequest(HttpServletRequest req, Class<T> clazz) {
		try {
			T object = clazz.newInstance();
			List<Field> fields = getFieldsFromClass(clazz);
			for(Field field : fields) {
				if(field.isAnnotationPresent(EnumField.class)) {
					assignFieldEnumValue(req, field, object);
				} else {
					assignFieldValue(req, field, object);					
				}
			}
			return object;
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException();
		}
	}
	
	private static <T> void assignFieldValue(HttpServletRequest req, Field field, T object) throws IllegalArgumentException, IllegalAccessException {
		String fieldName = field.getName();
		Class<?> fieldType = field.getType();
		Object parametro = fieldType.cast(req.getParameter(fieldName));
		field.setAccessible(true);
		field.set(object, parametro);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T> void assignFieldEnumValue(HttpServletRequest req, Field field, T object) throws IllegalArgumentException, IllegalAccessException {
		String fieldName = field.getName();
		Class<Enum> fieldType = (Class<Enum>) field.getType();
		Object parametro = Enum.valueOf(fieldType, req.getParameter(fieldName));
		field.setAccessible(true);
		field.set(object, parametro);
	}
	
	private static <T> List<Field> getFieldsFromClass(Class<T> clazz) {
		return Stream.of(clazz.getDeclaredFields())
						.filter(f -> !f.getName().equals("serialVersionUID"))
						.collect(Collectors.toList());
	}
}
