package co.edu.icesi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import co.edu.icesi.back.model.Userr;
import co.edu.icesi.back.service.interfaces.UserrService;

@WritingConverter
public class StringToUserrConverter implements Converter<String, Userr> {

	private UserrService userrService;
	
	@Autowired
	public StringToUserrConverter(UserrService userrService) {
		this.userrService = userrService;
	}
	
	@Override
	public Userr convert(String source) {
		return userrService.getUserrById(Long.parseLong(source));
	}

}
