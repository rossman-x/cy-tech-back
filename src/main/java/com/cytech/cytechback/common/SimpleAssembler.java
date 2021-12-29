package com.cytech.cytechback.common;

import java.util.List;

/**
 * SimpleAssembler interface
 * 
 * @author rosman
 *
 * @param <T> T
 * @param <V> V
 */
public interface SimpleAssembler<T extends SimpleDto, V> {

	/**
	 * ToDto
	 * 
	 * @param document document
	 * @return T
	 */
	T toDto(V document);

	/**
	 * FromDto
	 * 
	 * @param dto dto
	 * @return V
	 */
	V fromDto(T dto);

	/**
	 * ToDtoList
	 * 
	 * @param documentList the document list
	 * @return list of T
	 */
	List<T> toDtoList(List<V> documentList);

	/**
	 * FromDtoList
	 * 
	 * @param dtoList the dto list
	 * @return list of V
	 */
	List<V> fromDtoList(List<T> dtoList);
}
