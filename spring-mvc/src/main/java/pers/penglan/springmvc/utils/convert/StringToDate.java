package pers.penglan.springmvc.utils.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将字符串转换为Date
 *
 * @Author PENGL
 * 2020-03-09
 */
public class StringToDate implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat;
        if (source != null ) {
            simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        } else {
            throw new RuntimeException("String 转换成 Date 时，发现 String 为null");
        }
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("类型转换时发生错误", e);
        }

    }
}
