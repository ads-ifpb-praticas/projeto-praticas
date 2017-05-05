
package br.edu.ifpb.praticas.projeto.entidades;

import java.sql.Time;
import java.time.LocalTime;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Edilva
 */
@Converter(autoApply = true)
public class ConvertLocalTime implements AttributeConverter<LocalTime, Time>{

    @Override
    public Time convertToDatabaseColumn(LocalTime attribute) {
        if(attribute == null) return null;
        return Time.valueOf(attribute);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time dbTime) {
        if(dbTime == null) return null;
        return dbTime.toLocalTime();
    }
    
}
