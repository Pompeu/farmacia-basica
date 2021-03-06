package br.edu.ifgoiano.farmacia.dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Id;

/**
 *
 * @author pompeu
 */
public class RefletionObjeto {

    private RefletionObjeto() {
    }
    
    public static Integer getIdObjeto(Object object) {
        Class<? extends Object> clazz = object.getClass();
        Integer id = null;
        for(Field atributo : clazz.getDeclaredFields()){
            atributo.setAccessible(true);
            for (Annotation annotation : atributo.getDeclaredAnnotations()){
                if(annotation.annotationType() == Id.class){
                    try {
                        id = (Integer) atributo.get(object);
                    } catch (IllegalArgumentException | IllegalAccessException ex) {
                        Logger.getLogger(RefletionObjeto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return id;
    }
}