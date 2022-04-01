package carnerero.agustin.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<E,D> {
	//Conversion desde entidad a Dto
	public abstract D fromEntity(E entity);
	//Conversion desde Dto a entidad
	public abstract E fromDTO(D dto);
	
	public List<D>fromEntity(List<E>entities){
		return entities.stream().map(e->fromEntity(e)).collect(Collectors.toList());
		
	}
	public List<E>fromDTO(List<D>dtos){
		return dtos.stream().map(dto->fromDTO(dto)).collect(Collectors.toList());
		
	}
}
