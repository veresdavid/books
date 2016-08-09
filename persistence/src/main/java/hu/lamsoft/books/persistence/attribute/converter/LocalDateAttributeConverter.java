package hu.lamsoft.books.persistence.attribute.converter;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by ui2016 on 2016.08.09..
 */

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

  @Override
  public Date convertToDatabaseColumn(LocalDate localDate) {

    if (localDate == null) {
      return null;
    } else {
      return Date.valueOf(localDate);
    }

  }

  @Override
  public LocalDate convertToEntityAttribute(Date date) {

    if (date == null) {
      return null;
    } else {
      return date.toLocalDate();
    }

  }

}
